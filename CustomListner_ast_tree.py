from gen.backendgrammerListener import backendgrammerListener
from gen.backendgrammerParser import backendgrammerParser
from ast_tree import AST_Tree
from helper_functions.handling_build_ast_nodes_in_Listner import *
# This class defines a complete listener for a parse tree produced by backendgrammerListener.
class AST_Listener(backendgrammerListener):
    def __init__(self):
        self.ast = AST_Tree()
    

    # Exit a parse tree produced by backendgrammerParser#compileinit.
    def exitCompileinit(self, ctx:backendgrammerParser.CompileinitContext):
        child_count = ctx.getChildCount()
        value = None
        children = [x.val for x in ctx.getChildren()]
        if child_count==0 :
            value = self.ast.set_value_obj(content="start-program",type="start-program")
            self.ast.root = ctx.val = self.ast.build_new_node(value=value,children=children,parent=None)

        elif child_count == 1:
            self.ast.root = ctx.val = children[0]

        elif child_count>1 :
            value = self.ast.set_value_obj(content="start-program",type="start-program")
            self.ast.root = ctx.val = self.ast.build_new_node(value=value,children=children,parent=None)


############################################################################################################################
############################################################################################################################
################################################## MODEL AREA ##############################################################
############################################################################################################################
############################################################################################################################

    # Exit a parse tree produced by backendgrammerParser#modelrole.
    def exitModelrole(self, ctx:backendgrammerParser.ModelroleContext):
        children = [x.val for x in ctx.modelenyty()]
        value = self.ast.set_value_obj(content=ctx.modelname().getText(), type="model")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    # Exit a parse tree produced by backendgrammerParser#modelname.
    def exitModelname(self, ctx:backendgrammerParser.ModelnameContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)



    # Exit a parse tree produced by backendgrammerParser#modelenyty.
    def exitModelenyty(self, ctx:backendgrammerParser.ModelenytyContext):
        children = [ctx.fieldtype().val]
        anno_children = [
            y
            for x in ctx.fieldannotaion()
            for y in (x.temp_children if is_exist_child_in_parent(x, "validoption") else [x.val])
        ]
        children += anno_children
        value = self.ast.set_value_obj(content=ctx.fieldname().getText(), type="model-entry")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)



    # Exit a parse tree produced by backendgrammerParser#fieldname.
    def exitFieldname(self, ctx:backendgrammerParser.FieldnameContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)

    # Exit a parse tree produced by backendgrammerParser#fieldtype.
    def exitFieldtype(self, ctx:backendgrammerParser.FieldtypeContext):
        if is_exist_child_in_parent(ctx,"variablename") :
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
            ctx.val.value['type'] = "custom-field-type"
        else :
            directly_raw_value(self.ast,ctx,ctx)
            ctx.val.value['type'] = "generic-field-type"


    # Exit a parse tree produced by backendgrammerParser#fieldannotaion.
    def exitFieldannotaion(self, ctx:backendgrammerParser.FieldannotaionContext):
        if is_exist_child_in_parent(ctx,"validoption") :
            ctx.temp_children = ctx.validoption().temp_children
        else:
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)



    # Exit a parse tree produced by backendgrammerParser#fkoption.
    def exitFkoption(self, ctx:backendgrammerParser.FkoptionContext):
        children = [ctx.modelname().val , ctx.fieldname().val]
        value = self.ast.set_value_obj(content="annotation-foreign-key", type="annotation-foreign-key")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)


    # Exit a parse tree produced by backendgrammerParser#validoption.
    def exitValidoption(self, ctx:backendgrammerParser.ValidoptionContext):
        children = [x.val for x in ctx.validoptionparameter()]
        ctx.temp_children = children

    
    

    # Exit a parse tree produced by backendgrammerParser#validoptionparameter.
    def exitValidoptionparameter(self, ctx:backendgrammerParser.ValidoptionparameterContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)

    # Exit a parse tree produced by backendgrammerParser#exclude_validoptionparameter.
    def exitExclude_validoptionparameter(self, ctx:backendgrammerParser.Exclude_validoptionparameterContext):
        children = [x.val for x in ctx.genericvalue()]
        value = self.ast.set_value_obj(content="annotation-validation-exclude", type="annotation-validation-exclude")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)
    

    # Exit a parse tree produced by backendgrammerParser#include_validoptionparameter.
    def exitInclude_validoptionparameter(self, ctx:backendgrammerParser.Include_validoptionparameterContext):
        children = [x.val for x in ctx.genericvalue()]
        value = self.ast.set_value_obj(content="annotation-validation-include", type="annotation-validation-include")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    # Exit a parse tree produced by backendgrammerParser#wildpattern_validoptionparameter.
    def exitWildpattern_validoptionparameter(self, ctx:backendgrammerParser.Wildpattern_validoptionparameterContext):
        children = [ctx.stringvalue().val]
        value = self.ast.set_value_obj(content="annotation-validation-wildpattern", type="annotation-validation-wildpattern")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    # Exit a parse tree produced by backendgrammerParser#min_validoptionparameter.
    def exitMin_validoptionparameter(self, ctx:backendgrammerParser.Min_validoptionparameterContext):
        children = [ctx.genericvalue().val]
        value = self.ast.set_value_obj(content="annotation-validation-min", type="annotation-validation-min")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    
    

    # Exit a parse tree produced by backendgrammerParser#max_validoptionparameter.
    def exitMax_validoptionparameter(self, ctx:backendgrammerParser.Max_validoptionparameterContext):
        children = [ctx.genericvalue().val]
        value = self.ast.set_value_obj(content="annotation-validation-max", type="annotation-validation-max")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)


    # Exit a parse tree produced by backendgrammerParser#uniqueoption.
    def exitUniqueoption(self, ctx:backendgrammerParser.UniqueoptionContext):
        directly_raw_value(self.ast, ctx, ctx)
        ctx.val.value['type'] = "annotation-unique"


    # Exit a parse tree produced by backendgrammerParser#nulloption.
    def exitNulloption(self, ctx:backendgrammerParser.NulloptionContext):
        directly_raw_value(self.ast, ctx, ctx)
        ctx.val.value['type'] = "annotation-null" if ctx.val.value['content']=="nullable" else "annotation-non-nullable"


    # Exit a parse tree produced by backendgrammerParser#pkoption.
    def exitPkoption(self, ctx:backendgrammerParser.PkoptionContext):
        directly_raw_value(self.ast, ctx, ctx)
        ctx.val.value['type'] = "annotation-pk"

