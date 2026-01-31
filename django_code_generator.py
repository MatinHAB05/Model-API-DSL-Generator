import os

class DjangoCodeGenerator:
    def __init__(self):
        self.models_code = []
        self.views_code = []
        self.urls_code = []
        self.admin_code = []
        self.serializers_code = []
        
        self.registered_models = []

    def generate(self, root_node):
        """
        Start point for creating the code from AST.
        """
        self._reset_buffers()
        self._init_imports()

        self._traverse(root_node)

        self.urls_code.append("]")

        # Register models in admin
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

    def _init_imports(self):
        # --- Models Imports ---
        self.models_code.append("from django.db import models")
        self.models_code.append("from django.core.validators import MinValueValidator, MaxValueValidator, RegexValidator")
        self.models_code.append("from django.core.exceptions import ValidationError")
        self.models_code.append("from django.utils.translation import gettext_lazy as _")
        self.models_code.append("import datetime") 
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
        self.registered_models.append(model_name)
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
            elif a_type == "annotation-nullable":
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
                val = raw_val

                if field_kind == 'date':
                    if '-' in raw_val:
                        from_py = f"datetime.date.fromisoformat('{raw_val}')"
                        val = from_py 
                
            
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
        """
        تولید متد clean() استاندارد جنگو برای چک کردن Include و Exclude
        """
        self.models_code.append(f"\n    def clean(self):")
        self.models_code.append(f"        super().clean()")
        
        for field_name, validators in model_validators:
            self.models_code.append(f"        val_{field_name} = getattr(self, '{field_name}', None)")
            self.models_code.append(f"        if val_{field_name} is not None:")
            
            for v in validators:
                vals_clean = []
                for x in v['values']:
                    if str(x).isdigit() or str(x).lower() in ['true', 'false']:
                         vals_clean.append(str(x))
                    else:
                        clean_x = str(x).replace("'", "").replace('"', "")
                        vals_clean.append(f"'{clean_x}'")
                
                vals_str = ", ".join(vals_clean)
                
                if v['type'] == 'include':
                    self.models_code.append(f"            if val_{field_name} not in [{vals_str}]:")
                    self.models_code.append(f"                raise ValidationError({{ '{field_name}': 'Value must be one of: {vals_str}' }})")
                
                elif v['type'] == 'exclude':
                    self.models_code.append(f"            if val_{field_name} in [{vals_str}]:")
                    self.models_code.append(f"                raise ValidationError({{ '{field_name}': 'Value cannot be: {vals_str}' }})")
        
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