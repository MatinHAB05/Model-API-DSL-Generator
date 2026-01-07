// Generated from C:/Users/MSI/Pictures/CompilerProjcet/pythonProject1/backendgrammer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link backendgrammerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface backendgrammerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#compileinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileinit(backendgrammerParser.CompileinitContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#modelrole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelrole(backendgrammerParser.ModelroleContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#modelname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelname(backendgrammerParser.ModelnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#modelblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelblock(backendgrammerParser.ModelblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#fieldname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldname(backendgrammerParser.FieldnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#fieldtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldtype(backendgrammerParser.FieldtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#customtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomtype(backendgrammerParser.CustomtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#datetimetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimetype(backendgrammerParser.DatetimetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#texttype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTexttype(backendgrammerParser.TexttypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#numericaltype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericaltype(backendgrammerParser.NumericaltypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#fieldannotaions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldannotaions(backendgrammerParser.FieldannotaionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#fieldannotaion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldannotaion(backendgrammerParser.FieldannotaionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#fkoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFkoption(backendgrammerParser.FkoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#validoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoption(backendgrammerParser.ValidoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#validoptionparameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoptionparameters(backendgrammerParser.ValidoptionparametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidoptionparameter(backendgrammerParser.ValidoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#exclude_validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclude_validoptionparameter(backendgrammerParser.Exclude_validoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#include_validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude_validoptionparameter(backendgrammerParser.Include_validoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#wildpattern_validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildpattern_validoptionparameter(backendgrammerParser.Wildpattern_validoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#min_validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin_validoptionparameter(backendgrammerParser.Min_validoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#max_validoptionparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMax_validoptionparameter(backendgrammerParser.Max_validoptionparameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#uniqueoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueoption(backendgrammerParser.UniqueoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#nulloption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNulloption(backendgrammerParser.NulloptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#pkoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkoption(backendgrammerParser.PkoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#enumrole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumrole(backendgrammerParser.EnumroleContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#enumname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumname(backendgrammerParser.EnumnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#enumblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumblock(backendgrammerParser.EnumblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#enumitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumitem(backendgrammerParser.EnumitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#genericvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericvalue(backendgrammerParser.GenericvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#intvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntvalue(backendgrammerParser.IntvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#stringvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringvalue(backendgrammerParser.StringvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#datevalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatevalue(backendgrammerParser.DatevalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#timevalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimevalue(backendgrammerParser.TimevalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#variablename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablename(backendgrammerParser.VariablenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link backendgrammerParser#wildpattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildpattern(backendgrammerParser.WildpatternContext ctx);
}