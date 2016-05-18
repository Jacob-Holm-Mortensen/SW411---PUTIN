// Generated from C:/Users/jacobholm/Desktop/PUTIN\PUTIN.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PUTINParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PUTINVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PUTINParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PUTINParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#board}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoard(PUTINParser.BoardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#pieces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPieces(PUTINParser.PiecesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(PUTINParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(PUTINParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#wincondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWincondition(PUTINParser.WinconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(PUTINParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(PUTINParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#boardparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoardparam(PUTINParser.BoardparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(PUTINParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#players}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayers(PUTINParser.PlayersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#turn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurn(PUTINParser.TurnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#turndistribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurndistribution(PUTINParser.TurndistributionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#wincnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWincnd(PUTINParser.WincndContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PUTINParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#nextm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextm(PUTINParser.NextmContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#nextnextm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextnextm(PUTINParser.NextnextmContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#height}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeight(PUTINParser.HeightContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#width}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidth(PUTINParser.WidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#illigaltiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlligaltiles(PUTINParser.IlligaltilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#specialtiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialtiles(PUTINParser.SpecialtilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#assignmentstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentstmt(PUTINParser.AssignmentstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(PUTINParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#repeatwhilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatwhilestmt(PUTINParser.RepeatwhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#repeatstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatstmt(PUTINParser.RepeatstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#optionsstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionsstmt(PUTINParser.OptionsstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#returnstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstmt(PUTINParser.ReturnstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#foreachstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachstmt(PUTINParser.ForeachstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#methodcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(PUTINParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#players1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayers1(PUTINParser.Players1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#players2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayers2(PUTINParser.Players2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#piecetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiecetype(PUTINParser.PiecetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PUTINParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(PUTINParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(PUTINParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(PUTINParser.AContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(PUTINParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM(PUTINParser.MContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(PUTINParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#u}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitU(PUTINParser.UContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(PUTINParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#n}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN(PUTINParser.NContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(PUTINParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(PUTINParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PUTINParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#elsif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsif(PUTINParser.ElsifContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#els}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEls(PUTINParser.ElsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(PUTINParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(PUTINParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#assignmentstmt1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentstmt1(PUTINParser.Assignmentstmt1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#assignmentstmt2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentstmt2(PUTINParser.Assignmentstmt2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#assignmentstmt3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentstmt3(PUTINParser.Assignmentstmt3Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#mc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMc(PUTINParser.McContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#mc1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMc1(PUTINParser.Mc1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#mc2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMc2(PUTINParser.Mc2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#coordinate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate(PUTINParser.CoordinateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PUTINParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#singlemove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglemove(PUTINParser.SinglemoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PUTINParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#stmtmethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtmethod(PUTINParser.StmtmethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(PUTINParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#stmtm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtm(PUTINParser.StmtmContext ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#stmtm1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtm1(PUTINParser.Stmtm1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PUTINParser#stmtm2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtm2(PUTINParser.Stmtm2Context ctx);
}