############################################################################################################################
############################################################################################################################
################################################## ENUM AREA ###############################################################
############################################################################################################################
############################################################################################################################

    # Exit a parse tree produced by backendgrammerParser#enumrole.
    def exitEnumrole(self, ctx:backendgrammerParser.EnumroleContext):
        children = ctx.getChild(3).temp_children
        value = self.ast.set_value_obj(content=ctx.enumname().getText(), type="enum")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    # Exit a parse tree produced by backendgrammerParser#enumname.
    def exitEnumname(self, ctx:backendgrammerParser.EnumnameContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
    

    # Exit a parse tree produced by backendgrammerParser#enumblock.
    def exitEnumblock(self, ctx:backendgrammerParser.EnumblockContext):
        if ctx.getChildCount()==1 :
            ctx.temp_children = [ctx.getChild(0).val]
        else :
            children = [x.val for x in ctx.enumitem()]
            ctx.temp_children = children
    
    

    # Exit a parse tree produced by backendgrammerParser#enumitem.
    def exitEnumitem(self, ctx:backendgrammerParser.EnumitemContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)


############################################################################################################################
############################################################################################################################
################################################## END POINT AREA ##########################################################
############################################################################################################################
############################################################################################################################

    # Exit a parse tree produced by backendgrammerParser#endpointrule.
    def exitEndpointrule(self, ctx:backendgrammerParser.EndpointruleContext):
        children = [ctx.getChild(x).val for x in [1,3,4,6]]
        value = self.ast.set_value_obj(content="endpoint", type="endpoint")
        ctx.val = self.ast.build_new_node(value=value, children=children, parent=None)

    # Exit a parse tree produced by backendgrammerParser#operationId.
    def exitOperationId(self, ctx:backendgrammerParser.OperationIdContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)

    # Exit a parse tree produced by backendgrammerParser#htttpMethod.
    def exitHtttpMethod(self, ctx:backendgrammerParser.HtttpMethodContext):
        directly_raw_value(self.ast,ctx.GET_KEY(),ctx)
        ctx.val.value['type'] = "http-method"




    
    

    # Exit a parse tree produced by backendgrammerParser#endpointurl.
    def exitEndpointurl(self, ctx:backendgrammerParser.EndpointurlContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)

    # Exit a parse tree produced by backendgrammerParser#endpoinblock.
    def exitEndpoinblock(self, ctx:backendgrammerParser.EndpoinblockContext):
        if not is_exist_child_in_parent(ctx,"inputblock") :
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)

        else:
            children = [ctx.getChild(x).val for x in range(0,ctx.getChildCount(),2)]
            value = self.ast.set_value_obj(content="endpoint-block",type="endpoint-block")
            ctx.val = self.ast.build_new_node(value=value,children=children,parent=None)
    
    

    # Exit a parse tree produced by backendgrammerParser#responseblock.
    def exitResponseblock(self, ctx:backendgrammerParser.ResponseblockContext):
        ctx.val = self.ast.build_new_node(value=self.ast.set_value_obj("response-block", "response-block"),
                                          children=[ctx.getChild(2).val],
                                          parent=None
                                          )


    
    

    # Exit a parse tree produced by backendgrammerParser#responseblock_inner.
    def exitResponseblock_inner(self, ctx:backendgrammerParser.Responseblock_innerContext):
        if is_exist_child_in_parent(ctx,"modelname") :
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
        else :
            directly_child_to_parent(self.ast, ctx.getChild(2), ctx)




    
    

    # Exit a parse tree produced by backendgrammerParser#relationalcode.
    def exitRelationalcode(self, ctx:backendgrammerParser.RelationalcodeContext):
        if not is_exist_child_in_parent(ctx,"define_variable_relational") :
            directly_child_to_parent(self.ast, ctx.getChild(1), ctx)
        else :
            children = []
            value = self.ast.set_value_obj(content="relational-codes",type="relational-codes")
            all_define_variable_relational = ctx.define_variable_relational()
            for item_ctx in all_define_variable_relational :
                children.append(item_ctx.val)
            children.append(ctx.expr_relational().val)
            ctx.val = self.ast.build_new_node(value=value,children=children,parent=None)


    # Exit a parse tree produced by backendgrammerParser#define_variable_relational.
    def exitDefine_variable_relational(self, ctx:backendgrammerParser.Define_variable_relationalContext):
        binary_operation(self.ast,ctx,ctx.getChild(1),ctx.getChild(0),ctx.getChild(2))



    
    

    # Exit a parse tree produced by backendgrammerParser#expr_relational.
    def exitExpr_relational(self, ctx:backendgrammerParser.Expr_relationalContext):
        directly_child_to_parent(self.ast, ctx.getChild(0), ctx)



    
    

    # Exit a parse tree produced by backendgrammerParser#term_relational.
    def exitTerm_relational(self, ctx:backendgrammerParser.Term_relationalContext):
        if ctx.getChildCount() == 1:
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
        else:
            binary_operation(self.ast, ctx, ctx.getChild(1), ctx.getChild(0), ctx.getChild(2))

    # Exit a parse tree produced by backendgrammerParser#idom_relational.
    def exitIdom_relational(self, ctx:backendgrammerParser.Idom_relationalContext):

        if  ctx.getChildCount()==1 :
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
        else :
            binary_operation(self.ast, ctx, ctx.getChild(1), ctx.getChild(0), ctx.getChild(2))


    # Exit a parse tree produced by backendgrammerParser#factor_relational.
    def exitFactor_relational(self, ctx:backendgrammerParser.Factor_relationalContext):

        if is_exist_child_in_parent(ctx,"variablename") or is_exist_child_in_parent(ctx,"genericvalue"):
            directly_child_to_parent(self.ast, ctx.getChild(0), ctx)
        else :
            directly_child_to_parent(self.ast, ctx.getChild(1), ctx)

    
    

    # Exit a parse tree produced by backendgrammerParser#inputblock.
    def exitInputblock(self, ctx:backendgrammerParser.InputblockContext):
        ctx.val = self.ast.build_new_node(value=self.ast.set_value_obj("input-block","input-block"),
                                          children= [ctx.getChild(2).val],
                                          parent=None
                                          )


    
    

    # Exit a parse tree produced by backendgrammerParser#jsonstring.
    def exitJsonstring(self, ctx:backendgrammerParser.JsonstringContext):
        directly_child_to_parent(self.ast,ctx.getChild(0),ctx)

    # Exit a parse tree produced by backendgrammerParser#built_in_functions_relational.
    def exitBuilt_in_functions_relational(self, ctx:backendgrammerParser.Built_in_functions_relationalContext):
        children = list()
        name_of_built_in_function = ctx.getChild(0).getText()
        base_children , main_children = extract_baseInput_and_mainInput(ctx,name_of_built_in_function)
        children = base_children + main_children
        value = self.ast.set_value_obj(content=name_of_built_in_function , type="built-in-function")
        ctx.val = self.ast.build_new_node(value=value,children=children,parent=None)

        # Exit a parse tree produced by backendgrammerParser#key_value_pair_select_relational.
    def exitKey_value_pair_select_relational(self, ctx:backendgrammerParser.Key_value_pair_select_relationalContext):
        binary_operation(self.ast,ctx,ctx.getChild(1),ctx.getChild(0),ctx.getChild(2))
    # Exit a parse tree produced by backendgrammerParser#binary_logical_operation.
    def exitBinary_logical_operation(self, ctx:backendgrammerParser.Binary_logical_operationContext):
        directly_raw_value(self.ast, ctx, ctx)

    # Exit a parse tree produced by backendgrammerParser#genericvalue.

############################################################################################################################
############################################################################################################################
################################################## SHARED RULES AREA #######################################################
############################################################################################################################
############################################################################################################################
    def exitGenericvalue(self, ctx:backendgrammerParser.GenericvalueContext):
        directly_child_to_parent(self.ast,ctx.getChild(0),ctx)


    
    

    # Exit a parse tree produced by backendgrammerParser#intvalue.
    def exitIntvalue(self, ctx:backendgrammerParser.IntvalueContext):
        directly_raw_value(self.ast,ctx,ctx)


    
    

    # Exit a parse tree produced by backendgrammerParser#stringvalue.
    def exitStringvalue(self, ctx:backendgrammerParser.StringvalueContext):
        directly_raw_value(self.ast, ctx, ctx)

    # Exit a parse tree produced by backendgrammerParser#booleanvalue.
    def exitBooleanvalue(self, ctx:backendgrammerParser.BooleanvalueContext):
        directly_raw_value(self.ast, ctx, ctx)



    

    # Exit a parse tree produced by backendgrammerParser#variablename.
    def exitVariablename(self, ctx:backendgrammerParser.VariablenameContext):
        directly_raw_value(self.ast,ctx,ctx)
        ctx.val.value['type'] = "variable-name"



