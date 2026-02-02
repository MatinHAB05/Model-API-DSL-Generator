# Generated from C:/Users/MSI/Pictures/CompilerProjcet/pythonProject1/backendgrammer.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .backendgrammerParser import backendgrammerParser
else:
    from backendgrammerParser import backendgrammerParser

# This class defines a complete generic visitor for a parse tree produced by backendgrammerParser.

class backendgrammerVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by backendgrammerParser#compileinit.
    def visitCompileinit(self, ctx:backendgrammerParser.CompileinitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#modelrole.
    def visitModelrole(self, ctx:backendgrammerParser.ModelroleContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#modelname.
    def visitModelname(self, ctx:backendgrammerParser.ModelnameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#modelenyty.
    def visitModelenyty(self, ctx:backendgrammerParser.ModelenytyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#fieldname.
    def visitFieldname(self, ctx:backendgrammerParser.FieldnameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#fieldtype.
    def visitFieldtype(self, ctx:backendgrammerParser.FieldtypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#fieldannotaion.
    def visitFieldannotaion(self, ctx:backendgrammerParser.FieldannotaionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#fkoption.
    def visitFkoption(self, ctx:backendgrammerParser.FkoptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#validoption.
    def visitValidoption(self, ctx:backendgrammerParser.ValidoptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#validoptionparameter.
    def visitValidoptionparameter(self, ctx:backendgrammerParser.ValidoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#exclude_validoptionparameter.
    def visitExclude_validoptionparameter(self, ctx:backendgrammerParser.Exclude_validoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#include_validoptionparameter.
    def visitInclude_validoptionparameter(self, ctx:backendgrammerParser.Include_validoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#wildpattern_validoptionparameter.
    def visitWildpattern_validoptionparameter(self, ctx:backendgrammerParser.Wildpattern_validoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#min_validoptionparameter.
    def visitMin_validoptionparameter(self, ctx:backendgrammerParser.Min_validoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#max_validoptionparameter.
    def visitMax_validoptionparameter(self, ctx:backendgrammerParser.Max_validoptionparameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#uniqueoption.
    def visitUniqueoption(self, ctx:backendgrammerParser.UniqueoptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#nulloption.
    def visitNulloption(self, ctx:backendgrammerParser.NulloptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#pkoption.
    def visitPkoption(self, ctx:backendgrammerParser.PkoptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#enumrole.
    def visitEnumrole(self, ctx:backendgrammerParser.EnumroleContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#enumname.
    def visitEnumname(self, ctx:backendgrammerParser.EnumnameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#enumblock.
    def visitEnumblock(self, ctx:backendgrammerParser.EnumblockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#enumitem.
    def visitEnumitem(self, ctx:backendgrammerParser.EnumitemContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#endpointrule.
    def visitEndpointrule(self, ctx:backendgrammerParser.EndpointruleContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#operationId.
    def visitOperationId(self, ctx:backendgrammerParser.OperationIdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#htttpMethod.
    def visitHtttpMethod(self, ctx:backendgrammerParser.HtttpMethodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#endpointurl.
    def visitEndpointurl(self, ctx:backendgrammerParser.EndpointurlContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#endpoinblock.
    def visitEndpoinblock(self, ctx:backendgrammerParser.EndpoinblockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#responseblock.
    def visitResponseblock(self, ctx:backendgrammerParser.ResponseblockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#responseblock_inner.
    def visitResponseblock_inner(self, ctx:backendgrammerParser.Responseblock_innerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#relationalcode.
    def visitRelationalcode(self, ctx:backendgrammerParser.RelationalcodeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#define_variable_relational.
    def visitDefine_variable_relational(self, ctx:backendgrammerParser.Define_variable_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#expr_relational.
    def visitExpr_relational(self, ctx:backendgrammerParser.Expr_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#term_relational.
    def visitTerm_relational(self, ctx:backendgrammerParser.Term_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#idom_relational.
    def visitIdom_relational(self, ctx:backendgrammerParser.Idom_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#factor_relational.
    def visitFactor_relational(self, ctx:backendgrammerParser.Factor_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#inputblock.
    def visitInputblock(self, ctx:backendgrammerParser.InputblockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#jsonstring.
    def visitJsonstring(self, ctx:backendgrammerParser.JsonstringContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#built_in_functions_relational.
    def visitBuilt_in_functions_relational(self, ctx:backendgrammerParser.Built_in_functions_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#key_value_pair_select_relational.
    def visitKey_value_pair_select_relational(self, ctx:backendgrammerParser.Key_value_pair_select_relationalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#binary_logical_operation.
    def visitBinary_logical_operation(self, ctx:backendgrammerParser.Binary_logical_operationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#genericvalue.
    def visitGenericvalue(self, ctx:backendgrammerParser.GenericvalueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#intvalue.
    def visitIntvalue(self, ctx:backendgrammerParser.IntvalueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#stringvalue.
    def visitStringvalue(self, ctx:backendgrammerParser.StringvalueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#booleanvalue.
    def visitBooleanvalue(self, ctx:backendgrammerParser.BooleanvalueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by backendgrammerParser#variablename.
    def visitVariablename(self, ctx:backendgrammerParser.VariablenameContext):
        return self.visitChildren(ctx)



del backendgrammerParser