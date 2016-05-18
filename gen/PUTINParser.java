// Generated from C:/Users/jacobholm/Desktop/PUTIN\PUTIN.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PUTINParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, DOUBLE=35, TYPE_NUMBER=36, TYPE_TEXT=37, 
		TYPE_BOOLEAN=38, TYPE_PLAYER=39, TYPE_PIECE=40, TYPE_LIST=41, TYPE_COORDINATE=42, 
		OP_AND=43, OP_OR=44, OP_EQUALS=45, OP_NOTEQUALS=46, OP_LESSTHAN=47, OP_LARGERTHAN=48, 
		OP_EQUALORLESSTHAN=49, OP_EQUALORLARGERTHAN=50, OP_MULTIPLY=51, OP_DIVIDE=52, 
		OP_MOD=53, OP_PLUS=54, OP_MINUS=55, OP_NOT=56, DIRECTION=57, TEXT=58, 
		BOOL=59, INT=60, ID=61, WS=62, COMMENT_MUlT=63, COMMENT=64;
	public static final int
		RULE_program = 0, RULE_board = 1, RULE_pieces = 2, RULE_setup = 3, RULE_rules = 4, 
		RULE_wincondition = 5, RULE_method = 6, RULE_size = 7, RULE_boardparam = 8, 
		RULE_stmt = 9, RULE_players = 10, RULE_turn = 11, RULE_turndistribution = 12, 
		RULE_wincnd = 13, RULE_type = 14, RULE_nextm = 15, RULE_nextnextm = 16, 
		RULE_height = 17, RULE_width = 18, RULE_illigaltiles = 19, RULE_specialtiles = 20, 
		RULE_assignmentstmt = 21, RULE_ifstmt = 22, RULE_repeatwhilestmt = 23, 
		RULE_repeatstmt = 24, RULE_optionsstmt = 25, RULE_returnstmt = 26, RULE_foreachstmt = 27, 
		RULE_methodcall = 28, RULE_players1 = 29, RULE_players2 = 30, RULE_piecetype = 31, 
		RULE_expression = 32, RULE_r = 33, RULE_relation = 34, RULE_a = 35, RULE_add = 36, 
		RULE_m = 37, RULE_mult = 38, RULE_u = 39, RULE_unary = 40, RULE_n = 41, 
		RULE_negation = 42, RULE_t = 43, RULE_term = 44, RULE_elsif = 45, RULE_els = 46, 
		RULE_option = 47, RULE_def = 48, RULE_assignmentstmt1 = 49, RULE_assignmentstmt2 = 50, 
		RULE_assignmentstmt3 = 51, RULE_mc = 52, RULE_mc1 = 53, RULE_mc2 = 54, 
		RULE_coordinate = 55, RULE_value = 56, RULE_singlemove = 57, RULE_number = 58, 
		RULE_stmtmethod = 59, RULE_list = 60, RULE_stmtm = 61, RULE_stmtm1 = 62, 
		RULE_stmtm2 = 63;
	public static final String[] ruleNames = {
		"program", "board", "pieces", "setup", "rules", "wincondition", "method", 
		"size", "boardparam", "stmt", "players", "turn", "turndistribution", "wincnd", 
		"type", "nextm", "nextnextm", "height", "width", "illigaltiles", "specialtiles", 
		"assignmentstmt", "ifstmt", "repeatwhilestmt", "repeatstmt", "optionsstmt", 
		"returnstmt", "foreachstmt", "methodcall", "players1", "players2", "piecetype", 
		"expression", "r", "relation", "a", "add", "m", "mult", "u", "unary", 
		"n", "negation", "t", "term", "elsif", "els", "option", "def", "assignmentstmt1", 
		"assignmentstmt2", "assignmentstmt3", "mc", "mc1", "mc2", "coordinate", 
		"value", "singlemove", "number", "stmtmethod", "list", "stmtm", "stmtm1", 
		"stmtm2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Board'", "'['", "']'", "'Pieces'", "'Setup'", "'Rules'", "'WinConditions'", 
		"'('", "','", "')'", "'{'", "'}'", "'Turn'", "'TurnDistribution'", "'Height'", 
		"'='", "';'", "'Width'", "'IllegalTiles'", "'SpecialTiles'", "'If'", "'RepeatWhile'", 
		"'Repeat'", "'Options'", "'Return'", "'ForEach'", "'In'", "'Players'", 
		"'ElseIf'", "'Else'", "'Option'", "':'", "'Default'", "'.'", null, "'Number'", 
		"'Text'", "'Boolean'", "'Player'", "'Piece'", "'List'", "'Coordinate'", 
		"'And'", "'Or'", "'Equals'", "'NotEquals'", "'LessThan'", "'LargerThan'", 
		"'EqualOrLessThan'", "'EqualOrLargerThan'", "'*'", "'/'", null, "'+'", 
		"'-'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "DOUBLE", 
		"TYPE_NUMBER", "TYPE_TEXT", "TYPE_BOOLEAN", "TYPE_PLAYER", "TYPE_PIECE", 
		"TYPE_LIST", "TYPE_COORDINATE", "OP_AND", "OP_OR", "OP_EQUALS", "OP_NOTEQUALS", 
		"OP_LESSTHAN", "OP_LARGERTHAN", "OP_EQUALORLESSTHAN", "OP_EQUALORLARGERTHAN", 
		"OP_MULTIPLY", "OP_DIVIDE", "OP_MOD", "OP_PLUS", "OP_MINUS", "OP_NOT", 
		"DIRECTION", "TEXT", "BOOL", "INT", "ID", "WS", "COMMENT_MUlT", "COMMENT"
	};
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
	public String getGrammarFileName() { return "PUTIN.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PUTINParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public BoardContext board() {
			return getRuleContext(BoardContext.class,0);
		}
		public PiecesContext pieces() {
			return getRuleContext(PiecesContext.class,0);
		}
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public WinconditionContext wincondition() {
			return getRuleContext(WinconditionContext.class,0);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			board();
			setState(129);
			pieces();
			setState(130);
			setup();
			setState(131);
			rules();
			setState(132);
			wincondition();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(133);
				method();
				}
				}
				setState(138);
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

	public static class BoardContext extends ParserRuleContext {
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public List<BoardparamContext> boardparam() {
			return getRuleContexts(BoardparamContext.class);
		}
		public BoardparamContext boardparam(int i) {
			return getRuleContext(BoardparamContext.class,i);
		}
		public BoardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_board; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterBoard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitBoard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitBoard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoardContext board() throws RecognitionException {
		BoardContext _localctx = new BoardContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_board);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__0);
			setState(140);
			match(T__1);
			setState(141);
			size();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18 || _la==T__19) {
				{
				{
				setState(142);
				boardparam();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
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

	public static class PiecesContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public PiecesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pieces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterPieces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitPieces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitPieces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PiecesContext pieces() throws RecognitionException {
		PiecesContext _localctx = new PiecesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pieces);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__3);
			setState(151);
			match(T__1);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(152);
				stmt();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
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

	public static class SetupContext extends ParserRuleContext {
		public PlayersContext players() {
			return getRuleContext(PlayersContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitSetup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_setup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__4);
			setState(161);
			match(T__1);
			setState(162);
			players();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(163);
				stmt();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
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

	public static class RulesContext extends ParserRuleContext {
		public TurndistributionContext turndistribution() {
			return getRuleContext(TurndistributionContext.class,0);
		}
		public List<TurnContext> turn() {
			return getRuleContexts(TurnContext.class);
		}
		public TurnContext turn(int i) {
			return getRuleContext(TurnContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__5);
			setState(172);
			match(T__1);
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				turn();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(178);
			turndistribution();
			setState(179);
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

	public static class WinconditionContext extends ParserRuleContext {
		public List<WincndContext> wincnd() {
			return getRuleContexts(WincndContext.class);
		}
		public WincndContext wincnd(int i) {
			return getRuleContext(WincndContext.class,i);
		}
		public WinconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wincondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterWincondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitWincondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitWincondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WinconditionContext wincondition() throws RecognitionException {
		WinconditionContext _localctx = new WinconditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_wincondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__6);
			setState(182);
			match(T__1);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20 || _la==T__23) {
				{
				{
				setState(183);
				wincnd();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NextmContext nextm() {
			return getRuleContext(NextmContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ReturnstmtContext returnstmt() {
			return getRuleContext(ReturnstmtContext.class,0);
		}
		public List<NextnextmContext> nextnextm() {
			return getRuleContexts(NextnextmContext.class);
		}
		public NextnextmContext nextnextm(int i) {
			return getRuleContext(NextnextmContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE))) != 0)) {
				{
				setState(191);
				type();
				}
			}

			setState(194);
			match(ID);
			setState(195);
			match(T__7);
			setState(204);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE))) != 0)) {
				{
				setState(196);
				nextm();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(197);
					match(T__8);
					setState(198);
					nextnextm();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(206);
			match(T__9);
			setState(207);
			match(T__10);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(208);
				stmt();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(214);
				returnstmt();
				}
			}

			setState(217);
			match(T__11);
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

	public static class SizeContext extends ParserRuleContext {
		public HeightContext height() {
			return getRuleContext(HeightContext.class,0);
		}
		public WidthContext width() {
			return getRuleContext(WidthContext.class,0);
		}
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			height();
			setState(220);
			width();
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

	public static class BoardparamContext extends ParserRuleContext {
		public IlligaltilesContext illigaltiles() {
			return getRuleContext(IlligaltilesContext.class,0);
		}
		public SpecialtilesContext specialtiles() {
			return getRuleContext(SpecialtilesContext.class,0);
		}
		public BoardparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boardparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterBoardparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitBoardparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitBoardparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoardparamContext boardparam() throws RecognitionException {
		BoardparamContext _localctx = new BoardparamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boardparam);
		try {
			setState(224);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				illigaltiles();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				specialtiles();
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

	public static class StmtContext extends ParserRuleContext {
		public AssignmentstmtContext assignmentstmt() {
			return getRuleContext(AssignmentstmtContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public RepeatwhilestmtContext repeatwhilestmt() {
			return getRuleContext(RepeatwhilestmtContext.class,0);
		}
		public RepeatstmtContext repeatstmt() {
			return getRuleContext(RepeatstmtContext.class,0);
		}
		public OptionsstmtContext optionsstmt() {
			return getRuleContext(OptionsstmtContext.class,0);
		}
		public ForeachstmtContext foreachstmt() {
			return getRuleContext(ForeachstmtContext.class,0);
		}
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				assignmentstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				ifstmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				repeatwhilestmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				repeatstmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(230);
				optionsstmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(231);
				foreachstmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(232);
				methodcall();
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

	public static class PlayersContext extends ParserRuleContext {
		public Players1Context players1() {
			return getRuleContext(Players1Context.class,0);
		}
		public Players2Context players2() {
			return getRuleContext(Players2Context.class,0);
		}
		public PlayersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_players; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterPlayers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitPlayers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitPlayers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayersContext players() throws RecognitionException {
		PlayersContext _localctx = new PlayersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_players);
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				players1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				players2();
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

	public static class TurnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TurnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterTurn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitTurn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitTurn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnContext turn() throws RecognitionException {
		TurnContext _localctx = new TurnContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_turn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__12);
			setState(240);
			match(ID);
			setState(241);
			match(T__10);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(242);
				stmt();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(T__11);
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

	public static class TurndistributionContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TurndistributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turndistribution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterTurndistribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitTurndistribution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitTurndistribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurndistributionContext turndistribution() throws RecognitionException {
		TurndistributionContext _localctx = new TurndistributionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_turndistribution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__13);
			setState(251);
			match(T__10);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(252);
				stmt();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			match(T__11);
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

	public static class WincndContext extends ParserRuleContext {
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public OptionsstmtContext optionsstmt() {
			return getRuleContext(OptionsstmtContext.class,0);
		}
		public WincndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wincnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterWincnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitWincnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitWincnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WincndContext wincnd() throws RecognitionException {
		WincndContext _localctx = new WincndContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_wincnd);
		try {
			setState(262);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				ifstmt();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				optionsstmt();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_NUMBER() { return getToken(PUTINParser.TYPE_NUMBER, 0); }
		public TerminalNode TYPE_TEXT() { return getToken(PUTINParser.TYPE_TEXT, 0); }
		public TerminalNode TYPE_BOOLEAN() { return getToken(PUTINParser.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_PLAYER() { return getToken(PUTINParser.TYPE_PLAYER, 0); }
		public TerminalNode TYPE_PIECE() { return getToken(PUTINParser.TYPE_PIECE, 0); }
		public TerminalNode TYPE_LIST() { return getToken(PUTINParser.TYPE_LIST, 0); }
		public TerminalNode TYPE_COORDINATE() { return getToken(PUTINParser.TYPE_COORDINATE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NextmContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public NextmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterNextm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitNextm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitNextm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextmContext nextm() throws RecognitionException {
		NextmContext _localctx = new NextmContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nextm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			type();
			setState(267);
			match(ID);
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

	public static class NextnextmContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public NextnextmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextnextm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterNextnextm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitNextnextm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitNextnextm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextnextmContext nextnextm() throws RecognitionException {
		NextnextmContext _localctx = new NextnextmContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nextnextm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			type();
			setState(270);
			match(ID);
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

	public static class HeightContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PUTINParser.INT, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterHeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitHeight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitHeight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__14);
			setState(273);
			match(T__15);
			setState(274);
			match(INT);
			setState(275);
			match(T__16);
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

	public static class WidthContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PUTINParser.INT, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__17);
			setState(278);
			match(T__15);
			setState(279);
			match(INT);
			setState(280);
			match(T__16);
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

	public static class IlligaltilesContext extends ParserRuleContext {
		public List<CoordinateContext> coordinate() {
			return getRuleContexts(CoordinateContext.class);
		}
		public CoordinateContext coordinate(int i) {
			return getRuleContext(CoordinateContext.class,i);
		}
		public IlligaltilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_illigaltiles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterIlligaltiles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitIlligaltiles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitIlligaltiles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IlligaltilesContext illigaltiles() throws RecognitionException {
		IlligaltilesContext _localctx = new IlligaltilesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_illigaltiles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__18);
			setState(283);
			match(T__15);
			setState(284);
			match(T__7);
			setState(285);
			coordinate();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(286);
				match(T__8);
				setState(287);
				coordinate();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293);
			match(T__9);
			setState(294);
			match(T__16);
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

	public static class SpecialtilesContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public List<CoordinateContext> coordinate() {
			return getRuleContexts(CoordinateContext.class);
		}
		public CoordinateContext coordinate(int i) {
			return getRuleContext(CoordinateContext.class,i);
		}
		public SpecialtilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialtiles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterSpecialtiles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitSpecialtiles(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitSpecialtiles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialtilesContext specialtiles() throws RecognitionException {
		SpecialtilesContext _localctx = new SpecialtilesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_specialtiles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__19);
			setState(297);
			match(ID);
			setState(298);
			match(T__15);
			setState(299);
			match(T__7);
			setState(300);
			coordinate();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(301);
				match(T__8);
				setState(302);
				coordinate();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			match(T__9);
			setState(309);
			match(T__16);
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

	public static class AssignmentstmtContext extends ParserRuleContext {
		public Assignmentstmt1Context assignmentstmt1() {
			return getRuleContext(Assignmentstmt1Context.class,0);
		}
		public Assignmentstmt2Context assignmentstmt2() {
			return getRuleContext(Assignmentstmt2Context.class,0);
		}
		public Assignmentstmt3Context assignmentstmt3() {
			return getRuleContext(Assignmentstmt3Context.class,0);
		}
		public AssignmentstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterAssignmentstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitAssignmentstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitAssignmentstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentstmtContext assignmentstmt() throws RecognitionException {
		AssignmentstmtContext _localctx = new AssignmentstmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignmentstmt);
		try {
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				assignmentstmt1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				assignmentstmt2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				assignmentstmt3();
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

	public static class IfstmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<ElsifContext> elsif() {
			return getRuleContexts(ElsifContext.class);
		}
		public ElsifContext elsif(int i) {
			return getRuleContext(ElsifContext.class,i);
		}
		public ElsContext els() {
			return getRuleContext(ElsContext.class,0);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(T__20);
			setState(317);
			match(T__7);
			setState(318);
			expression();
			setState(319);
			match(T__9);
			setState(320);
			match(T__10);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(321);
				stmt();
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(327);
			match(T__11);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28) {
				{
				{
				setState(328);
				elsif();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(334);
				els();
				}
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

	public static class RepeatwhilestmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public RepeatwhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatwhilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterRepeatwhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitRepeatwhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitRepeatwhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatwhilestmtContext repeatwhilestmt() throws RecognitionException {
		RepeatwhilestmtContext _localctx = new RepeatwhilestmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_repeatwhilestmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__21);
			setState(338);
			match(T__7);
			setState(339);
			expression();
			setState(340);
			match(T__9);
			setState(341);
			match(T__10);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(342);
				stmt();
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348);
			match(T__11);
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

	public static class RepeatstmtContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PUTINParser.INT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public RepeatstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterRepeatstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitRepeatstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitRepeatstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatstmtContext repeatstmt() throws RecognitionException {
		RepeatstmtContext _localctx = new RepeatstmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_repeatstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(T__22);
			setState(351);
			match(T__7);
			setState(352);
			match(INT);
			setState(353);
			match(T__9);
			setState(354);
			match(T__10);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(355);
				stmt();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(361);
			match(T__11);
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

	public static class OptionsstmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public OptionsstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionsstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterOptionsstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitOptionsstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitOptionsstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsstmtContext optionsstmt() throws RecognitionException {
		OptionsstmtContext _localctx = new OptionsstmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_optionsstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(T__23);
			setState(364);
			match(T__7);
			setState(365);
			expression();
			setState(366);
			match(T__9);
			setState(367);
			match(T__10);
			setState(369); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(368);
				option();
				}
				}
				setState(371); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__30 );
			setState(374);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(373);
				def();
				}
			}

			setState(376);
			match(T__11);
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

	public static class ReturnstmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitReturnstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnstmtContext returnstmt() throws RecognitionException {
		ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(T__24);
			setState(379);
			expression();
			setState(380);
			match(T__16);
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

	public static class ForeachstmtContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ForeachstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterForeachstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitForeachstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitForeachstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachstmtContext foreachstmt() throws RecognitionException {
		ForeachstmtContext _localctx = new ForeachstmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_foreachstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__25);
			setState(383);
			match(T__7);
			setState(384);
			type();
			setState(385);
			match(T__26);
			setState(386);
			match(ID);
			setState(387);
			match(T__9);
			setState(388);
			match(T__10);
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(389);
				stmt();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(395);
			match(T__11);
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

	public static class MethodcallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public List<McContext> mc() {
			return getRuleContexts(McContext.class);
		}
		public McContext mc(int i) {
			return getRuleContext(McContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public MethodcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMethodcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_methodcall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(397);
					mc();
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(403);
			match(ID);
			setState(404);
			match(T__7);
			setState(413);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << DOUBLE) | (1L << DIRECTION) | (1L << TEXT) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(405);
				value();
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(406);
					match(T__8);
					setState(407);
					value();
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(415);
			match(T__9);
			setState(416);
			match(T__16);
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

	public static class Players1Context extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PUTINParser.INT, 0); }
		public Players1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_players1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterPlayers1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitPlayers1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitPlayers1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Players1Context players1() throws RecognitionException {
		Players1Context _localctx = new Players1Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_players1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(T__27);
			setState(419);
			match(T__15);
			setState(420);
			match(INT);
			setState(421);
			match(T__16);
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

	public static class Players2Context extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PUTINParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PUTINParser.ID, i);
		}
		public Players2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_players2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterPlayers2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitPlayers2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitPlayers2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Players2Context players2() throws RecognitionException {
		Players2Context _localctx = new Players2Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_players2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(T__27);
			setState(424);
			match(T__15);
			setState(425);
			match(T__7);
			setState(426);
			match(ID);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(427);
				match(T__8);
				setState(428);
				match(ID);
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(434);
			match(T__9);
			setState(435);
			match(T__16);
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

	public static class PiecetypeContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public PiecetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piecetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterPiecetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitPiecetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitPiecetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PiecetypeContext piecetype() throws RecognitionException {
		PiecetypeContext _localctx = new PiecetypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_piecetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(T__10);
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(438);
				stmt();
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(444);
			match(T__11);
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

	public static class ExpressionContext extends ParserRuleContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<RContext> r() {
			return getRuleContexts(RContext.class);
		}
		public RContext r(int i) {
			return getRuleContext(RContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			relation();
			setState(450);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(447);
					r();
					}
					} 
				}
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class RContext extends ParserRuleContext {
		public Token op;
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode OP_AND() { return getToken(PUTINParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(PUTINParser.OP_OR, 0); }
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			((RContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==OP_AND || _la==OP_OR) ) {
				((RContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(454);
			relation();
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

	public static class RelationContext extends ParserRuleContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			add();
			setState(460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(457);
					a();
					}
					} 
				}
				setState(462);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class AContext extends ParserRuleContext {
		public Token op;
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode OP_EQUALS() { return getToken(PUTINParser.OP_EQUALS, 0); }
		public TerminalNode OP_NOTEQUALS() { return getToken(PUTINParser.OP_NOTEQUALS, 0); }
		public TerminalNode OP_LESSTHAN() { return getToken(PUTINParser.OP_LESSTHAN, 0); }
		public TerminalNode OP_LARGERTHAN() { return getToken(PUTINParser.OP_LARGERTHAN, 0); }
		public TerminalNode OP_EQUALORLESSTHAN() { return getToken(PUTINParser.OP_EQUALORLESSTHAN, 0); }
		public TerminalNode OP_EQUALORLARGERTHAN() { return getToken(PUTINParser.OP_EQUALORLARGERTHAN, 0); }
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			((AContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_EQUALS) | (1L << OP_NOTEQUALS) | (1L << OP_LESSTHAN) | (1L << OP_LARGERTHAN) | (1L << OP_EQUALORLESSTHAN) | (1L << OP_EQUALORLARGERTHAN))) != 0)) ) {
				((AContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(464);
			add();
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

	public static class AddContext extends ParserRuleContext {
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public List<MContext> m() {
			return getRuleContexts(MContext.class);
		}
		public MContext m(int i) {
			return getRuleContext(MContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_add);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			mult();
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(467);
					m();
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class MContext extends ParserRuleContext {
		public Token op;
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public TerminalNode OP_PLUS() { return getToken(PUTINParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(PUTINParser.OP_MINUS, 0); }
		public MContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitM(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MContext m() throws RecognitionException {
		MContext _localctx = new MContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_m);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			((MContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==OP_PLUS || _la==OP_MINUS) ) {
				((MContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(474);
			mult();
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

	public static class MultContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public List<UContext> u() {
			return getRuleContexts(UContext.class);
		}
		public UContext u(int i) {
			return getRuleContext(UContext.class,i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_mult);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			unary();
			setState(480);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(477);
					u();
					}
					} 
				}
				setState(482);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public static class UContext extends ParserRuleContext {
		public Token op;
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode OP_MULTIPLY() { return getToken(PUTINParser.OP_MULTIPLY, 0); }
		public TerminalNode OP_DIVIDE() { return getToken(PUTINParser.OP_DIVIDE, 0); }
		public TerminalNode OP_MOD() { return getToken(PUTINParser.OP_MOD, 0); }
		public UContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_u; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterU(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitU(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitU(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UContext u() throws RecognitionException {
		UContext _localctx = new UContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_u);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			((UContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MULTIPLY) | (1L << OP_DIVIDE) | (1L << OP_MOD))) != 0)) ) {
				((UContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(484);
			unary();
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

	public static class UnaryContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public List<NContext> n() {
			return getRuleContexts(NContext.class);
		}
		public NContext n(int i) {
			return getRuleContext(NContext.class,i);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_PLUS || _la==OP_MINUS) {
				{
				{
				setState(486);
				n();
				}
				}
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			negation();
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

	public static class NContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OP_PLUS() { return getToken(PUTINParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(PUTINParser.OP_MINUS, 0); }
		public NContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NContext n() throws RecognitionException {
		NContext _localctx = new NContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_n);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			((NContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==OP_PLUS || _la==OP_MINUS) ) {
				((NContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
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

	public static class NegationContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_negation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_NOT) {
				{
				{
				setState(496);
				t();
				}
				}
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(502);
			term();
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

	public static class TContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OP_NOT() { return getToken(PUTINParser.OP_NOT, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			((TContext)_localctx).op = match(OP_NOT);
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

	public static class TermContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_term);
		try {
			setState(511);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				match(T__7);
				setState(508);
				expression();
				setState(509);
				match(T__9);
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

	public static class ElsifContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElsifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterElsif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitElsif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitElsif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsifContext elsif() throws RecognitionException {
		ElsifContext _localctx = new ElsifContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_elsif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(T__28);
			setState(514);
			match(T__7);
			setState(515);
			expression();
			setState(516);
			match(T__9);
			setState(517);
			match(T__10);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(518);
				stmt();
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(524);
			match(T__11);
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

	public static class ElsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_els; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterEls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitEls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitEls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsContext els() throws RecognitionException {
		ElsContext _localctx = new ElsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_els);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(T__29);
			setState(527);
			match(T__10);
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(528);
				stmt();
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(534);
			match(T__11);
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

	public static class OptionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(T__30);
			setState(537);
			expression();
			setState(538);
			match(T__31);
			setState(539);
			match(T__10);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(540);
				stmt();
				}
				}
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(546);
			match(T__11);
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

	public static class DefContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(T__32);
			setState(549);
			match(T__31);
			setState(550);
			match(T__10);
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << TYPE_NUMBER) | (1L << TYPE_TEXT) | (1L << TYPE_BOOLEAN) | (1L << TYPE_PLAYER) | (1L << TYPE_PIECE) | (1L << TYPE_LIST) | (1L << TYPE_COORDINATE) | (1L << ID))) != 0)) {
				{
				{
				setState(551);
				stmt();
				}
				}
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(557);
			match(T__11);
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

	public static class Assignmentstmt1Context extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public PiecetypeContext piecetype() {
			return getRuleContext(PiecetypeContext.class,0);
		}
		public Assignmentstmt1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentstmt1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterAssignmentstmt1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitAssignmentstmt1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitAssignmentstmt1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignmentstmt1Context assignmentstmt1() throws RecognitionException {
		Assignmentstmt1Context _localctx = new Assignmentstmt1Context(_ctx, getState());
		enterRule(_localctx, 98, RULE_assignmentstmt1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			type();
			setState(560);
			match(ID);
			setState(561);
			match(T__15);
			setState(562);
			piecetype();
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

	public static class Assignmentstmt2Context extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignmentstmt2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentstmt2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterAssignmentstmt2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitAssignmentstmt2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitAssignmentstmt2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignmentstmt2Context assignmentstmt2() throws RecognitionException {
		Assignmentstmt2Context _localctx = new Assignmentstmt2Context(_ctx, getState());
		enterRule(_localctx, 100, RULE_assignmentstmt2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			type();
			setState(565);
			match(ID);
			setState(566);
			match(T__15);
			setState(567);
			expression();
			setState(568);
			match(T__16);
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

	public static class Assignmentstmt3Context extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PUTINParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PUTINParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignmentstmt3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentstmt3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterAssignmentstmt3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitAssignmentstmt3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitAssignmentstmt3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignmentstmt3Context assignmentstmt3() throws RecognitionException {
		Assignmentstmt3Context _localctx = new Assignmentstmt3Context(_ctx, getState());
		enterRule(_localctx, 102, RULE_assignmentstmt3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(ID);
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(571);
				match(T__33);
				setState(572);
				match(ID);
				}
				}
				setState(577);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(578);
			match(T__15);
			setState(579);
			expression();
			setState(580);
			match(T__16);
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

	public static class McContext extends ParserRuleContext {
		public Mc1Context mc1() {
			return getRuleContext(Mc1Context.class,0);
		}
		public Mc2Context mc2() {
			return getRuleContext(Mc2Context.class,0);
		}
		public McContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final McContext mc() throws RecognitionException {
		McContext _localctx = new McContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_mc);
		try {
			setState(584);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				mc1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				mc2();
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

	public static class Mc1Context extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public Mc1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mc1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMc1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMc1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMc1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mc1Context mc1() throws RecognitionException {
		Mc1Context _localctx = new Mc1Context(_ctx, getState());
		enterRule(_localctx, 106, RULE_mc1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			match(ID);
			setState(587);
			match(T__33);
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

	public static class Mc2Context extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PUTINParser.ID, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Mc2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mc2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterMc2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitMc2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitMc2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mc2Context mc2() throws RecognitionException {
		Mc2Context _localctx = new Mc2Context(_ctx, getState());
		enterRule(_localctx, 108, RULE_mc2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(ID);
			setState(590);
			match(T__7);
			setState(599);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << DOUBLE) | (1L << DIRECTION) | (1L << TEXT) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(591);
				value();
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(592);
					match(T__8);
					setState(593);
					value();
					}
					}
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(601);
			match(T__9);
			setState(602);
			match(T__33);
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

	public static class CoordinateContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(PUTINParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(PUTINParser.INT, i);
		}
		public CoordinateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterCoordinate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitCoordinate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitCoordinate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinateContext coordinate() throws RecognitionException {
		CoordinateContext _localctx = new CoordinateContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_coordinate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(T__7);
			setState(605);
			match(INT);
			setState(606);
			match(T__8);
			setState(607);
			match(INT);
			setState(608);
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

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(PUTINParser.TEXT, 0); }
		public TerminalNode BOOL() { return getToken(PUTINParser.BOOL, 0); }
		public CoordinateContext coordinate() {
			return getRuleContext(CoordinateContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public StmtmethodContext stmtmethod() {
			return getRuleContext(StmtmethodContext.class,0);
		}
		public SinglemoveContext singlemove() {
			return getRuleContext(SinglemoveContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_value);
		try {
			setState(617);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(610);
				number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(611);
				match(TEXT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(612);
				match(BOOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(613);
				coordinate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(614);
				list();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(615);
				stmtmethod();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(616);
				singlemove();
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

	public static class SinglemoveContext extends ParserRuleContext {
		public TerminalNode DIRECTION() { return getToken(PUTINParser.DIRECTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SinglemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterSinglemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitSinglemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitSinglemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinglemoveContext singlemove() throws RecognitionException {
		SinglemoveContext _localctx = new SinglemoveContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_singlemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(DIRECTION);
			setState(620);
			expression();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PUTINParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(PUTINParser.DOUBLE, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE || _la==INT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class StmtmethodContext extends ParserRuleContext {
		public List<StmtmContext> stmtm() {
			return getRuleContexts(StmtmContext.class);
		}
		public StmtmContext stmtm(int i) {
			return getRuleContext(StmtmContext.class,i);
		}
		public StmtmethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtmethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterStmtmethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitStmtmethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitStmtmethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtmethodContext stmtmethod() throws RecognitionException {
		StmtmethodContext _localctx = new StmtmethodContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_stmtmethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			stmtm();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(625);
				match(T__33);
				setState(626);
				stmtm();
				}
				}
				setState(631);
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

	public static class ListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(T__7);
			setState(641);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << DOUBLE) | (1L << DIRECTION) | (1L << TEXT) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(633);
				value();
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(634);
					match(T__8);
					setState(635);
					value();
					}
					}
					setState(640);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(643);
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

	public static class StmtmContext extends ParserRuleContext {
		public Stmtm2Context stmtm2() {
			return getRuleContext(Stmtm2Context.class,0);
		}
		public Stmtm1Context stmtm1() {
			return getRuleContext(Stmtm1Context.class,0);
		}
		public StmtmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterStmtm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitStmtm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitStmtm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtmContext stmtm() throws RecognitionException {
		StmtmContext _localctx = new StmtmContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_stmtm);
		try {
			setState(647);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				stmtm2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(646);
				stmtm1();
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

	public static class Stmtm1Context extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PUTINParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PUTINParser.ID, i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Stmtm1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtm1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterStmtm1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitStmtm1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitStmtm1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmtm1Context stmtm1() throws RecognitionException {
		Stmtm1Context _localctx = new Stmtm1Context(_ctx, getState());
		enterRule(_localctx, 124, RULE_stmtm1);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(ID);
			setState(654);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(650);
					match(T__33);
					setState(651);
					match(ID);
					}
					} 
				}
				setState(656);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(669);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(657);
				match(T__7);
				setState(666);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << DOUBLE) | (1L << DIRECTION) | (1L << TEXT) | (1L << BOOL) | (1L << INT) | (1L << ID))) != 0)) {
					{
					setState(658);
					value();
					setState(663);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(659);
						match(T__8);
						setState(660);
						value();
						}
						}
						setState(665);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(668);
				match(T__9);
				}
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

	public static class Stmtm2Context extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PUTINParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PUTINParser.ID, i);
		}
		public Stmtm2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtm2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).enterStmtm2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PUTINListener ) ((PUTINListener)listener).exitStmtm2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PUTINVisitor ) return ((PUTINVisitor<? extends T>)visitor).visitStmtm2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmtm2Context stmtm2() throws RecognitionException {
		Stmtm2Context _localctx = new Stmtm2Context(_ctx, getState());
		enterRule(_localctx, 126, RULE_stmtm2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			match(ID);
			setState(676);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(672);
					match(T__33);
					setState(673);
					match(ID);
					}
					} 
				}
				setState(678);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u02aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u0089\n\2\f\2\16"+
		"\2\u008c\13\2\3\3\3\3\3\3\3\3\7\3\u0092\n\3\f\3\16\3\u0095\13\3\3\3\3"+
		"\3\3\4\3\4\3\4\7\4\u009c\n\4\f\4\16\4\u009f\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\7\5\u00a7\n\5\f\5\16\5\u00aa\13\5\3\5\3\5\3\6\3\6\3\6\6\6\u00b1\n\6"+
		"\r\6\16\6\u00b2\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00bb\n\7\f\7\16\7\u00be\13"+
		"\7\3\7\3\7\3\b\5\b\u00c3\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ca\n\b\f\b\16"+
		"\b\u00cd\13\b\5\b\u00cf\n\b\3\b\3\b\3\b\7\b\u00d4\n\b\f\b\16\b\u00d7\13"+
		"\b\3\b\5\b\u00da\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\5\n\u00e3\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ec\n\13\3\f\3\f\5\f\u00f0\n\f\3\r"+
		"\3\r\3\r\3\r\7\r\u00f6\n\r\f\r\16\r\u00f9\13\r\3\r\3\r\3\16\3\16\3\16"+
		"\7\16\u0100\n\16\f\16\16\16\u0103\13\16\3\16\3\16\3\17\3\17\5\17\u0109"+
		"\n\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0123\n\25"+
		"\f\25\16\25\u0126\13\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\7\26\u0132\n\26\f\26\16\26\u0135\13\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\5\27\u013d\n\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0145\n\30\f\30"+
		"\16\30\u0148\13\30\3\30\3\30\7\30\u014c\n\30\f\30\16\30\u014f\13\30\3"+
		"\30\5\30\u0152\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u015a\n\31\f\31"+
		"\16\31\u015d\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0167"+
		"\n\32\f\32\16\32\u016a\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\6"+
		"\33\u0174\n\33\r\33\16\33\u0175\3\33\5\33\u0179\n\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0189\n\35"+
		"\f\35\16\35\u018c\13\35\3\35\3\35\3\36\7\36\u0191\n\36\f\36\16\36\u0194"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\7\36\u019b\n\36\f\36\16\36\u019e\13\36"+
		"\5\36\u01a0\n\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \7 \u01b0\n \f \16 \u01b3\13 \3 \3 \3 \3!\3!\7!\u01ba\n!\f!\16!\u01bd"+
		"\13!\3!\3!\3\"\3\"\7\"\u01c3\n\"\f\"\16\"\u01c6\13\"\3#\3#\3#\3$\3$\7"+
		"$\u01cd\n$\f$\16$\u01d0\13$\3%\3%\3%\3&\3&\7&\u01d7\n&\f&\16&\u01da\13"+
		"&\3\'\3\'\3\'\3(\3(\7(\u01e1\n(\f(\16(\u01e4\13(\3)\3)\3)\3*\7*\u01ea"+
		"\n*\f*\16*\u01ed\13*\3*\3*\3+\3+\3,\7,\u01f4\n,\f,\16,\u01f7\13,\3,\3"+
		",\3-\3-\3.\3.\3.\3.\3.\5.\u0202\n.\3/\3/\3/\3/\3/\3/\7/\u020a\n/\f/\16"+
		"/\u020d\13/\3/\3/\3\60\3\60\3\60\7\60\u0214\n\60\f\60\16\60\u0217\13\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\7\61\u0220\n\61\f\61\16\61\u0223\13"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u022b\n\62\f\62\16\62\u022e\13"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\7\65\u0240\n\65\f\65\16\65\u0243\13\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\5\66\u024b\n\66\3\67\3\67\3\67\38\38\38\38\38\78\u0255\n"+
		"8\f8\168\u0258\138\58\u025a\n8\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:"+
		"\3:\3:\3:\5:\u026c\n:\3;\3;\3;\3<\3<\3=\3=\3=\7=\u0276\n=\f=\16=\u0279"+
		"\13=\3>\3>\3>\3>\7>\u027f\n>\f>\16>\u0282\13>\5>\u0284\n>\3>\3>\3?\3?"+
		"\5?\u028a\n?\3@\3@\3@\7@\u028f\n@\f@\16@\u0292\13@\3@\3@\3@\3@\7@\u0298"+
		"\n@\f@\16@\u029b\13@\5@\u029d\n@\3@\5@\u02a0\n@\3A\3A\3A\7A\u02a5\nA\f"+
		"A\16A\u02a8\13A\3A\2\2B\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\b\3\2&,\3"+
		"\2-.\3\2/\64\3\289\3\2\65\67\4\2%%>>\u02ae\2\u0082\3\2\2\2\4\u008d\3\2"+
		"\2\2\6\u0098\3\2\2\2\b\u00a2\3\2\2\2\n\u00ad\3\2\2\2\f\u00b7\3\2\2\2\16"+
		"\u00c2\3\2\2\2\20\u00dd\3\2\2\2\22\u00e2\3\2\2\2\24\u00eb\3\2\2\2\26\u00ef"+
		"\3\2\2\2\30\u00f1\3\2\2\2\32\u00fc\3\2\2\2\34\u0108\3\2\2\2\36\u010a\3"+
		"\2\2\2 \u010c\3\2\2\2\"\u010f\3\2\2\2$\u0112\3\2\2\2&\u0117\3\2\2\2(\u011c"+
		"\3\2\2\2*\u012a\3\2\2\2,\u013c\3\2\2\2.\u013e\3\2\2\2\60\u0153\3\2\2\2"+
		"\62\u0160\3\2\2\2\64\u016d\3\2\2\2\66\u017c\3\2\2\28\u0180\3\2\2\2:\u0192"+
		"\3\2\2\2<\u01a4\3\2\2\2>\u01a9\3\2\2\2@\u01b7\3\2\2\2B\u01c0\3\2\2\2D"+
		"\u01c7\3\2\2\2F\u01ca\3\2\2\2H\u01d1\3\2\2\2J\u01d4\3\2\2\2L\u01db\3\2"+
		"\2\2N\u01de\3\2\2\2P\u01e5\3\2\2\2R\u01eb\3\2\2\2T\u01f0\3\2\2\2V\u01f5"+
		"\3\2\2\2X\u01fa\3\2\2\2Z\u0201\3\2\2\2\\\u0203\3\2\2\2^\u0210\3\2\2\2"+
		"`\u021a\3\2\2\2b\u0226\3\2\2\2d\u0231\3\2\2\2f\u0236\3\2\2\2h\u023c\3"+
		"\2\2\2j\u024a\3\2\2\2l\u024c\3\2\2\2n\u024f\3\2\2\2p\u025e\3\2\2\2r\u026b"+
		"\3\2\2\2t\u026d\3\2\2\2v\u0270\3\2\2\2x\u0272\3\2\2\2z\u027a\3\2\2\2|"+
		"\u0289\3\2\2\2~\u028b\3\2\2\2\u0080\u02a1\3\2\2\2\u0082\u0083\5\4\3\2"+
		"\u0083\u0084\5\6\4\2\u0084\u0085\5\b\5\2\u0085\u0086\5\n\6\2\u0086\u008a"+
		"\5\f\7\2\u0087\u0089\5\16\b\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2"+
		"\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\3\3\2\2\2\u008c\u008a\3"+
		"\2\2\2\u008d\u008e\7\3\2\2\u008e\u008f\7\4\2\2\u008f\u0093\5\20\t\2\u0090"+
		"\u0092\5\22\n\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3"+
		"\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0097\7\5\2\2\u0097\5\3\2\2\2\u0098\u0099\7\6\2\2\u0099\u009d\7\4\2\2"+
		"\u009a\u009c\5\24\13\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\7\5\2\2\u00a1\7\3\2\2\2\u00a2\u00a3\7\7\2\2\u00a3\u00a4\7\4\2\2"+
		"\u00a4\u00a8\5\26\f\2\u00a5\u00a7\5\24\13\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7\5\2\2\u00ac\t\3\2\2\2\u00ad\u00ae"+
		"\7\b\2\2\u00ae\u00b0\7\4\2\2\u00af\u00b1\5\30\r\2\u00b0\u00af\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6\7\5\2\2\u00b6\13\3\2\2\2\u00b7"+
		"\u00b8\7\t\2\2\u00b8\u00bc\7\4\2\2\u00b9\u00bb\5\34\17\2\u00ba\u00b9\3"+
		"\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\5\2\2\u00c0\r\3\2\2\2"+
		"\u00c1\u00c3\5\36\20\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\7?\2\2\u00c5\u00ce\7\n\2\2\u00c6\u00cb\5 \21\2\u00c7"+
		"\u00c8\7\13\2\2\u00c8\u00ca\5\"\22\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d1\7\f\2\2\u00d1\u00d5\7\r\2\2\u00d2\u00d4\5\24\13\2\u00d3"+
		"\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\5\66\34\2\u00d9"+
		"\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\16"+
		"\2\2\u00dc\17\3\2\2\2\u00dd\u00de\5$\23\2\u00de\u00df\5&\24\2\u00df\21"+
		"\3\2\2\2\u00e0\u00e3\5(\25\2\u00e1\u00e3\5*\26\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\23\3\2\2\2\u00e4\u00ec\5,\27\2\u00e5\u00ec\5.\30"+
		"\2\u00e6\u00ec\5\60\31\2\u00e7\u00ec\5\62\32\2\u00e8\u00ec\5\64\33\2\u00e9"+
		"\u00ec\58\35\2\u00ea\u00ec\5:\36\2\u00eb\u00e4\3\2\2\2\u00eb\u00e5\3\2"+
		"\2\2\u00eb\u00e6\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\25\3\2\2\2\u00ed\u00f0\5<\37"+
		"\2\u00ee\u00f0\5> \2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\27"+
		"\3\2\2\2\u00f1\u00f2\7\17\2\2\u00f2\u00f3\7?\2\2\u00f3\u00f7\7\r\2\2\u00f4"+
		"\u00f6\5\24\13\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3"+
		"\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\7\16\2\2\u00fb\31\3\2\2\2\u00fc\u00fd\7\20\2\2\u00fd\u0101\7\r"+
		"\2\2\u00fe\u0100\5\24\13\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u0105\7\16\2\2\u0105\33\3\2\2\2\u0106\u0109\5.\30\2\u0107\u0109"+
		"\5\64\33\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\35\3\2\2\2\u010a"+
		"\u010b\t\2\2\2\u010b\37\3\2\2\2\u010c\u010d\5\36\20\2\u010d\u010e\7?\2"+
		"\2\u010e!\3\2\2\2\u010f\u0110\5\36\20\2\u0110\u0111\7?\2\2\u0111#\3\2"+
		"\2\2\u0112\u0113\7\21\2\2\u0113\u0114\7\22\2\2\u0114\u0115\7>\2\2\u0115"+
		"\u0116\7\23\2\2\u0116%\3\2\2\2\u0117\u0118\7\24\2\2\u0118\u0119\7\22\2"+
		"\2\u0119\u011a\7>\2\2\u011a\u011b\7\23\2\2\u011b\'\3\2\2\2\u011c\u011d"+
		"\7\25\2\2\u011d\u011e\7\22\2\2\u011e\u011f\7\n\2\2\u011f\u0124\5p9\2\u0120"+
		"\u0121\7\13\2\2\u0121\u0123\5p9\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0127\u0128\7\f\2\2\u0128\u0129\7\23\2\2\u0129)\3\2\2\2"+
		"\u012a\u012b\7\26\2\2\u012b\u012c\7?\2\2\u012c\u012d\7\22\2\2\u012d\u012e"+
		"\7\n\2\2\u012e\u0133\5p9\2\u012f\u0130\7\13\2\2\u0130\u0132\5p9\2\u0131"+
		"\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7\f\2\2\u0137"+
		"\u0138\7\23\2\2\u0138+\3\2\2\2\u0139\u013d\5d\63\2\u013a\u013d\5f\64\2"+
		"\u013b\u013d\5h\65\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b"+
		"\3\2\2\2\u013d-\3\2\2\2\u013e\u013f\7\27\2\2\u013f\u0140\7\n\2\2\u0140"+
		"\u0141\5B\"\2\u0141\u0142\7\f\2\2\u0142\u0146\7\r\2\2\u0143\u0145\5\24"+
		"\13\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014d\7\16"+
		"\2\2\u014a\u014c\5\\/\2\u014b\u014a\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u0150\u0152\5^\60\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"/\3\2\2\2\u0153\u0154\7\30\2\2\u0154\u0155\7\n\2\2\u0155\u0156\5B\"\2"+
		"\u0156\u0157\7\f\2\2\u0157\u015b\7\r\2\2\u0158\u015a\5\24\13\2\u0159\u0158"+
		"\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7\16\2\2\u015f\61\3\2\2"+
		"\2\u0160\u0161\7\31\2\2\u0161\u0162\7\n\2\2\u0162\u0163\7>\2\2\u0163\u0164"+
		"\7\f\2\2\u0164\u0168\7\r\2\2\u0165\u0167\5\24\13\2\u0166\u0165\3\2\2\2"+
		"\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b"+
		"\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7\16\2\2\u016c\63\3\2\2\2\u016d"+
		"\u016e\7\32\2\2\u016e\u016f\7\n\2\2\u016f\u0170\5B\"\2\u0170\u0171\7\f"+
		"\2\2\u0171\u0173\7\r\2\2\u0172\u0174\5`\61\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0179\5b\62\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\7\16\2\2\u017b\65\3\2\2\2\u017c\u017d\7\33"+
		"\2\2\u017d\u017e\5B\"\2\u017e\u017f\7\23\2\2\u017f\67\3\2\2\2\u0180\u0181"+
		"\7\34\2\2\u0181\u0182\7\n\2\2\u0182\u0183\5\36\20\2\u0183\u0184\7\35\2"+
		"\2\u0184\u0185\7?\2\2\u0185\u0186\7\f\2\2\u0186\u018a\7\r\2\2\u0187\u0189"+
		"\5\24\13\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2"+
		"\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e"+
		"\7\16\2\2\u018e9\3\2\2\2\u018f\u0191\5j\66\2\u0190\u018f\3\2\2\2\u0191"+
		"\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2"+
		"\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7?\2\2\u0196\u019f\7\n\2\2\u0197"+
		"\u019c\5r:\2\u0198\u0199\7\13\2\2\u0199\u019b\5r:\2\u019a\u0198\3\2\2"+
		"\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a0"+
		"\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u0197\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a2\7\f\2\2\u01a2\u01a3\7\23\2\2\u01a3;\3\2\2\2"+
		"\u01a4\u01a5\7\36\2\2\u01a5\u01a6\7\22\2\2\u01a6\u01a7\7>\2\2\u01a7\u01a8"+
		"\7\23\2\2\u01a8=\3\2\2\2\u01a9\u01aa\7\36\2\2\u01aa\u01ab\7\22\2\2\u01ab"+
		"\u01ac\7\n\2\2\u01ac\u01b1\7?\2\2\u01ad\u01ae\7\13\2\2\u01ae\u01b0\7?"+
		"\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7\f"+
		"\2\2\u01b5\u01b6\7\23\2\2\u01b6?\3\2\2\2\u01b7\u01bb\7\r\2\2\u01b8\u01ba"+
		"\5\24\13\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2"+
		"\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf"+
		"\7\16\2\2\u01bfA\3\2\2\2\u01c0\u01c4\5F$\2\u01c1\u01c3\5D#\2\u01c2\u01c1"+
		"\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"C\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\t\3\2\2\u01c8\u01c9\5F$\2\u01c9"+
		"E\3\2\2\2\u01ca\u01ce\5J&\2\u01cb\u01cd\5H%\2\u01cc\u01cb\3\2\2\2\u01cd"+
		"\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cfG\3\2\2\2"+
		"\u01d0\u01ce\3\2\2\2\u01d1\u01d2\t\4\2\2\u01d2\u01d3\5J&\2\u01d3I\3\2"+
		"\2\2\u01d4\u01d8\5N(\2\u01d5\u01d7\5L\'\2\u01d6\u01d5\3\2\2\2\u01d7\u01da"+
		"\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9K\3\2\2\2\u01da"+
		"\u01d8\3\2\2\2\u01db\u01dc\t\5\2\2\u01dc\u01dd\5N(\2\u01ddM\3\2\2\2\u01de"+
		"\u01e2\5R*\2\u01df\u01e1\5P)\2\u01e0\u01df\3\2\2\2\u01e1\u01e4\3\2\2\2"+
		"\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3O\3\2\2\2\u01e4\u01e2\3"+
		"\2\2\2\u01e5\u01e6\t\6\2\2\u01e6\u01e7\5R*\2\u01e7Q\3\2\2\2\u01e8\u01ea"+
		"\5T+\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\5V"+
		",\2\u01efS\3\2\2\2\u01f0\u01f1\t\5\2\2\u01f1U\3\2\2\2\u01f2\u01f4\5X-"+
		"\2\u01f3\u01f2\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f9\5Z.\2\u01f9"+
		"W\3\2\2\2\u01fa\u01fb\7:\2\2\u01fbY\3\2\2\2\u01fc\u0202\5r:\2\u01fd\u01fe"+
		"\7\n\2\2\u01fe\u01ff\5B\"\2\u01ff\u0200\7\f\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01fc\3\2\2\2\u0201\u01fd\3\2\2\2\u0202[\3\2\2\2\u0203\u0204\7\37\2\2"+
		"\u0204\u0205\7\n\2\2\u0205\u0206\5B\"\2\u0206\u0207\7\f\2\2\u0207\u020b"+
		"\7\r\2\2\u0208\u020a\5\24\13\2\u0209\u0208\3\2\2\2\u020a\u020d\3\2\2\2"+
		"\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020b"+
		"\3\2\2\2\u020e\u020f\7\16\2\2\u020f]\3\2\2\2\u0210\u0211\7 \2\2\u0211"+
		"\u0215\7\r\2\2\u0212\u0214\5\24\13\2\u0213\u0212\3\2\2\2\u0214\u0217\3"+
		"\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0218\u0219\7\16\2\2\u0219_\3\2\2\2\u021a\u021b\7!\2\2"+
		"\u021b\u021c\5B\"\2\u021c\u021d\7\"\2\2\u021d\u0221\7\r\2\2\u021e\u0220"+
		"\5\24\13\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2"+
		"\u0221\u0222\3\2\2\2\u0222\u0224\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0225"+
		"\7\16\2\2\u0225a\3\2\2\2\u0226\u0227\7#\2\2\u0227\u0228\7\"\2\2\u0228"+
		"\u022c\7\r\2\2\u0229\u022b\5\24\13\2\u022a\u0229\3\2\2\2\u022b\u022e\3"+
		"\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e"+
		"\u022c\3\2\2\2\u022f\u0230\7\16\2\2\u0230c\3\2\2\2\u0231\u0232\5\36\20"+
		"\2\u0232\u0233\7?\2\2\u0233\u0234\7\22\2\2\u0234\u0235\5@!\2\u0235e\3"+
		"\2\2\2\u0236\u0237\5\36\20\2\u0237\u0238\7?\2\2\u0238\u0239\7\22\2\2\u0239"+
		"\u023a\5B\"\2\u023a\u023b\7\23\2\2\u023bg\3\2\2\2\u023c\u0241\7?\2\2\u023d"+
		"\u023e\7$\2\2\u023e\u0240\7?\2\2\u023f\u023d\3\2\2\2\u0240\u0243\3\2\2"+
		"\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0244\3\2\2\2\u0243\u0241"+
		"\3\2\2\2\u0244\u0245\7\22\2\2\u0245\u0246\5B\"\2\u0246\u0247\7\23\2\2"+
		"\u0247i\3\2\2\2\u0248\u024b\5l\67\2\u0249\u024b\5n8\2\u024a\u0248\3\2"+
		"\2\2\u024a\u0249\3\2\2\2\u024bk\3\2\2\2\u024c\u024d\7?\2\2\u024d\u024e"+
		"\7$\2\2\u024em\3\2\2\2\u024f\u0250\7?\2\2\u0250\u0259\7\n\2\2\u0251\u0256"+
		"\5r:\2\u0252\u0253\7\13\2\2\u0253\u0255\5r:\2\u0254\u0252\3\2\2\2\u0255"+
		"\u0258\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u025a\3\2"+
		"\2\2\u0258\u0256\3\2\2\2\u0259\u0251\3\2\2\2\u0259\u025a\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025c\7\f\2\2\u025c\u025d\7$\2\2\u025do\3\2\2\2\u025e"+
		"\u025f\7\n\2\2\u025f\u0260\7>\2\2\u0260\u0261\7\13\2\2\u0261\u0262\7>"+
		"\2\2\u0262\u0263\7\f\2\2\u0263q\3\2\2\2\u0264\u026c\5v<\2\u0265\u026c"+
		"\7<\2\2\u0266\u026c\7=\2\2\u0267\u026c\5p9\2\u0268\u026c\5z>\2\u0269\u026c"+
		"\5x=\2\u026a\u026c\5t;\2\u026b\u0264\3\2\2\2\u026b\u0265\3\2\2\2\u026b"+
		"\u0266\3\2\2\2\u026b\u0267\3\2\2\2\u026b\u0268\3\2\2\2\u026b\u0269\3\2"+
		"\2\2\u026b\u026a\3\2\2\2\u026cs\3\2\2\2\u026d\u026e\7;\2\2\u026e\u026f"+
		"\5B\"\2\u026fu\3\2\2\2\u0270\u0271\t\7\2\2\u0271w\3\2\2\2\u0272\u0277"+
		"\5|?\2\u0273\u0274\7$\2\2\u0274\u0276\5|?\2\u0275\u0273\3\2\2\2\u0276"+
		"\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278y\3\2\2\2"+
		"\u0279\u0277\3\2\2\2\u027a\u0283\7\n\2\2\u027b\u0280\5r:\2\u027c\u027d"+
		"\7\13\2\2\u027d\u027f\5r:\2\u027e\u027c\3\2\2\2\u027f\u0282\3\2\2\2\u0280"+
		"\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0280\3\2"+
		"\2\2\u0283\u027b\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u0286\7\f\2\2\u0286{\3\2\2\2\u0287\u028a\5\u0080A\2\u0288\u028a\5~@\2"+
		"\u0289\u0287\3\2\2\2\u0289\u0288\3\2\2\2\u028a}\3\2\2\2\u028b\u0290\7"+
		"?\2\2\u028c\u028d\7$\2\2\u028d\u028f\7?\2\2\u028e\u028c\3\2\2\2\u028f"+
		"\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u029f\3\2"+
		"\2\2\u0292\u0290\3\2\2\2\u0293\u029c\7\n\2\2\u0294\u0299\5r:\2\u0295\u0296"+
		"\7\13\2\2\u0296\u0298\5r:\2\u0297\u0295\3\2\2\2\u0298\u029b\3\2\2\2\u0299"+
		"\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029d\3\2\2\2\u029b\u0299\3\2"+
		"\2\2\u029c\u0294\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\3\2\2\2\u029e"+
		"\u02a0\7\f\2\2\u029f\u0293\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\177\3\2\2"+
		"\2\u02a1\u02a6\7?\2\2\u02a2\u02a3\7$\2\2\u02a3\u02a5\7?\2\2\u02a4\u02a2"+
		"\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7"+
		"\u0081\3\2\2\2\u02a8\u02a6\3\2\2\2<\u008a\u0093\u009d\u00a8\u00b2\u00bc"+
		"\u00c2\u00cb\u00ce\u00d5\u00d9\u00e2\u00eb\u00ef\u00f7\u0101\u0108\u0124"+
		"\u0133\u013c\u0146\u014d\u0151\u015b\u0168\u0175\u0178\u018a\u0192\u019c"+
		"\u019f\u01b1\u01bb\u01c4\u01ce\u01d8\u01e2\u01eb\u01f5\u0201\u020b\u0215"+
		"\u0221\u022c\u0241\u024a\u0256\u0259\u026b\u0277\u0280\u0283\u0289\u0290"+
		"\u0299\u029c\u029f\u02a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}