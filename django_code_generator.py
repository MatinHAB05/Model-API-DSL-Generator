import os
import re

class DjangoCodeGenerator:
    def __init__(self):
        self.models_code = []
        self.views_code = []
        self.urls_code = []
        self.admin_code = []
        
        self.registered_models = []

    def generate(self, root_node):
        self._reset_buffers()
        
        self._scan_models(root_node)

        self._init_imports()

        self._traverse(root_node)

        self.urls_code.append("]")

        for model in self.registered_models:
            self.admin_code.append(f"admin.site.register({model})")

        return {
            "models.py": "\n".join(self.models_code),
            "views.py": "\n\n".join(self.views_code),
            "urls.py": "\n".join(self.urls_code),
            "admin.py": "\n".join(self.admin_code),
            "__init__.py": "" 
        }

    def _reset_buffers(self):
        self.models_code = []
        self.views_code = []
        self.urls_code = []
        self.admin_code = []
        self.registered_models = []

    def _scan_models(self, node):
        if hasattr(node, 'value') and node.value.get('type') == 'model':
            self.registered_models.append(node.value['content'])
        
        if hasattr(node, 'children'):
            for child in node.children:
                self._scan_models(child)

    def _init_imports(self):
        # --- Models Imports ---
        self.models_code.append("from django.db import models")
        self.models_code.append("from django.core.validators import MinValueValidator, MaxValueValidator, RegexValidator")
        self.models_code.append("from django.core.exceptions import ValidationError")
        self.models_code.append("from django.utils.translation import gettext_lazy as _")
        self.models_code.append("import datetime , time") 
        self.models_code.append("\n# Generated Models")

        # --- Views Imports ---
        self.views_code.append("import json")
        self.views_code.append("from django.http import JsonResponse, HttpResponse, HttpResponseBadRequest")
        self.views_code.append("from django.views.decorators.csrf import csrf_exempt")
        self.views_code.append("from django.db.models import Q, Count, Sum, Avg")
        self.views_code.append("from .models import *")
        
        # --- URLs Imports ---
        self.urls_code.append("from django.urls import path")
        self.urls_code.append("from . import views")
        self.urls_code.append("\nurlpatterns = [")

        # --- Admin Imports ---
        self.admin_code.append("from django.contrib import admin")
        self.admin_code.append("from .models import *")

    def _traverse(self, node):
        if not hasattr(node, 'value'): return

        node_type = node.value.get('type')
        
        if node_type == "start-program":
            for child in node.children:
                self._traverse(child)
                
        elif node_type == "model":
            self._handle_model(node)
            
        elif node_type == "enum":
            self._handle_enum(node)
            
        elif node_type == "endpoint":
            self._handle_endpoint(node)
    
    # ==========================================
    #              MODEL GENERATION
    # ==========================================
    def _handle_model(self, node):
        model_name = node.value['content']
        
        self.models_code.append(f"\nclass {model_name}(models.Model):")
        
        has_fields = False
        model_custom_validators = []

        for child in node.children:
            if child.value['type'] == "model-entry":
                f_name, f_validators = self._handle_model_field(child)
                has_fields = True
                if f_validators:
                    model_custom_validators.append((f_name, f_validators))
        
        if not has_fields:
            self.models_code.append("    pass")
            
        self.models_code.append(f"\n    def __str__(self):")
        self.models_code.append(f"        return f'{model_name} object ({{self.pk}})'")

        if model_custom_validators:
            self._generate_clean_method(model_custom_validators)

    def _handle_model_field(self, node):
        field_name = node.value['content']
        type_node = node.children[0]
        annotations = node.children[1:] if len(node.children) > 1 else []
        
        django_type, kwargs, custom_validators = self._map_field_type_and_annotations(type_node, annotations)
        
        args_str = ""
        if 'to' in kwargs:
            args_str = f"'{kwargs.pop('to')}', "

        kwargs_str = ", ".join([f"{k}={v}" for k, v in kwargs.items()])
        full_params = f"{args_str}{kwargs_str}"
        
        field_def = f"    {field_name} = {django_type}({full_params})"
        self.models_code.append(field_def)
        
        return field_name, custom_validators

    def _map_field_type_and_annotations(self, type_node, annotations):
        ft_content = type_node.value['content']
        ft_type = type_node.value['type']
        
        django_type = "models.CharField"
        kwargs = {}
        custom_validators = []
        field_kind = None 

        if ft_content == 'String':
            django_type = "models.CharField"
            kwargs['max_length'] = '255'
            field_kind = 'string'
        elif ft_content == 'Int':
            django_type = "models.IntegerField"
            field_kind = "int"
        elif ft_content == 'Boolean':
            django_type = "models.BooleanField"
            field_kind = "bool"
        elif ft_content == 'Date':
            django_type = "models.DateField"
            field_kind = "date"
        elif ft_content == 'DateTime':
            django_type = "models.DateTimeField"
            field_kind = "datetime"
        elif ft_content == 'Time':
            django_type = "models.TimeField"
            field_kind = "time"
        elif ft_content == 'Double':
            django_type = "models.FloatField"
            field_kind = "float"
        elif ft_type == "custom-field-type":
            django_type = "models.CharField"
            kwargs['max_length'] = '50'
            kwargs['choices'] = f"{ft_content}.choices"
            field_kind = "enum"

        validators_list = []
        
        for anno in annotations:
            a_type = anno.value['type']
            
            if a_type == "annotation-pk":
                kwargs['primary_key'] = 'True'
            elif a_type == "annotation-unique":
                kwargs['unique'] = 'True'
            elif a_type in ["annotation-nullable", "annotation-null"]:
                kwargs['null'] = 'True'
                kwargs['blank'] = 'True'
            elif a_type == "annotation-non-nullable":
                kwargs['null'] = 'False'
                kwargs['blank'] = 'False'
            
            elif a_type == "annotation-foreign-key":
                ref_model = anno.children[0].value['content']
                django_type = "models.ForeignKey"
                kwargs['to'] = ref_model 
                kwargs['on_delete'] = 'models.CASCADE'
                
            elif a_type in ("annotation-validation-min", "annotation-validation-max"):
                raw_val = anno.children[0].value['content']
                clean_val = raw_val.replace('"', '').replace("'", "")
                
                val = clean_val

                if field_kind == 'date':
                    val = f"datetime.date.fromisoformat('{clean_val}')"

                if field_kind == "time" :
                    try:
                        hour, minute = map(int, clean_val.split(":"))
                        val = f"datetime.time({hour}, {minute})"
                    except:
                        val = f"'{clean_val}'"

                if a_type.endswith('min'):
                    validators_list.append(f"MinValueValidator({val})")
                else:
                    validators_list.append(f"MaxValueValidator({val})")

            elif a_type == "annotation-validation-wildpattern":
                pattern = anno.children[0].value['content'].replace("'", "").replace('"', "")
                validators_list.append(f"RegexValidator(regex=r'{pattern}', message='Invalid format')")
            
            elif a_type == "annotation-validation-include":
                values = [c.value['content'] for c in anno.children]
                custom_validators.append({'type': 'include', 'values': values})
            elif a_type == "annotation-validation-exclude":
                values = [c.value['content'] for c in anno.children]
                custom_validators.append({'type': 'exclude', 'values': values})

        if validators_list:
            kwargs['validators'] = f"[{', '.join(validators_list)}]"
            
        return django_type, kwargs, custom_validators

    def _generate_clean_method(self, model_validators):
        self.models_code.append(f"\n    def clean(self):")
        self.models_code.append(f"        super().clean()")
        
        for field_name, validators in model_validators:
            self.models_code.append(f"        val_{field_name} = getattr(self, '{field_name}', None)")
            self.models_code.append(f"        if val_{field_name} is not None:")
            
            for v in validators:
                vals_clean = []
                for x in v['values']:
                    clean_x = str(x).replace("'", "").replace('"', "")
                    vals_clean.append(f"'{clean_x}'")
                
                vals_str = ", ".join(vals_clean)
                
                if v['type'] == 'include':
                    self.models_code.append(f"            if str(val_{field_name}) not in [{vals_str}]:")
                    self.models_code.append(f"                raise ValidationError({{ '{field_name}': \"Value must be one of: {vals_str}\" }})")
                
                elif v['type'] == 'exclude':
                    self.models_code.append(f"            if str(val_{field_name}) in [{vals_str}]:")
                    self.models_code.append(f"                raise ValidationError({{ '{field_name}': \"Value cannot be: {vals_str}\" }})")
        
        self.models_code.append(f"\n    def save(self, *args, **kwargs):")
        self.models_code.append(f"        self.full_clean()")
        self.models_code.append(f"        super().save(*args, **kwargs)")


    # ==========================================
    #               ENUM LOGIC
    # ==========================================
    def _handle_enum(self, node):
        self.models_code.append(f"\nclass {node.value['content']}(models.TextChoices):")
        for child in node.children:
            val = child.value['content'].replace('"', '').replace("'", "")
            self.models_code.append(f"    {val.upper()} = '{val}', '{val}'")
    
    # ==========================================
    #            ENDPOINT & VIEWS
    # ==========================================

    def _handle_endpoint(self, node):
        op_id = "unnamed_op"
        method = "GET"
        raw_url = ""
        block_node = None

        for child in node.children:
            t = child.value['type']

            if t == 'variable-name':
                op_id = child.value['content']

            elif t == 'http-method':
                method = child.value['content']

            elif t == 'generic-value':
                raw_url = child.value['content'].replace('"', '')

            elif t in ('endpoint-block', 'response-block'):
                block_node = child

        # ---------------- URL ----------------
        django_url = raw_url.lstrip('/')
        url_params = re.findall(r'\{(.*?)\}', django_url)

        for param in url_params:
            django_url = django_url.replace(f"{{{param}}}", f"<str:{param}>")

        self.urls_code.append(
            f"    path('{django_url}', views.{op_id}, name='{op_id}'),"
        )

        # ---------------- VIEW ----------------
        view_args = ["request"] + url_params
        self.views_code.append("@csrf_exempt")
        self.views_code.append(f"def {op_id}({', '.join(view_args)}):")
        self.views_code.append(f"    if request.method != '{method}':")
        self.views_code.append(
            "        return JsonResponse({'error': 'Method not allowed'}, status=405)"
        )

        if not block_node:
            self.views_code.append("    return JsonResponse({'status': 'ok'})")
            return

        if block_node.value['type'] == 'response-block':
            self._handle_response_content(block_node)
        else:
            self._process_endpoint_block(block_node)


    def _process_endpoint_block(self, block_node):
        response_generated = False

        for child in block_node.children:
            node_type = child.value['type']

            # ---------- INPUT ----------
            if node_type == 'input-block':
                self.views_code.append("    try:")
                self.views_code.append(
                    "        body = json.loads(request.body) if request.body else {}"
                )
                self.views_code.append("    except Exception:")
                self.views_code.append(
                    "        return HttpResponseBadRequest('Invalid JSON')"
                )

            # ---------- RESPONSE ----------
            elif node_type == 'response-block':
                self._handle_response_content(child)
                response_generated = True

        if not response_generated:
            self.views_code.append("    return JsonResponse({'status': 'ok'})")


    def _handle_response_content(self, response_node):
        for child in response_node.children:
            c_type = child.value['type']

            # -------- RELATIONAL --------
            if c_type == 'relational-codes':
                self._handle_relational_logic(child)
                return

            # -------- SIMPLE MODEL / VARIABLE --------
            elif c_type == 'variable-name':
                name = child.value['content']

                # response : User ;
                if name in self.registered_models:
                    self.views_code.append(
                        f"    return JsonResponse(list({name}.objects.all().values()), safe=False)"
                    )
                else:
                    self.views_code.append(
                        f"    return JsonResponse({name}, safe=False)"
                    )
                return

        self.views_code.append("    return JsonResponse({'status': 'no content'})")


    def _handle_relational_logic(self, relational_node):
        self.views_code.append("    # Relational Logic")
        
        statements = relational_node.children
        last_var_generated = None
        explicit_return_done = False

        for i, stmt in enumerate(statements):
            op = stmt.value['content'].strip()
            print("here")

            # 1. Assignment: x = ...
            if op == "=":
                var_name = stmt.children[0].value['content']
                expr = stmt.children[1]
                code = self._transpile_expression(expr)
                self.views_code.append(f"    {var_name} = {code}")
                last_var_generated = var_name

            # 2. Explicit Return: -> ...
            elif op == "->":
                expr = stmt.children[0]
                code = self._transpile_expression(expr)
                self._generate_final_return(code)
                explicit_return_done = True
                break 

            # 3. Implicit Expression (e.g., Union(r1, r2) without assignment)
            else:
                code = self._transpile_expression(stmt)
                temp_var = f"res_{i}"
                self.views_code.append(f"    {temp_var} = {code}")
                last_var_generated = temp_var

        
        if not explicit_return_done:
            if last_var_generated:
                self._generate_final_return(last_var_generated)
            else:
                self.views_code.append("    return JsonResponse({'status': 'done without return'})")

    def _generate_final_return(self, result_expr):
        print("i am here")
        self.views_code.append(f"    final_result = {result_expr}")
        
        self.views_code.append("    if hasattr(final_result, 'values'):")
        self.views_code.append("        final_result = list(final_result.values())")
        
        self.views_code.append("    elif hasattr(final_result, '_meta'):")
        self.views_code.append("        final_result = {k: v for k, v in final_result.__dict__.items() if not k.startswith('_')}")
        
        self.views_code.append("    return JsonResponse(final_result, safe=False)")
        # print(self.views_code)



    # ==========================================
    #            TRANSPILER ENGINE
    # ==========================================
    def _transpile_expression(self, node):
        val = node.value['content']
        typ = node.value['type']

        if typ == 'variable-name':
            if val in self.registered_models:
                return f"{val}.objects.all()"
            return val 
        
        elif typ == 'generic-value':
            if val.isdigit() or (val.startswith('-') and val[1:].isdigit()):
                return val
            if val == 'True' or val == 'False':
                return val
            return val

        elif typ == 'built-in-function':
            return self._transpile_builtin(val, node.children)
            
        return val

    def _transpile_builtin(self, func_name, children):
        # 1. SELECT: Select<age > 10>(User)
        if func_name == 'Select':
            source_node = children[-1] 
            source_code = self._transpile_expression(source_node)
            
            filter_parts = []
            for cond_node in children[:-1]:
                print(cond_node)
                f_str = self._transpile_condition(cond_node)
                if f_str: filter_parts.append(f_str)
            
            filter_args = ", ".join(filter_parts)
            return f"{source_code}.filter({filter_args})"

        # 2. PROJECT: Project<name, email>(User)
        elif func_name == 'Project':
            source_node = children[-1]
            source_code = self._transpile_expression(source_node)
            
            fields = []
            for c in children[:-1]:
                content = c.value['content']
                fields.append(f"'{content}'")
            return f"{source_code}.values({', '.join(fields)})"

        # 3. JOIN: Join_inner<id, uid>(User, Profile)
        elif 'Join' in func_name:
            src1_node = children[-2]
            src2_node = children[-1]
            
            keys = [c.value['content'] for c in children[:-2]]
            key1 = keys[0]
            key2 = keys[1] if len(keys) > 1 else key1
            
            src1_code = self._transpile_expression(src1_node)
            src2_code = self._transpile_expression(src2_node)
            
            code = (
                f"[{{**item1, **item2}} "
                f"for item1 in (list({src1_code}) if not hasattr({src1_code}, 'values') else list({src1_code}.values())) "
                f"for item2 in (list({src2_code}) if not hasattr({src2_code}, 'values') else list({src2_code}.values())) "
                f"if str(item1.get('{key1}')) == str(item2.get('{key2}'))]"
            )
            return code

        # 4. LEN: Len(User)
        elif func_name == 'Len':
            src_code = self._transpile_expression(children[0])
            return f"({src_code}.count() if hasattr({src_code}, 'count') else len({src_code}))"

        # 5. LIMIT: Limit<0, 10>(User)
        elif func_name == 'Limit':
            source_node = children[-1]
            src_code = self._transpile_expression(source_node)
            
            params = [self._transpile_expression(c) for c in children[:-1]]
            
            start = params[0] if len(params) > 0 and params[0] != 'None' else "0"
            stop = params[1] if len(params) > 1 and params[1] != 'None' else ""
            step = params[2] if len(params) > 2 and params[2] != 'None' else ""
            
            slice_str = f"[{start}:{stop}"
            if step: slice_str += f":{step}"
            slice_str += "]"
            
            return f"{src_code}{slice_str}"
        
        elif func_name == "Orderby" :
            source_node = children[-1]
            source_code = self._transpile_expression(source_node)
            field = children[1].value['content']
            is_desc = children[2].value['content'] if len(children) > 2 else "False"
            prefix = "-" if is_desc == "True" else ""
            return f"{source_code}.order_by('{prefix}{field}')"
        
        elif func_name == 'Union':
            left = self._transpile_expression(children[0])
            right = self._transpile_expression(children[1])
            return f"{left}.union({right})"
        
        elif func_name == 'Intersection':
            left = self._transpile_expression(children[0])
            right = self._transpile_expression(children[1])
            return f"{left}.intersection({right})"
        
        elif func_name == 'Difference':
            left = self._transpile_expression(children[0])
            right = self._transpile_expression(children[1])
            return f"{left}.difference({right})"

        elif func_name == 'Cartesian':
            left = self._transpile_expression(children[0])
            right = self._transpile_expression(children[1])
            return (
                f"[{{**a, **b}} "
                f"for a in list({left}.values()) "
                f"for b in list({right}.values())]"
            )


        return "None"
    
    def _transpile_math_expression(self, node):
        t = node.value['type']
        val = node.value['content']

        if t in ('generic-value', 'variable-name'):
            return val

        if t == 'binary-operation':
            op = val
            left = self._transpile_math_expression(node.children[0])
            right = self._transpile_math_expression(node.children[1])
            return f"({left} {op} {right})"

        return ""


    def _transpile_condition(self, node):
        if node.value['type'] != 'binary-operation':
            return ""

        op = node.value['content']
        field = node.children[0].value['content']
        value_expr = self._transpile_math_expression(node.children[1])

        lookup = "exact"
        if op == 'lst': lookup = "lt"
        elif op == 'grt': lookup = "gt"
        elif op == 'lsteq': lookup = "lte"
        elif op == 'grteq': lookup = "gte"

        if lookup == "exact":
            return f"{field}={value_expr}"
        return f"{field}__{lookup}={value_expr}"
