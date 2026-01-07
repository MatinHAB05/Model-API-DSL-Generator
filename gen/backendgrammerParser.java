// Generated from C:/Users/MSI/Pictures/CompilerProjcet/pythonProject1/backendgrammer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class backendgrammerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, DIGIT=30, MONTHDIGITS=31, 
		DAYDIGITS=32, HOURDIGIT=33, MINUTEDIGIT=34, SECONDDIGIT=35, STRINGVALUE=36, 
		VARIABLEID=37, INT=38, STRING=39, DATE=40, TIME=41, WS=42;
	public static final int
		RULE_compileinit = 0, RULE_modelrole = 1, RULE_modelname = 2, RULE_modelblock = 3, 
		RULE_fieldname = 4, RULE_fieldtype = 5, RULE_customtype = 6, RULE_datetimetype = 7, 
		RULE_texttype = 8, RULE_numericaltype = 9, RULE_fieldannotaions = 10, 
		RULE_fieldannotaion = 11, RULE_fkoption = 12, RULE_validoption = 13, RULE_validoptionparameters = 14, 
		RULE_validoptionparameter = 15, RULE_exclude_validoptionparameter = 16, 
		RULE_include_validoptionparameter = 17, RULE_wildpattern_validoptionparameter = 18, 
		RULE_min_validoptionparameter = 19, RULE_max_validoptionparameter = 20, 
		RULE_uniqueoption = 21, RULE_nulloption = 22, RULE_pkoption = 23, RULE_enumrole = 24, 
		RULE_enumname = 25, RULE_enumblock = 26, RULE_enumitem = 27, RULE_genericvalue = 28, 
		RULE_intvalue = 29, RULE_stringvalue = 30, RULE_datevalue = 31, RULE_timevalue = 32, 
		RULE_variablename = 33, RULE_wildpattern = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileinit", "modelrole", "modelname", "modelblock", "fieldname", "fieldtype", 
			"customtype", "datetimetype", "texttype", "numericaltype", "fieldannotaions", 
			"fieldannotaion", "fkoption", "validoption", "validoptionparameters", 
			"validoptionparameter", "exclude_validoptionparameter", "include_validoptionparameter", 
			"wildpattern_validoptionparameter", "min_validoptionparameter", "max_validoptionparameter", 
			"uniqueoption", "nulloption", "pkoption", "enumrole", "enumname", "enumblock", 
			"enumitem", "genericvalue", "intvalue", "stringvalue", "datevalue", "timevalue", 
			"variablename", "wildpattern"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'model'", "'{'", "'}'", "':'", "';'", "'@'", "'foreign-key'", 
			"'('", "'.'", "')'", "'vaild'", "'['", "']'", "','", "'exclude'", "'='", 
			"'include'", "'wildpattern'", "'\"'", "'min'", "'max'", "'unique'", "'nullable'", 
			"'non-nullable'", "'pk'", "'enum'", "'+'", "'-'", "'...'", null, null, 
			null, null, null, null, null, null, "'Int'", "'String'", "'Date'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "DIGIT", "MONTHDIGITS", "DAYDIGITS", 
			"HOURDIGIT", "MINUTEDIGIT", "SECONDDIGIT", "STRINGVALUE", "VARIABLEID", 
			"INT", "STRING", "DATE", "TIME", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "backendgrammer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public backendgrammerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompileinitContext extends ParserRuleContext {
		public List<ModelroleContext> modelrole() {
			return getRuleContexts(ModelroleContext.class);
		}
		public ModelroleContext modelrole(int i) {
			return getRuleContext(ModelroleContext.class,i);
		}
		public List<EnumroleContext> enumrole() {
			return getRuleContexts(EnumroleContext.class);
		}
		public EnumroleContext enumrole(int i) {
			return getRuleContext(EnumroleContext.class,i);
		}
		public CompileinitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileinit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterCompileinit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitCompileinit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitCompileinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileinitContext compileinit() throws RecognitionException {
		CompileinitContext _localctx = new CompileinitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileinit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__25) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(70);
					modelrole();
					}
					break;
				case T__25:
					{
					setState(71);
					enumrole();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModelroleContext extends ParserRuleContext {
		public ModelnameContext modelname() {
			return getRuleContext(ModelnameContext.class,0);
		}
		public ModelblockContext modelblock() {
			return getRuleContext(ModelblockContext.class,0);
		}
		public ModelroleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelrole; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterModelrole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitModelrole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitModelrole(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelroleContext modelrole() throws RecognitionException {
		ModelroleContext _localctx = new ModelroleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_modelrole);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__0);
			setState(78);
			modelname();
			setState(79);
			match(T__1);
			setState(80);
			modelblock();
			setState(81);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModelnameContext extends ParserRuleContext {
		public VariablenameContext variablename() {
			return getRuleContext(VariablenameContext.class,0);
		}
		public ModelnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterModelname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitModelname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitModelname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelnameContext modelname() throws RecognitionException {
		ModelnameContext _localctx = new ModelnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_modelname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			variablename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModelblockContext extends ParserRuleContext {
		public List<FieldnameContext> fieldname() {
			return getRuleContexts(FieldnameContext.class);
		}
		public FieldnameContext fieldname(int i) {
			return getRuleContext(FieldnameContext.class,i);
		}
		public List<FieldtypeContext> fieldtype() {
			return getRuleContexts(FieldtypeContext.class);
		}
		public FieldtypeContext fieldtype(int i) {
			return getRuleContext(FieldtypeContext.class,i);
		}
		public List<FieldannotaionsContext> fieldannotaions() {
			return getRuleContexts(FieldannotaionsContext.class);
		}
		public FieldannotaionsContext fieldannotaions(int i) {
			return getRuleContext(FieldannotaionsContext.class,i);
		}
		public ModelblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterModelblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitModelblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitModelblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelblockContext modelblock() throws RecognitionException {
		ModelblockContext _localctx = new ModelblockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modelblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				fieldname();
				setState(86);
				match(T__3);
				setState(87);
				fieldtype();
				setState(88);
				fieldannotaions();
				setState(89);
				match(T__4);
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARIABLEID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldnameContext extends ParserRuleContext {
		public VariablenameContext variablename() {
			return getRuleContext(VariablenameContext.class,0);
		}
		public FieldnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterFieldname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitFieldname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitFieldname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldnameContext fieldname() throws RecognitionException {
		FieldnameContext _localctx = new FieldnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			variablename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldtypeContext extends ParserRuleContext {
		public NumericaltypeContext numericaltype() {
			return getRuleContext(NumericaltypeContext.class,0);
		}
		public TexttypeContext texttype() {
			return getRuleContext(TexttypeContext.class,0);
		}
		public DatetimetypeContext datetimetype() {
			return getRuleContext(DatetimetypeContext.class,0);
		}
		public CustomtypeContext customtype() {
			return getRuleContext(CustomtypeContext.class,0);
		}
		public FieldtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterFieldtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitFieldtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitFieldtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldtypeContext fieldtype() throws RecognitionException {
		FieldtypeContext _localctx = new FieldtypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldtype);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				numericaltype();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				texttype();
				}
				break;
			case DATE:
			case TIME:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				datetimetype();
				}
				break;
			case VARIABLEID:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				customtype();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CustomtypeContext extends ParserRuleContext {
		public EnumnameContext enumname() {
			return getRuleContext(EnumnameContext.class,0);
		}
		public CustomtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterCustomtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitCustomtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitCustomtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomtypeContext customtype() throws RecognitionException {
		CustomtypeContext _localctx = new CustomtypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_customtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			enumname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatetimetypeContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(backendgrammerParser.DATE, 0); }
		public TerminalNode TIME() { return getToken(backendgrammerParser.TIME, 0); }
		public DatetimetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetimetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterDatetimetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitDatetimetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitDatetimetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatetimetypeContext datetimetype() throws RecognitionException {
		DatetimetypeContext _localctx = new DatetimetypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_datetimetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==DATE || _la==TIME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TexttypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(backendgrammerParser.STRING, 0); }
		public TexttypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texttype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterTexttype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitTexttype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitTexttype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TexttypeContext texttype() throws RecognitionException {
		TexttypeContext _localctx = new TexttypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_texttype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericaltypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(backendgrammerParser.INT, 0); }
		public NumericaltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericaltype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterNumericaltype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitNumericaltype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitNumericaltype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericaltypeContext numericaltype() throws RecognitionException {
		NumericaltypeContext _localctx = new NumericaltypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_numericaltype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldannotaionsContext extends ParserRuleContext {
		public List<FieldannotaionContext> fieldannotaion() {
			return getRuleContexts(FieldannotaionContext.class);
		}
		public FieldannotaionContext fieldannotaion(int i) {
			return getRuleContext(FieldannotaionContext.class,i);
		}
		public FieldannotaionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldannotaions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterFieldannotaions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitFieldannotaions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitFieldannotaions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldannotaionsContext fieldannotaions() throws RecognitionException {
		FieldannotaionsContext _localctx = new FieldannotaionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldannotaions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(111);
				match(T__5);
				setState(112);
				fieldannotaion();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldannotaionContext extends ParserRuleContext {
		public PkoptionContext pkoption() {
			return getRuleContext(PkoptionContext.class,0);
		}
		public NulloptionContext nulloption() {
			return getRuleContext(NulloptionContext.class,0);
		}
		public UniqueoptionContext uniqueoption() {
			return getRuleContext(UniqueoptionContext.class,0);
		}
		public ValidoptionContext validoption() {
			return getRuleContext(ValidoptionContext.class,0);
		}
		public FkoptionContext fkoption() {
			return getRuleContext(FkoptionContext.class,0);
		}
		public FieldannotaionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldannotaion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterFieldannotaion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitFieldannotaion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitFieldannotaion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldannotaionContext fieldannotaion() throws RecognitionException {
		FieldannotaionContext _localctx = new FieldannotaionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldannotaion);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				pkoption();
				}
				break;
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				nulloption();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				uniqueoption();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				validoption();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				fkoption();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FkoptionContext extends ParserRuleContext {
		public ModelnameContext modelname() {
			return getRuleContext(ModelnameContext.class,0);
		}
		public FieldnameContext fieldname() {
			return getRuleContext(FieldnameContext.class,0);
		}
		public FkoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fkoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterFkoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitFkoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitFkoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FkoptionContext fkoption() throws RecognitionException {
		FkoptionContext _localctx = new FkoptionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fkoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__6);
			setState(126);
			match(T__7);
			setState(127);
			modelname();
			setState(128);
			match(T__8);
			setState(129);
			fieldname();
			setState(130);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidoptionContext extends ParserRuleContext {
		public ValidoptionparametersContext validoptionparameters() {
			return getRuleContext(ValidoptionparametersContext.class,0);
		}
		public ValidoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterValidoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitValidoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitValidoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidoptionContext validoption() throws RecognitionException {
		ValidoptionContext _localctx = new ValidoptionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_validoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__10);
			setState(133);
			match(T__11);
			setState(134);
			validoptionparameters();
			setState(135);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidoptionparametersContext extends ParserRuleContext {
		public List<ValidoptionparameterContext> validoptionparameter() {
			return getRuleContexts(ValidoptionparameterContext.class);
		}
		public ValidoptionparameterContext validoptionparameter(int i) {
			return getRuleContext(ValidoptionparameterContext.class,i);
		}
		public ValidoptionparametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validoptionparameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterValidoptionparameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitValidoptionparameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitValidoptionparameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidoptionparametersContext validoptionparameters() throws RecognitionException {
		ValidoptionparametersContext _localctx = new ValidoptionparametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_validoptionparameters);
		int _la;
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				validoptionparameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				validoptionparameter();
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					match(T__13);
					setState(140);
					validoptionparameter();
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__13 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValidoptionparameterContext extends ParserRuleContext {
		public Max_validoptionparameterContext max_validoptionparameter() {
			return getRuleContext(Max_validoptionparameterContext.class,0);
		}
		public Min_validoptionparameterContext min_validoptionparameter() {
			return getRuleContext(Min_validoptionparameterContext.class,0);
		}
		public Wildpattern_validoptionparameterContext wildpattern_validoptionparameter() {
			return getRuleContext(Wildpattern_validoptionparameterContext.class,0);
		}
		public Include_validoptionparameterContext include_validoptionparameter() {
			return getRuleContext(Include_validoptionparameterContext.class,0);
		}
		public Exclude_validoptionparameterContext exclude_validoptionparameter() {
			return getRuleContext(Exclude_validoptionparameterContext.class,0);
		}
		public ValidoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterValidoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitValidoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitValidoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidoptionparameterContext validoptionparameter() throws RecognitionException {
		ValidoptionparameterContext _localctx = new ValidoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_validoptionparameter);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				max_validoptionparameter();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				min_validoptionparameter();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				wildpattern_validoptionparameter();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				include_validoptionparameter();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				exclude_validoptionparameter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exclude_validoptionparameterContext extends ParserRuleContext {
		public List<GenericvalueContext> genericvalue() {
			return getRuleContexts(GenericvalueContext.class);
		}
		public GenericvalueContext genericvalue(int i) {
			return getRuleContext(GenericvalueContext.class,i);
		}
		public Exclude_validoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclude_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterExclude_validoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitExclude_validoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitExclude_validoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exclude_validoptionparameterContext exclude_validoptionparameter() throws RecognitionException {
		Exclude_validoptionparameterContext _localctx = new Exclude_validoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exclude_validoptionparameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__14);
			setState(155);
			match(T__15);
			setState(156);
			match(T__1);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(157);
				genericvalue();
				}
				break;
			case 2:
				{
				setState(158);
				genericvalue();
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(159);
					match(T__13);
					setState(160);
					genericvalue();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__13 );
				}
				break;
			}
			setState(167);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Include_validoptionparameterContext extends ParserRuleContext {
		public List<GenericvalueContext> genericvalue() {
			return getRuleContexts(GenericvalueContext.class);
		}
		public GenericvalueContext genericvalue(int i) {
			return getRuleContext(GenericvalueContext.class,i);
		}
		public Include_validoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterInclude_validoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitInclude_validoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitInclude_validoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Include_validoptionparameterContext include_validoptionparameter() throws RecognitionException {
		Include_validoptionparameterContext _localctx = new Include_validoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_include_validoptionparameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__16);
			setState(170);
			match(T__15);
			setState(171);
			match(T__1);
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(172);
				genericvalue();
				}
				break;
			case 2:
				{
				setState(173);
				genericvalue();
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					match(T__13);
					setState(175);
					genericvalue();
					}
					}
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__13 );
				}
				break;
			}
			setState(182);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Wildpattern_validoptionparameterContext extends ParserRuleContext {
		public WildpatternContext wildpattern() {
			return getRuleContext(WildpatternContext.class,0);
		}
		public Wildpattern_validoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildpattern_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterWildpattern_validoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitWildpattern_validoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitWildpattern_validoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wildpattern_validoptionparameterContext wildpattern_validoptionparameter() throws RecognitionException {
		Wildpattern_validoptionparameterContext _localctx = new Wildpattern_validoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_wildpattern_validoptionparameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__17);
			setState(185);
			match(T__15);
			setState(186);
			match(T__18);
			setState(187);
			wildpattern();
			setState(188);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Min_validoptionparameterContext extends ParserRuleContext {
		public GenericvalueContext genericvalue() {
			return getRuleContext(GenericvalueContext.class,0);
		}
		public Min_validoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterMin_validoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitMin_validoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitMin_validoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Min_validoptionparameterContext min_validoptionparameter() throws RecognitionException {
		Min_validoptionparameterContext _localctx = new Min_validoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_min_validoptionparameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__19);
			setState(191);
			match(T__15);
			setState(192);
			genericvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Max_validoptionparameterContext extends ParserRuleContext {
		public GenericvalueContext genericvalue() {
			return getRuleContext(GenericvalueContext.class,0);
		}
		public Max_validoptionparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_validoptionparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterMax_validoptionparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitMax_validoptionparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitMax_validoptionparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Max_validoptionparameterContext max_validoptionparameter() throws RecognitionException {
		Max_validoptionparameterContext _localctx = new Max_validoptionparameterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_max_validoptionparameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__20);
			setState(195);
			match(T__15);
			setState(196);
			genericvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UniqueoptionContext extends ParserRuleContext {
		public UniqueoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterUniqueoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitUniqueoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitUniqueoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniqueoptionContext uniqueoption() throws RecognitionException {
		UniqueoptionContext _localctx = new UniqueoptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_uniqueoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NulloptionContext extends ParserRuleContext {
		public NulloptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nulloption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterNulloption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitNulloption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitNulloption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NulloptionContext nulloption() throws RecognitionException {
		NulloptionContext _localctx = new NulloptionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nulloption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__23) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PkoptionContext extends ParserRuleContext {
		public PkoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterPkoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitPkoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitPkoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PkoptionContext pkoption() throws RecognitionException {
		PkoptionContext _localctx = new PkoptionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pkoption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumroleContext extends ParserRuleContext {
		public EnumnameContext enumname() {
			return getRuleContext(EnumnameContext.class,0);
		}
		public EnumblockContext enumblock() {
			return getRuleContext(EnumblockContext.class,0);
		}
		public EnumroleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumrole; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterEnumrole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitEnumrole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitEnumrole(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumroleContext enumrole() throws RecognitionException {
		EnumroleContext _localctx = new EnumroleContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumrole);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__25);
			setState(205);
			enumname();
			setState(206);
			match(T__1);
			setState(207);
			enumblock();
			setState(208);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumnameContext extends ParserRuleContext {
		public VariablenameContext variablename() {
			return getRuleContext(VariablenameContext.class,0);
		}
		public EnumnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterEnumname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitEnumname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitEnumname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumnameContext enumname() throws RecognitionException {
		EnumnameContext _localctx = new EnumnameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_enumname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			variablename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumblockContext extends ParserRuleContext {
		public List<EnumitemContext> enumitem() {
			return getRuleContexts(EnumitemContext.class);
		}
		public EnumitemContext enumitem(int i) {
			return getRuleContext(EnumitemContext.class,i);
		}
		public EnumblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterEnumblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitEnumblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitEnumblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumblockContext enumblock() throws RecognitionException {
		EnumblockContext _localctx = new EnumblockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_enumblock);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				enumitem();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				enumitem();
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(214);
					match(T__13);
					setState(215);
					enumitem();
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumitemContext extends ParserRuleContext {
		public GenericvalueContext genericvalue() {
			return getRuleContext(GenericvalueContext.class,0);
		}
		public EnumitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterEnumitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitEnumitem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitEnumitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumitemContext enumitem() throws RecognitionException {
		EnumitemContext _localctx = new EnumitemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_enumitem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			genericvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericvalueContext extends ParserRuleContext {
		public IntvalueContext intvalue() {
			return getRuleContext(IntvalueContext.class,0);
		}
		public StringvalueContext stringvalue() {
			return getRuleContext(StringvalueContext.class,0);
		}
		public DatevalueContext datevalue() {
			return getRuleContext(DatevalueContext.class,0);
		}
		public TimevalueContext timevalue() {
			return getRuleContext(TimevalueContext.class,0);
		}
		public GenericvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterGenericvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitGenericvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitGenericvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericvalueContext genericvalue() throws RecognitionException {
		GenericvalueContext _localctx = new GenericvalueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_genericvalue);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				intvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				stringvalue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				datevalue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				timevalue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntvalueContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(backendgrammerParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(backendgrammerParser.DIGIT, i);
		}
		public IntvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterIntvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitIntvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitIntvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntvalueContext intvalue() throws RecognitionException {
		IntvalueContext _localctx = new IntvalueContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_intvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26 || _la==T__27) {
				{
				setState(231);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(234);
				match(DIGIT);
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringvalueContext extends ParserRuleContext {
		public TerminalNode STRINGVALUE() { return getToken(backendgrammerParser.STRINGVALUE, 0); }
		public StringvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterStringvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitStringvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitStringvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringvalueContext stringvalue() throws RecognitionException {
		StringvalueContext _localctx = new StringvalueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stringvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(STRINGVALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatevalueContext extends ParserRuleContext {
		public TerminalNode MONTHDIGITS() { return getToken(backendgrammerParser.MONTHDIGITS, 0); }
		public TerminalNode DAYDIGITS() { return getToken(backendgrammerParser.DAYDIGITS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(backendgrammerParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(backendgrammerParser.DIGIT, i);
		}
		public DatevalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datevalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterDatevalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitDatevalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitDatevalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatevalueContext datevalue() throws RecognitionException {
		DatevalueContext _localctx = new DatevalueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_datevalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(241);
				match(DIGIT);
				}
				}
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(246);
			match(T__27);
			setState(247);
			match(MONTHDIGITS);
			setState(248);
			match(T__27);
			setState(249);
			match(DAYDIGITS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimevalueContext extends ParserRuleContext {
		public TerminalNode HOURDIGIT() { return getToken(backendgrammerParser.HOURDIGIT, 0); }
		public TerminalNode MINUTEDIGIT() { return getToken(backendgrammerParser.MINUTEDIGIT, 0); }
		public TerminalNode SECONDDIGIT() { return getToken(backendgrammerParser.SECONDDIGIT, 0); }
		public TimevalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timevalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterTimevalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitTimevalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitTimevalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimevalueContext timevalue() throws RecognitionException {
		TimevalueContext _localctx = new TimevalueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_timevalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(HOURDIGIT);
			setState(252);
			match(T__3);
			setState(253);
			match(MINUTEDIGIT);
			setState(254);
			match(T__3);
			setState(255);
			match(SECONDDIGIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariablenameContext extends ParserRuleContext {
		public TerminalNode VARIABLEID() { return getToken(backendgrammerParser.VARIABLEID, 0); }
		public VariablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterVariablename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitVariablename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitVariablename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablenameContext variablename() throws RecognitionException {
		VariablenameContext _localctx = new VariablenameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(VARIABLEID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WildpatternContext extends ParserRuleContext {
		public WildpatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildpattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).enterWildpattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof backendgrammerListener ) ((backendgrammerListener)listener).exitWildpattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof backendgrammerVisitor ) return ((backendgrammerVisitor<? extends T>)visitor).visitWildpattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildpatternContext wildpattern() throws RecognitionException {
		WildpatternContext _localctx = new WildpatternContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_wildpattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0106\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0005\u0000I\b\u0000\n\u0000\f\u0000L\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003\\\b\u0003\u000b\u0003\f\u0003]\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"f\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nr\b\n\n\n\f\nu\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b|\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0004\u000e\u008e\b\u000e\u000b\u000e\f\u000e\u008f\u0003\u000e\u0092"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u0099\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00a2\b\u0010\u000b\u0010\f"+
		"\u0010\u00a3\u0003\u0010\u00a6\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0004\u0011\u00b1\b\u0011\u000b\u0011\f\u0011\u00b2\u0003\u0011\u00b5"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u00d9"+
		"\b\u001a\n\u001a\f\u001a\u00dc\t\u001a\u0003\u001a\u00de\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u00e6\b\u001c\u0001\u001d\u0003\u001d\u00e9\b\u001d\u0001\u001d"+
		"\u0004\u001d\u00ec\b\u001d\u000b\u001d\f\u001d\u00ed\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0004\u001f\u00f3\b\u001f\u000b\u001f\f\u001f\u00f4"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0000"+
		"\u0000#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0003\u0001\u0000()\u0001"+
		"\u0000\u0017\u0018\u0001\u0000\u001b\u001c\u0101\u0000J\u0001\u0000\u0000"+
		"\u0000\u0002M\u0001\u0000\u0000\u0000\u0004S\u0001\u0000\u0000\u0000\u0006"+
		"[\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\ne\u0001\u0000\u0000"+
		"\u0000\fg\u0001\u0000\u0000\u0000\u000ei\u0001\u0000\u0000\u0000\u0010"+
		"k\u0001\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014s\u0001"+
		"\u0000\u0000\u0000\u0016{\u0001\u0000\u0000\u0000\u0018}\u0001\u0000\u0000"+
		"\u0000\u001a\u0084\u0001\u0000\u0000\u0000\u001c\u0091\u0001\u0000\u0000"+
		"\u0000\u001e\u0098\u0001\u0000\u0000\u0000 \u009a\u0001\u0000\u0000\u0000"+
		"\"\u00a9\u0001\u0000\u0000\u0000$\u00b8\u0001\u0000\u0000\u0000&\u00be"+
		"\u0001\u0000\u0000\u0000(\u00c2\u0001\u0000\u0000\u0000*\u00c6\u0001\u0000"+
		"\u0000\u0000,\u00c8\u0001\u0000\u0000\u0000.\u00ca\u0001\u0000\u0000\u0000"+
		"0\u00cc\u0001\u0000\u0000\u00002\u00d2\u0001\u0000\u0000\u00004\u00dd"+
		"\u0001\u0000\u0000\u00006\u00df\u0001\u0000\u0000\u00008\u00e5\u0001\u0000"+
		"\u0000\u0000:\u00e8\u0001\u0000\u0000\u0000<\u00ef\u0001\u0000\u0000\u0000"+
		">\u00f2\u0001\u0000\u0000\u0000@\u00fb\u0001\u0000\u0000\u0000B\u0101"+
		"\u0001\u0000\u0000\u0000D\u0103\u0001\u0000\u0000\u0000FI\u0003\u0002"+
		"\u0001\u0000GI\u00030\u0018\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000K\u0001\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000MN\u0005\u0001\u0000\u0000NO\u0003\u0004\u0002\u0000OP\u0005\u0002"+
		"\u0000\u0000PQ\u0003\u0006\u0003\u0000QR\u0005\u0003\u0000\u0000R\u0003"+
		"\u0001\u0000\u0000\u0000ST\u0003B!\u0000T\u0005\u0001\u0000\u0000\u0000"+
		"UV\u0003\b\u0004\u0000VW\u0005\u0004\u0000\u0000WX\u0003\n\u0005\u0000"+
		"XY\u0003\u0014\n\u0000YZ\u0005\u0005\u0000\u0000Z\\\u0001\u0000\u0000"+
		"\u0000[U\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000"+
		"_`\u0003B!\u0000`\t\u0001\u0000\u0000\u0000af\u0003\u0012\t\u0000bf\u0003"+
		"\u0010\b\u0000cf\u0003\u000e\u0007\u0000df\u0003\f\u0006\u0000ea\u0001"+
		"\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"ed\u0001\u0000\u0000\u0000f\u000b\u0001\u0000\u0000\u0000gh\u00032\u0019"+
		"\u0000h\r\u0001\u0000\u0000\u0000ij\u0007\u0000\u0000\u0000j\u000f\u0001"+
		"\u0000\u0000\u0000kl\u0005\'\u0000\u0000l\u0011\u0001\u0000\u0000\u0000"+
		"mn\u0005&\u0000\u0000n\u0013\u0001\u0000\u0000\u0000op\u0005\u0006\u0000"+
		"\u0000pr\u0003\u0016\u000b\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0015"+
		"\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000v|\u0003.\u0017\u0000"+
		"w|\u0003,\u0016\u0000x|\u0003*\u0015\u0000y|\u0003\u001a\r\u0000z|\u0003"+
		"\u0018\f\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000"+
		"|\u0017\u0001\u0000\u0000\u0000}~\u0005\u0007\u0000\u0000~\u007f\u0005"+
		"\b\u0000\u0000\u007f\u0080\u0003\u0004\u0002\u0000\u0080\u0081\u0005\t"+
		"\u0000\u0000\u0081\u0082\u0003\b\u0004\u0000\u0082\u0083\u0005\n\u0000"+
		"\u0000\u0083\u0019\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u000b\u0000"+
		"\u0000\u0085\u0086\u0005\f\u0000\u0000\u0086\u0087\u0003\u001c\u000e\u0000"+
		"\u0087\u0088\u0005\r\u0000\u0000\u0088\u001b\u0001\u0000\u0000\u0000\u0089"+
		"\u0092\u0003\u001e\u000f\u0000\u008a\u008d\u0003\u001e\u000f\u0000\u008b"+
		"\u008c\u0005\u000e\u0000\u0000\u008c\u008e\u0003\u001e\u000f\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0092\u0001\u0000\u0000\u0000\u0091\u0089\u0001\u0000\u0000\u0000\u0091"+
		"\u008a\u0001\u0000\u0000\u0000\u0092\u001d\u0001\u0000\u0000\u0000\u0093"+
		"\u0099\u0003(\u0014\u0000\u0094\u0099\u0003&\u0013\u0000\u0095\u0099\u0003"+
		"$\u0012\u0000\u0096\u0099\u0003\"\u0011\u0000\u0097\u0099\u0003 \u0010"+
		"\u0000\u0098\u0093\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000"+
		"\u0000\u0098\u0095\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u001f\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005\u000f\u0000\u0000\u009b\u009c\u0005\u0010\u0000"+
		"\u0000\u009c\u00a5\u0005\u0002\u0000\u0000\u009d\u00a6\u00038\u001c\u0000"+
		"\u009e\u00a1\u00038\u001c\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0"+
		"\u00a2\u00038\u001c\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u009d"+
		"\u0001\u0000\u0000\u0000\u00a5\u009e\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0003\u0000\u0000\u00a8!\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u0011\u0000\u0000\u00aa\u00ab\u0005\u0010\u0000\u0000\u00ab\u00b4\u0005"+
		"\u0002\u0000\u0000\u00ac\u00b5\u00038\u001c\u0000\u00ad\u00b0\u00038\u001c"+
		"\u0000\u00ae\u00af\u0005\u000e\u0000\u0000\u00af\u00b1\u00038\u001c\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b4\u00ad\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000"+
		"\u00b7#\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0012\u0000\u0000\u00b9"+
		"\u00ba\u0005\u0010\u0000\u0000\u00ba\u00bb\u0005\u0013\u0000\u0000\u00bb"+
		"\u00bc\u0003D\"\u0000\u00bc\u00bd\u0005\u0013\u0000\u0000\u00bd%\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005\u0014\u0000\u0000\u00bf\u00c0\u0005"+
		"\u0010\u0000\u0000\u00c0\u00c1\u00038\u001c\u0000\u00c1\'\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0005\u0015\u0000\u0000\u00c3\u00c4\u0005\u0010"+
		"\u0000\u0000\u00c4\u00c5\u00038\u001c\u0000\u00c5)\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\u0016\u0000\u0000\u00c7+\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0007\u0001\u0000\u0000\u00c9-\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0005\u0019\u0000\u0000\u00cb/\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\u001a\u0000\u0000\u00cd\u00ce\u00032\u0019\u0000\u00ce\u00cf\u0005\u0002"+
		"\u0000\u0000\u00cf\u00d0\u00034\u001a\u0000\u00d0\u00d1\u0005\u0003\u0000"+
		"\u0000\u00d11\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003B!\u0000\u00d3"+
		"3\u0001\u0000\u0000\u0000\u00d4\u00de\u00036\u001b\u0000\u00d5\u00da\u0003"+
		"6\u001b\u0000\u00d6\u00d7\u0005\u000e\u0000\u0000\u00d7\u00d9\u00036\u001b"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000"+
		"\u0000\u00dd\u00d4\u0001\u0000\u0000\u0000\u00dd\u00d5\u0001\u0000\u0000"+
		"\u0000\u00de5\u0001\u0000\u0000\u0000\u00df\u00e0\u00038\u001c\u0000\u00e0"+
		"7\u0001\u0000\u0000\u0000\u00e1\u00e6\u0003:\u001d\u0000\u00e2\u00e6\u0003"+
		"<\u001e\u0000\u00e3\u00e6\u0003>\u001f\u0000\u00e4\u00e6\u0003@ \u0000"+
		"\u00e5\u00e1\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e69\u0001\u0000\u0000\u0000\u00e7\u00e9\u0007\u0002\u0000\u0000\u00e8"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ea\u00ec\u0005\u001e\u0000\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		";\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005$\u0000\u0000\u00f0=\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f3\u0005\u001e\u0000\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0005\u001c\u0000\u0000\u00f7\u00f8\u0005"+
		"\u001f\u0000\u0000\u00f8\u00f9\u0005\u001c\u0000\u0000\u00f9\u00fa\u0005"+
		" \u0000\u0000\u00fa?\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005!\u0000"+
		"\u0000\u00fc\u00fd\u0005\u0004\u0000\u0000\u00fd\u00fe\u0005\"\u0000\u0000"+
		"\u00fe\u00ff\u0005\u0004\u0000\u0000\u00ff\u0100\u0005#\u0000\u0000\u0100"+
		"A\u0001\u0000\u0000\u0000\u0101\u0102\u0005%\u0000\u0000\u0102C\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0005\u001d\u0000\u0000\u0104E\u0001\u0000"+
		"\u0000\u0000\u0013HJ]es{\u008f\u0091\u0098\u00a3\u00a5\u00b2\u00b4\u00da"+
		"\u00dd\u00e5\u00e8\u00ed\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}