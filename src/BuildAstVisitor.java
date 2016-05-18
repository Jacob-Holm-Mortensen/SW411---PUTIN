import com.sun.org.apache.xerces.internal.util.SymbolTable;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.org.apache.xpath.internal.operations.Neg;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BuildAstVisitor extends PUTINBaseVisitor<PUTINNode>{
    HashMap<String, SymbolTableEntry> SymbolTable = new HashMap<String, SymbolTableEntry>();
    ArrayList<String> ErrorLog = new ArrayList<String>();

    public ArrayList<String> getErrorLog(){
        return ErrorLog;
    }

    @Override
    public PUTINNode visitProgram(PUTINParser.ProgramContext ctx) {
        ProgramNode node = new ProgramNode();
        node.BoardN = (BoardNode) visitBoard(ctx.board());
        node.PieceN = (PiecesNode) visitPieces(ctx.pieces());
        node.SetupN = (SetupNode) visitSetup(ctx.setup());
        node.RulesN = (RulesNode) visitRules(ctx.rules());
        node.WinConditionN = (WinConditionNode) visitWincondition(ctx.wincondition());
        for (PUTINParser.MethodContext M : ctx.method()) {
            node.methodNA.add((MethodNode) visitMethod(M));
        }
        return node;
    }

    @Override
    public PUTINNode visitBoard(PUTINParser.BoardContext ctx) {
        BoardNode node = new BoardNode();
        node.SizeN = (SizeNode) visitSize(ctx.size());
        for (PUTINParser.BoardparamContext B : ctx.boardparam()) {
            node.BoardParamNA.add((BoardParamNode) visitBoardparam(B));
        }
        return node;
    }

    @Override
    public PUTINNode visitPieces(PUTINParser.PiecesContext ctx) {
        PiecesNode node = new PiecesNode();
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitSetup(PUTINParser.SetupContext ctx) {
        SetupNode node = new SetupNode();
        node.PlayersN = (PlayersNode) visitPlayers(ctx.players());
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitRules(PUTINParser.RulesContext ctx) {
        RulesNode node = new RulesNode();
        for (PUTINParser.TurnContext T : ctx.turn()) {
            node.TurnNA.add((TurnNode) visitTurn(T));
        }
        node.TurnDistributionN = (TurnDistributionNode) visitTurndistribution(ctx.turndistribution());
        return node;
    }

    @Override
    public PUTINNode visitWincondition(PUTINParser.WinconditionContext ctx) {
        WinConditionNode node = new WinConditionNode();
        for (PUTINParser.WincndContext W : ctx.wincnd()) {
            node.WinCNDNA.add((WinCNDNode) visitWincnd(W));
        }
        return node;
    }

    @Override
    public PUTINNode visitMethod(PUTINParser.MethodContext ctx) {
        MethodNode node = new MethodNode();
        if(ctx.type() != null)
            node.TypeNA1.add((TypeNode) visitType(ctx.type()));
        node.IdN.Value = ctx.ID().toString();
        if(ctx.nextm().type() != null)
            node.TypeNA2.add((TypeNode) visitType(ctx.nextm().type()));
        if(ctx.nextm().ID() != null){
            IdNode node1 = new IdNode();
            node1.Value = ctx.nextm().ID().toString();
            node.IdNA.add(node1);
        }
        for (PUTINParser.NextnextmContext N : ctx.nextnextm()) {
            node.TypeNA2.add((TypeNode) visitType(N.type()));
            IdNode node1 = new IdNode();
            node1.Value = N.ID().toString();
            node.IdNA.add(node1);
        }
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        if (ctx.returnstmt() != null){
            node.ReturnStmtNA.add((ReturnStmtNode) visitReturnstmt(ctx.returnstmt()));
        }
        return node;
    }

    @Override
    public PUTINNode visitSize(PUTINParser.SizeContext ctx) {
        SizeNode node = new SizeNode();
        node.HeightN = (HeightNode) visitHeight(ctx.height());
        node.WidthN = (WidthNode) visitWidth(ctx.width());
        return node;
    }

    @Override
    public PUTINNode visitBoardparam(PUTINParser.BoardparamContext ctx) {
        BoardParamNode node = null;
        if (ctx.illigaltiles() != null){
            node = new IlligalTilesNode();
        }
        else if (ctx.specialtiles() != null){
            node = new SpecialTilesNode();
        }
        if(node instanceof IlligalTilesNode){
            for (PUTINParser.CoordinateContext C : ctx.illigaltiles().coordinate()) {
                ((IlligalTilesNode) node).CoordinateNA.add((CoordinateNode) visitCoordinate(C));
            }
        }
        else if(node instanceof SpecialTilesNode){
            IdNode node1 = new IdNode();
            node1.Value = ctx.specialtiles().ID().toString();
            ((SpecialTilesNode) node).IdN = node1;
            for (PUTINParser.CoordinateContext C : ctx.specialtiles().coordinate()) {
                ((SpecialTilesNode) node).CoordinateNA.add((CoordinateNode) visitCoordinate(C));
            }
        }
        return node;
    }

    @Override
    public PUTINNode visitStmt(PUTINParser.StmtContext ctx) {
        StmtNode node = null;
        if (ctx.assignmentstmt() != null){
            node = (AssignmentStmtNode) visitAssignmentstmt(ctx.assignmentstmt());
        }
        else if(ctx.ifstmt() != null){
            node = (IfStmtNode) visitIfstmt(ctx.ifstmt());
        }
        else if(ctx.repeatwhilestmt() != null){
            node = (RepeatWhileStmtNode) visitRepeatwhilestmt(ctx.repeatwhilestmt());
        }
        else if(ctx.repeatstmt() != null){
            node = (RepeatStmtNode) visitRepeatstmt(ctx.repeatstmt());
        }
        else if(ctx.optionsstmt() != null){
            node = (OptionsStmtNode) visitOptionsstmt(ctx.optionsstmt());
        }
        else if(ctx.foreachstmt() != null){
            node = (ForeachStmtNode) visitForeachstmt(ctx.foreachstmt());
        }
        else if(ctx.methodcall() != null){
            node = (MethodCallNode) visitMethodcall(ctx.methodcall());
        }
        return node;
    }

    @Override
    public PUTINNode visitPlayers(PUTINParser.PlayersContext ctx) {
        PlayersNode node = null;
        if(ctx.players1() != null){
            node = new PlayersNode1();
            NumberValueNode node1 = new NumberValueNode();
            node1.Value = Double.parseDouble(ctx.players1().INT().toString());
            ((PlayersNode1) node).NumberValueN = node1;
        }
        else if(ctx.players2() != null){
            node = new PlayersNode2();
            for (TerminalNode I : ctx.players2().ID()) {
                IdNode node2 = new IdNode();
                node2.Value = I.toString();
                ((PlayersNode2) node).IdNA.add(node2);
            }
        }
        return node;
    }

    @Override
    public PUTINNode visitTurn(PUTINParser.TurnContext ctx) {
        TurnNode node = new TurnNode();
        IdNode node1 = new IdNode();
        node1.Value = ctx.ID().toString();
        node.IdN = node1;
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitTurndistribution(PUTINParser.TurndistributionContext ctx) {
        TurnDistributionNode node = new TurnDistributionNode();
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitWincnd(PUTINParser.WincndContext ctx) {
        WinCNDNode node = null;
        if(ctx.ifstmt() != null){
            node = new WinCNDNode1();
            ((WinCNDNode1) node).IfStmtN = (IfStmtNode) visitIfstmt(ctx.ifstmt());
        }
        else if(ctx.optionsstmt() != null){
            node = new WinCNDNode2();
            ((WinCNDNode2) node).OptionsStmtN = (OptionsStmtNode) visitOptionsstmt(ctx.optionsstmt());
        }
        return node;
    }

    @Override
    public PUTINNode visitType(PUTINParser.TypeContext ctx) {
        if (ctx.TYPE_NUMBER() != null)
            return new NumberTNode();
        else if (ctx.TYPE_TEXT() != null)
            return new TextTNode();
        else if (ctx.TYPE_BOOLEAN() != null)
            return new BooleanTNode();
        else if (ctx.TYPE_PLAYER() != null)
            return new PlayerTNode();
        else if (ctx.TYPE_PIECE() != null)
            return new PieceTNode();
        else if (ctx.TYPE_LIST() != null)
            return new ListTNode();
        else
            return new CoordinateTNode();
    }

    @Override
    public PUTINNode visitHeight(PUTINParser.HeightContext ctx) {
        HeightNode node = new HeightNode();
        NumberValueNode node1 = new NumberValueNode();
        node1.Value = Double.parseDouble(ctx.INT().toString());
        node.NumberValueN = node1;
        return node;
    }

    @Override
    public PUTINNode visitWidth(PUTINParser.WidthContext ctx) {
        WidthNode node = new WidthNode();
        NumberValueNode node1 = new NumberValueNode();
        node1.Value = Double.parseDouble(ctx.INT().toString());
        node.NumberValueN = node1;
        return node;
    }

    @Override
    public PUTINNode visitIlligaltiles(PUTINParser.IlligaltilesContext ctx) {
        IlligalTilesNode node = new IlligalTilesNode();
        for (PUTINParser.CoordinateContext C : ctx.coordinate()) {
            node.CoordinateNA.add((CoordinateNode) visitCoordinate(C));
        }
        return node;
    }

    @Override
    public PUTINNode visitSpecialtiles(PUTINParser.SpecialtilesContext ctx) {
        SpecialTilesNode node = new SpecialTilesNode();
        IdNode node1 = new IdNode();
        node1.Value = ctx.ID().toString();
        node.IdN = node1;
        for (PUTINParser.CoordinateContext C : ctx.coordinate()) {
            node.CoordinateNA.add((CoordinateNode) visitCoordinate(C));
        }
        return node;
    }

    @Override
    public PUTINNode visitAssignmentstmt(PUTINParser.AssignmentstmtContext ctx) {
        AssignmentStmtNode node = null;
        if(ctx.assignmentstmt1() != null){
            node = new AssignmentStmtNode1();
            ((AssignmentStmtNode1) node).TypeN = (TypeNode) visitType(ctx.assignmentstmt1().type());
            ((AssignmentStmtNode1) node).IdN.Value = ctx.assignmentstmt1().ID().toString();
            ((AssignmentStmtNode1) node).PieceTypeN = (PieceTypeNode) visitPiecetype(ctx.assignmentstmt1().piecetype());
        }
        else if(ctx.assignmentstmt2() != null){
            node = new AssignmentStmtNode2();
            ((AssignmentStmtNode2) node).TypeN = (TypeNode) visitType(ctx.assignmentstmt2().type());
            IdNode node1 = new IdNode();
            node1.Value = ctx.assignmentstmt2().ID().toString();
            ((AssignmentStmtNode2) node).IdN = node1;
            ((AssignmentStmtNode2) node).ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.assignmentstmt2().expression()));
        }
        else if(ctx.assignmentstmt3() != null){
            node = new AssignmentStmtNode3();
            for (TerminalNode I : ctx.assignmentstmt3().ID()) {
                IdNode node1 = new IdNode();
                node1.Value = I.toString();
                ((AssignmentStmtNode3) node).IdNA.add(node1);
            }
            ((AssignmentStmtNode3) node).ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.assignmentstmt3().expression()));
        }
        return node;
    }

    @Override
    public PUTINNode visitIfstmt(PUTINParser.IfstmtContext ctx) {
        IfStmtNode node = new IfStmtNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        for (PUTINParser.ElsifContext E : ctx.elsif()) {
            node.ElsIfNA.add((ElsIfNode) visitElsif(E));
        }
        if(ctx.els() != null)
            node.ElsNA.add((ElsNode) visitEls(ctx.els()));
        return node;
    }

    @Override
    public PUTINNode visitRepeatwhilestmt(PUTINParser.RepeatwhilestmtContext ctx) {
        RepeatWhileStmtNode node = new RepeatWhileStmtNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitRepeatstmt(PUTINParser.RepeatstmtContext ctx) {
        RepeatStmtNode node = new RepeatStmtNode();
        NumberValueNode node1 = new NumberValueNode();
        node1.Value = Double.parseDouble(ctx.INT().toString());
        node.NumberValueN = node1;
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitOptionsstmt(PUTINParser.OptionsstmtContext ctx) {
        OptionsStmtNode node = new OptionsStmtNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        for (PUTINParser.OptionContext O : ctx.option()) {
            node.OptionNA.add((OptionNode) visitOption(O));
        }
        if(ctx.def() != null)
            node.DefNA.add((DefNode) visitDef(ctx.def()));
        return node;
    }

    @Override
    public PUTINNode visitReturnstmt(PUTINParser.ReturnstmtContext ctx) {
        ReturnStmtNode node = new ReturnStmtNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        return node;
    }

    @Override
    public PUTINNode visitForeachstmt(PUTINParser.ForeachstmtContext ctx) {
        ForeachStmtNode node = new ForeachStmtNode();
        node.TypeN = (TypeNode) visitType(ctx.type());
        IdNode node1 = new IdNode();
        node1.Value = ctx.ID().toString();
        node.IdN = node1;
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitMethodcall(PUTINParser.MethodcallContext ctx) {
        MethodCallNode node = new MethodCallNode();
        for (PUTINParser.McContext M : ctx.mc()) {
            if (M.mc1() != null) {
                MCNode1 node1 = new MCNode1();
                IdNode node2 = new IdNode();
                node2.Value = M.mc1().ID().toString();
                node1.IdN = node2;
                node.MCNA.add(node1);
            }
            else if (M.mc2() != null) {
                MCNode2 node3 = new MCNode2();
                IdNode node4 = new IdNode();
                node4.Value = M.mc2().ID().toString();
                node3.IdN = node4;
                for (PUTINParser.ValueContext V : M.mc2().value()) {
                    node3.ValueNA.add((ValueNode) visitValue(V));
                }
                node.MCNA.add(node3);
            }
        }
        IdNode node5 = new IdNode();
        node5.Value = ctx.ID().toString();
        node.IdN = node5;
        for (PUTINParser.ValueContext V : ctx.value()) {
            node.ValueNA.add((ValueNode) visitValue(V));
        }
        return node;
    }

    @Override
    public PUTINNode visitPiecetype(PUTINParser.PiecetypeContext ctx) {
        PieceTypeNode node = new PieceTypeNode();
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitExpression(PUTINParser.ExpressionContext ctx) {
        ExpressionNode node = null;
        if (ctx.r().size() != 0){
            switch (ctx.r(ctx.r().size() - 1).op.getType()) {
                case PUTINLexer.OP_AND: node = new AndNode(); break;
                case PUTINLexer.OP_OR:  node = new OrNode(); break;
            }
            ((BinaryExpressionNode) node).RightN = (ExpressionNode) visitRelation(ctx.r(ctx.r().size()-1).relation());
            BinaryExpressionNode CurrentNode = (BinaryExpressionNode) node;
            for (int i = ctx.r().size() - 2; i >= 0; i--) {
                switch (ctx.r(i).op.getType()) {
                    case PUTINLexer.OP_AND  : CurrentNode.LeftN = new AndNode();
                                              CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                              CurrentNode.RightN = (ExpressionNode) visitRelation(ctx.r(i).relation());
                                              break;
                    case PUTINLexer.OP_OR   : CurrentNode.LeftN = new OrNode();
                                              CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                              CurrentNode.RightN = (ExpressionNode) visitRelation(ctx.r(i).relation());
                                              break;
                }
            }
            CurrentNode.LeftN = (ExpressionNode) visitRelation(ctx.relation());
            return node;
        }
        else{
            return visitRelation(ctx.relation());
        }
    }

    @Override
    public PUTINNode visitRelation(PUTINParser.RelationContext ctx) {
        ExpressionNode node = null;
        if (ctx.a().size() != 0){
            switch (ctx.a(ctx.a().size() - 1).op.getType()) {
                case PUTINLexer.OP_EQUALS:              node = new EqualsNode(); break;
                case PUTINLexer.OP_NOTEQUALS:           node = new NotEqualsNode(); break;
                case PUTINLexer.OP_LESSTHAN:            node = new LessThanNode(); break;
                case PUTINLexer.OP_LARGERTHAN:          node = new LargerThanNode(); break;
                case PUTINLexer.OP_EQUALORLESSTHAN:     node = new EqualOrLessThanNode(); break;
                case PUTINLexer.OP_EQUALORLARGERTHAN:   node = new EqualOrLargerThanNode(); break;
            }
            ((BinaryExpressionNode) node).RightN = (ExpressionNode) visitAdd(ctx.a(ctx.a().size()-1).add());
            BinaryExpressionNode CurrentNode = (BinaryExpressionNode) node;
            for (int i = ctx.a().size() - 2; i >= 0; i--) {
                switch (ctx.a(i).op.getType()) {
                    case PUTINLexer.OP_EQUALS:              CurrentNode.LeftN = new EqualsNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                    case PUTINLexer.OP_NOTEQUALS:           CurrentNode.LeftN = new NotEqualsNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                    case PUTINLexer.OP_LESSTHAN:            CurrentNode.LeftN = new LessThanNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                    case PUTINLexer.OP_LARGERTHAN:          CurrentNode.LeftN = new LargerThanNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                    case PUTINLexer.OP_EQUALORLESSTHAN:     CurrentNode.LeftN = new EqualOrLessThanNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                    case PUTINLexer.OP_EQUALORLARGERTHAN:   CurrentNode.LeftN = new EqualOrLargerThanNode();
                                                            CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                            CurrentNode.RightN = (ExpressionNode) visitAdd(ctx.a(i).add());
                                                            break;
                }
            }
            CurrentNode.LeftN = (ExpressionNode) visitAdd(ctx.add());
            return node;
        }
        else{
            return visitAdd(ctx.add());
        }
    }

    @Override
    public PUTINNode visitAdd(PUTINParser.AddContext ctx) {
        ExpressionNode node = null;
        if (ctx.m().size() != 0){
            switch (ctx.m(ctx.m().size() - 1).op.getType()) {
                case PUTINLexer.OP_PLUS: node = new AddNode(); break;
                case PUTINLexer.OP_MINUS:  node = new SubtractNode(); break;
            }
            ((BinaryExpressionNode) node).RightN = (ExpressionNode) visitMult(ctx.m(ctx.m().size()-1).mult());
            BinaryExpressionNode CurrentNode = (BinaryExpressionNode) node;
            for (int i = ctx.m().size() - 2; i >= 0; i--) {
                switch (ctx.m(i).op.getType()) {
                    case PUTINLexer.OP_PLUS  :  CurrentNode.LeftN = new AddNode();
                                                CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                CurrentNode.RightN = (ExpressionNode) visitMult(ctx.m(i).mult());
                                                break;
                    case PUTINLexer.OP_MINUS :  CurrentNode.LeftN = new SubtractNode();
                                                CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                CurrentNode.RightN = (ExpressionNode) visitMult(ctx.m(i).mult());
                                                break;
                }
            }
            CurrentNode.LeftN = (ExpressionNode) visitMult(ctx.mult());
            return node;
        }
        else{
            return visitMult(ctx.mult());
        }
    }

    @Override
    public PUTINNode visitMult(PUTINParser.MultContext ctx) {
        ExpressionNode node = null;
        if (ctx.u().size() != 0){
            switch (ctx.u(ctx.u().size() - 1).op.getType()) {
                case PUTINLexer.OP_MULTIPLY: node = new multiplyNode(); break;
                case PUTINLexer.OP_DIVIDE:  node = new DivideNode(); break;
                case PUTINLexer.OP_MOD:  node = new ModNode(); break;
            }
            ((BinaryExpressionNode) node).RightN = (ExpressionNode) visitUnary(ctx.u(ctx.u().size()-1).unary());
            BinaryExpressionNode CurrentNode = (BinaryExpressionNode) node;
            for (int i = ctx.u().size() - 2; i >= 0; i--) {
                switch (ctx.u(i).op.getType()) {
                    case PUTINLexer.OP_MULTIPLY  :  CurrentNode.LeftN = new multiplyNode();
                                                    CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                    CurrentNode.RightN = (ExpressionNode) visitUnary(ctx.u(i).unary());
                                                    break;
                    case PUTINLexer.OP_DIVIDE :     CurrentNode.LeftN = new DivideNode();
                                                    CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                    CurrentNode.RightN = (ExpressionNode) visitUnary(ctx.u(i).unary());
                                                    break;
                    case PUTINLexer.OP_MOD :        CurrentNode.LeftN = new ModNode();
                                                    CurrentNode = (BinaryExpressionNode) CurrentNode.LeftN;
                                                    CurrentNode.RightN = (ExpressionNode) visitUnary(ctx.u(i).unary());
                                                    break;
                }
            }
            CurrentNode.LeftN = (ExpressionNode) visitUnary(ctx.unary());
            return node;
        }
        else{
            return visitUnary(ctx.unary());
        }
    }

    @Override
    public PUTINNode visitUnary(PUTINParser.UnaryContext ctx) {
        ExpressionNode node = null;
        if (ctx.n().size() > 0){
            int count = 0;
            for (PUTINParser.NContext N: ctx.n()) {
                if (N.op.getType() == PUTINLexer.OP_MINUS){
                    count++;
                }
            }
            if (count%2 == 1){
                node = new MinusNode();
                ((MinusNode) node).InnerN = (ExpressionNode) visitNegation(ctx.negation());
                return node;
            }
        }
        return visitNegation(ctx.negation());
    }

    @Override
    public PUTINNode visitNegation(PUTINParser.NegationContext ctx) {
        ExpressionNode node = null;
        if (ctx.t().size() > 0){
            if (ctx.t().size()%2 == 1){
                node = new NegationNode();
                ((NegationNode) node).InnerN = (ExpressionNode) visitTerm(ctx.term());
                return node;
            }
        }
        return visitTerm(ctx.term());
    }

    @Override
    public PUTINNode visitTerm(PUTINParser.TermContext ctx) {
        ExpressionNode node = null;
        if (ctx.value() != null){
            node = new ValueTermNode();
            ((ValueTermNode) node).ValueN = (ValueNode) visitValue(ctx.value());
        }
        else if (ctx.expression() != null){
            return visitExpression(ctx.expression());
        }
        return node;
    }

    @Override
    public PUTINNode visitElsif(PUTINParser.ElsifContext ctx) {
        ElsIfNode node = new ElsIfNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitEls(PUTINParser.ElsContext ctx) {
        ElsNode node = new ElsNode();
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitOption(PUTINParser.OptionContext ctx) {
        OptionNode node = new OptionNode();
        node.ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.expression()));
        for (PUTINParser.StmtContext S : ctx.stmt()) {
            node.StmtNA.add((StmtNode) visitStmt(S));
        }
        return node;
    }

    @Override
    public PUTINNode visitDef(PUTINParser.DefContext ctx) {
        DefNode node = new DefNode();

        return node;
    }

    @Override
    public PUTINNode visitCoordinate(PUTINParser.CoordinateContext ctx) {
        CoordinateNode node = new CoordinateNode();
        for (TerminalNode T : ctx.INT()) {
            NumberValueNode node1 = new NumberValueNode();
            node1.Value = Double.parseDouble(T.toString());
            node.NumberValueNA.add(node1);
        }
        return node;
    }

    @Override
    public PUTINNode visitValue(PUTINParser.ValueContext ctx) {
        ValueNode node = null;
        if(ctx.number() != null){
            node = new NumberValueNode();
            if (ctx.number().INT() != null){
                ((NumberValueNode) node).Value = Integer.parseInt(ctx.number().INT().toString());
            }
            else if (ctx.number().DOUBLE() != null){
                ((NumberValueNode) node).Value = Double.parseDouble(ctx.number().DOUBLE().toString());
            }
        }
        else if(ctx.TEXT() != null){
            node = new TextValueNode();
            ((TextValueNode) node).Value = ctx.TEXT().toString();
        }
        else if(ctx.BOOL() != null){
            node = new BoolValueNode();
            ((BoolValueNode) node).Value = Boolean.valueOf(ctx.BOOL().toString());
        }
        else if(ctx.coordinate() != null){
            node = new CoordinateValueNode();
            ((CoordinateValueNode) node).CoordinateN = (CoordinateNode) visitCoordinate(ctx.coordinate());
        }
        else if(ctx.singlemove() != null){
            node = new MoveValueNode();
            if (ctx.singlemove().DIRECTION().toString().equals("H") || ctx.singlemove().DIRECTION().toString().equals("Horizontal")){
                ((MoveValueNode)node).DirectionN = new HDirectionNode();
            }
            else if (ctx.singlemove().DIRECTION().toString().equals("V") || ctx.singlemove().DIRECTION().toString().equals("Vertical")){
                ((MoveValueNode)node).DirectionN = new VDirectionNode();
            }
            else{
                ((MoveValueNode)node).DirectionN = new RDirectionNode();
            }
            ((MoveValueNode)node).ExpressionN = ChooseEvaluator((ExpressionNode) visitExpression(ctx.singlemove().expression()));
        }
        if(ctx.stmtmethod() != null){
            node = new StmtMethodValueNode();
            for (PUTINParser.StmtmContext S : ctx.stmtmethod().stmtm()) {
                ((StmtMethodValueNode) node).StmtMethodNA.add((StmtMethodNode) visitStmtm(S));
            }
        }
        if(ctx.list() != null){
            node = new ListValueNode();
            for (PUTINParser.ValueContext V : ctx.list().value()) {
                ((ListValueNode) node).ValueNA.add((ValueNode) visitValue(V));
            }
        }
        return node;
    }

    @Override
    public PUTINNode visitNumber(PUTINParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    @Override
    public PUTINNode visitStmtmethod(PUTINParser.StmtmethodContext ctx) {
        return super.visitStmtmethod(ctx);
    }

    @Override
    public PUTINNode visitList(PUTINParser.ListContext ctx) {
        return super.visitList(ctx);
    }

    @Override
    public PUTINNode visitStmtm(PUTINParser.StmtmContext ctx) {
        StmtMethodNode node = null;
        if (ctx.stmtm1() != null){
            node = new StmtMethodNode1();
            for (TerminalNode I: ctx.stmtm1().ID()) {
                IdNode node1 = new IdNode();
                node1.Value = I.toString();
                ((StmtMethodNode1) node).IdNA.add(node1);
            }
            for (PUTINParser.ValueContext V: ctx.stmtm1().value()) {
                ((StmtMethodNode1) node).ValueNA.add((ValueNode) visitValue(V));
            }
        }
        else{
            node = new StmtMethodNode2();
            for (TerminalNode I: ctx.stmtm2().ID()) {
                IdNode node1 = new IdNode();
                node1.Value = I.toString();
                ((StmtMethodNode2) node).IdNA.add(node1);
            }
        }
        return node;
    }

    @Override
    public PUTINNode visitStmtm1(PUTINParser.Stmtm1Context ctx) {
        return super.visitStmtm1(ctx);
    }

    @Override
    public PUTINNode visitStmtm2(PUTINParser.Stmtm2Context ctx) {
        return super.visitStmtm2(ctx);
    }


    // Resten er muligvis ikke nødvendig at overskrive

    @Override
    public PUTINNode visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public PUTINNode visitChildren(RuleNode node) {
        return super.visitChildren(node);
    }

    @Override
    public PUTINNode visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public PUTINNode visitErrorNode(ErrorNode node) {
        return super.visitErrorNode(node);
    }

    @Override
    protected PUTINNode defaultResult() {
        return super.defaultResult();
    }

    @Override
    protected PUTINNode aggregateResult(PUTINNode aggregate, PUTINNode nextResult) {
        return super.aggregateResult(aggregate, nextResult);
    }

    @Override
    protected boolean shouldVisitNextChild(RuleNode node, PUTINNode currentResult) {
        return super.shouldVisitNextChild(node, currentResult);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public ExpressionNode ChooseEvaluator(ExpressionNode node){
        if (node instanceof AndNode || node instanceof OrNode ||
            node instanceof EqualsNode || node instanceof NotEqualsNode ||
            node instanceof LessThanNode || node instanceof LargerThanNode ||
            node instanceof EqualOrLessThanNode || node instanceof EqualOrLargerThanNode ||
            node instanceof NegationNode){
            return EvaluateBoolExpression(node).ExpressionN;
        }
        else if (node instanceof AddNode || node instanceof SubtractNode ||
                 node instanceof multiplyNode || node instanceof DivideNode ||
                 node instanceof ModNode || node instanceof MinusNode){
            return EvaluateNumberExpression(node).ExpressionN;
        }
        return node;
    }

    public Ret EvaluateBoolExpression(ExpressionNode node){
        Ret boolret = new Ret();
        Ret X = new Ret();
        Ret Y = new Ret();
        if (node instanceof AndNode) {
            X = EvaluateBoolExpression(((AndNode) node).LeftN);
            Y = EvaluateBoolExpression(((AndNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof BoolValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof BoolValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((BoolValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value && ((BoolValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                AndNode node1 = new AndNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof OrNode){
            X = EvaluateBoolExpression(((OrNode) node).LeftN);
            Y = EvaluateBoolExpression(((OrNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof BoolValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof BoolValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((BoolValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value || ((BoolValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                OrNode node1 = new OrNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof EqualsNode){
            ExpressionNode temp1 = ((EqualsNode) node).LeftN;
            ExpressionNode temp2 = ((EqualsNode) node).RightN;
            if (temp1 instanceof AndNode || temp1 instanceof OrNode ||
                temp1 instanceof EqualsNode || temp1 instanceof NotEqualsNode ||
                temp1 instanceof LessThanNode || temp1 instanceof LargerThanNode ||
                temp1 instanceof EqualOrLessThanNode || temp1 instanceof EqualOrLargerThanNode ||
                temp1 instanceof NegationNode || (temp1 instanceof ValueTermNode && ((ValueTermNode) temp1).ValueN instanceof BoolValueNode)){
                X = EvaluateBoolExpression(((EqualsNode) node).LeftN);
            }
            else {
                X = EvaluateNumberExpression(((EqualsNode) node).LeftN);
            }
            if (temp2 instanceof AndNode || temp2 instanceof OrNode ||
                temp2 instanceof EqualsNode || temp2 instanceof NotEqualsNode ||
                temp2 instanceof LessThanNode || temp2 instanceof LargerThanNode ||
                temp2 instanceof EqualOrLessThanNode || temp2 instanceof EqualOrLargerThanNode ||
                temp2 instanceof NegationNode || (temp2 instanceof ValueTermNode && ((ValueTermNode) temp2).ValueN instanceof BoolValueNode)){
                Y = EvaluateBoolExpression(((EqualsNode) node).RightN);
            }
            else {
                Y = EvaluateNumberExpression(((EqualsNode) node).RightN);
            }
            if (!X.containId && !Y.containId) {
                ValueTermNode node1 = new ValueTermNode();
                BoolValueNode node2 = new BoolValueNode();
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof BoolValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof BoolValueNode){
                    node2.Value = ((BoolValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value == ((BoolValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value == ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                EqualsNode node1 = new EqualsNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof NotEqualsNode){
            ExpressionNode temp1 = ((NotEqualsNode) node).LeftN;
            ExpressionNode temp2 = ((NotEqualsNode) node).RightN;
            if (temp1 instanceof AndNode || temp1 instanceof OrNode ||
                    temp1 instanceof EqualsNode || temp1 instanceof NotEqualsNode ||
                    temp1 instanceof LessThanNode || temp1 instanceof LargerThanNode ||
                    temp1 instanceof EqualOrLessThanNode || temp1 instanceof EqualOrLargerThanNode ||
                    temp1 instanceof NegationNode || (temp1 instanceof ValueTermNode && ((ValueTermNode) temp1).ValueN instanceof BoolValueNode)){
                X = EvaluateBoolExpression(((NotEqualsNode) node).LeftN);
            }
            else {
                X = EvaluateNumberExpression(((NotEqualsNode) node).LeftN);
            }
            if (temp2 instanceof AndNode || temp2 instanceof OrNode ||
                    temp2 instanceof EqualsNode || temp2 instanceof NotEqualsNode ||
                    temp2 instanceof LessThanNode || temp2 instanceof LargerThanNode ||
                    temp2 instanceof EqualOrLessThanNode || temp2 instanceof EqualOrLargerThanNode ||
                    temp2 instanceof NegationNode || (temp2 instanceof ValueTermNode && ((ValueTermNode) temp2).ValueN instanceof BoolValueNode)){
                Y = EvaluateBoolExpression(((NotEqualsNode) node).RightN);
            }
            else {
                Y = EvaluateNumberExpression(((NotEqualsNode) node).RightN);
            }
            if (!X.containId && !Y.containId) {
                ValueTermNode node1 = new ValueTermNode();
                BoolValueNode node2 = new BoolValueNode();
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof BoolValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof BoolValueNode){
                    node2.Value = ((BoolValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value != ((BoolValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value != ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                NotEqualsNode node1 = new NotEqualsNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof LessThanNode){
            X = EvaluateNumberExpression(((LessThanNode) node).LeftN);
            Y = EvaluateNumberExpression(((LessThanNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value < ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                LessThanNode node1 = new LessThanNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof LargerThanNode){
            X = EvaluateNumberExpression(((LargerThanNode) node).LeftN);
            Y = EvaluateNumberExpression(((LargerThanNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value > ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                LargerThanNode node1 = new LargerThanNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof EqualOrLessThanNode){
            X = EvaluateNumberExpression(((EqualOrLessThanNode) node).LeftN);
            Y = EvaluateNumberExpression(((EqualOrLessThanNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value <= ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                EqualOrLessThanNode node1 = new EqualOrLessThanNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof EqualOrLargerThanNode){
            X = EvaluateNumberExpression(((EqualOrLargerThanNode) node).LeftN);
            Y = EvaluateNumberExpression(((EqualOrLargerThanNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value >= ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                EqualOrLargerThanNode node1 = new EqualOrLargerThanNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof NegationNode){
            X = EvaluateBoolExpression(((NegationNode) node).InnerN);
            if (!X.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof BoolValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    BoolValueNode node2 = new BoolValueNode();
                    node2.Value = !((BoolValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    boolret.ExpressionN = node1;
                }
                else {
                    boolret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " is not a Boolean\n");
                }
            }
            else {
                NegationNode node1 = new NegationNode();
                node1.InnerN = X.ExpressionN;
                boolret.ExpressionN = node1;
                boolret.containId = true;
            }
        }
        else if (node instanceof ValueTermNode){
            if (((ValueTermNode) node).ValueN instanceof StmtMethodValueNode){
                boolret.ExpressionN = node;
                boolret.containId = true;
            }
            else {
                boolret.ExpressionN = node;
            }
        }
        return boolret;
    }

    public Ret EvaluateNumberExpression(ExpressionNode node){
        Ret numret = new Ret();
        Ret X = new Ret();
        Ret Y = new Ret();
        if (node instanceof AddNode){
            X = EvaluateNumberExpression(((AddNode) node).LeftN);
            Y = EvaluateNumberExpression(((AddNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    NumberValueNode node2 = new NumberValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value + ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    numret.ExpressionN = node1;
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                AddNode node1 = new AddNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof SubtractNode){
            X = EvaluateNumberExpression(((SubtractNode) node).LeftN);
            Y = EvaluateNumberExpression(((SubtractNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    NumberValueNode node2 = new NumberValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value - ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    numret.ExpressionN = node1;
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                SubtractNode node1 = new SubtractNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof multiplyNode){
            X = EvaluateNumberExpression(((multiplyNode) node).LeftN);
            Y = EvaluateNumberExpression(((multiplyNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    NumberValueNode node2 = new NumberValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value * ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    numret.ExpressionN = node1;
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                multiplyNode node1 = new multiplyNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof DivideNode){
            X = EvaluateNumberExpression(((DivideNode) node).LeftN);
            Y = EvaluateNumberExpression(((DivideNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    if (((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value != 0) {
                        ValueTermNode node1 = new ValueTermNode();
                        NumberValueNode node2 = new NumberValueNode();
                        node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value / ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                        node1.ValueN = node2;
                        numret.ExpressionN = node1;
                    }
                    else {
                        numret.ExpressionN = node;
                        ErrorLog.add("Can't divide by 0");
                    }
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                DivideNode node1 = new DivideNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof ModNode){
            X = EvaluateNumberExpression(((ModNode) node).LeftN);
            Y = EvaluateNumberExpression(((ModNode) node).RightN);
            if (!X.containId && !Y.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode && ((ValueTermNode) Y.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    NumberValueNode node2 = new NumberValueNode();
                    node2.Value = ((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value % ((NumberValueNode) ((ValueTermNode) Y.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    numret.ExpressionN = node1;
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " And " + ((ValueTermNode) Y.ExpressionN).ValueN.toString() + " don't match\n");
                }
            }
            else {
                ModNode node1 = new ModNode();
                node1.LeftN = X.ExpressionN;
                node1.RightN = Y.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof MinusNode){
            X = EvaluateBoolExpression(((MinusNode) node).InnerN);
            if (!X.containId) {
                if (((ValueTermNode) X.ExpressionN).ValueN instanceof NumberValueNode){
                    ValueTermNode node1 = new ValueTermNode();
                    NumberValueNode node2 = new NumberValueNode();
                    node2.Value = -((NumberValueNode) ((ValueTermNode) X.ExpressionN).ValueN).Value;
                    node1.ValueN = node2;
                    numret.ExpressionN = node1;
                }
                else {
                    numret.ExpressionN = node;
                    ErrorLog.add(((ValueTermNode) X.ExpressionN).ValueN.toString() + " is not a Boolean\n");
                }
            }
            else {
                MinusNode node1 = new MinusNode();
                node1.InnerN = X.ExpressionN;
                numret.ExpressionN = node1;
                numret.containId = true;
            }
        }
        else if (node instanceof ValueTermNode){
            if (((ValueTermNode) node).ValueN instanceof StmtMethodValueNode){
                numret.ExpressionN = node;
                numret.containId = true;
            }
            else {
                numret.ExpressionN = node;
            }
        }
        return numret;
    }
}