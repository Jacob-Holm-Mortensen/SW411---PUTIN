//import com.sun.javafx.collections.ArrayListenerHelper;


import java.util.ArrayList;
import java.util.HashMap;

public class GenerateJVM implements VisitAST{
    public ArrayList<String> results=new ArrayList<String>();
    public HashMap<String, SymbolTableEntry> Symboltable;

    public ArrayList<String> getThings(ProgramNode node, HashMap<String, SymbolTableEntry> Sym){
        Symboltable = Sym;
        visitProgram(node);
        return results;
    }

    @Override
    public void visitProgram(ProgramNode node) {
        visitSetup(node.SetupN);
    }

    @Override
    public void visitSetup(SetupNode node) {
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, true)) {
                results.add(ST);
            }
        }
    }

    public ArrayList<String> visitStmtCG(StmtNode node, Boolean inMain) {
        ArrayList<String> tempResult = new ArrayList<String>();
        if (node instanceof AssignmentStmtNode2){
            String temp = "";
            if (((AssignmentStmtNode2) node).TypeN.toString().equals("Number")){
                temp = "Double";
            }
            tempResult.add(temp + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = " + makeJavaExpression(((AssignmentStmtNode2) node).ExpressionN) + ";");
        }
        else if (node instanceof AssignmentStmtNode3){
            tempResult.add(((AssignmentStmtNode3) node).IdNA.get(0).toString() + " = " + makeJavaExpression(((AssignmentStmtNode3) node).ExpressionN) + ";");
        }
        else if (node instanceof IfStmtNode){
            tempResult.add("if (" + makeJavaExpression(((IfStmtNode) node).ExpressionN) + "){");
            for (StmtNode S : ((IfStmtNode) node).StmtNA) {
                for (String ST : visitStmtCG(S, inMain)) {
                    tempResult.add(ST);
                }
            }
            for (ElsNode E : ((IfStmtNode) node).ElsNA) {
                tempResult.add("else {");
                for (StmtNode S : E.StmtNA) {
                    for (String ST : visitStmtCG(S, inMain)) {
                        tempResult.add(ST);
                    }
                }
                tempResult.add("}");
            }
        }
        return tempResult;
    }

    public String makeJavaExpression(ExpressionNode node){
        String Expression = "";
        if (node instanceof AndNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " && " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof OrNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " || " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof EqualsNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " == " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof NotEqualsNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " != " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof LessThanNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " < " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof LargerThanNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " > " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof EqualOrLessThanNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " <= " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof EqualOrLargerThanNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " >= " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof AddNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " + " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof SubtractNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " - " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof multiplyNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " * " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof DivideNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " / " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof ModNode){
            Expression = "(" + makeJavaExpression(((BinaryExpressionNode) node).LeftN) + " % " + makeJavaExpression(((BinaryExpressionNode) node).RightN) + ")";
        }
        else if (node instanceof MinusNode){
            Expression = "(-" + makeJavaExpression(((MinusNode) node).InnerN) + ")";
        }
        else if (node instanceof NegationNode){
            Expression = "(!" + makeJavaExpression(((NegationNode) node).InnerN) + ")";
        }
        else if (node instanceof ValueTermNode){
            Expression = ((ValueTermNode) node).ValueN.toString();
        }
        return Expression;
    }

    @Override
    public void visitBoard(BoardNode node) {
    }

    @Override
    public void visitPieces(PiecesNode node) {
    }

    @Override
    public void visitRules(RulesNode node) {
    }

    @Override
    public void visitWinCondition(WinConditionNode node) {
    }

    @Override
    public void visitMethod(MethodNode node) {
    }

    @Override
    public void visitSize(SizeNode node) {
    }

    @Override
    public void visitBoardParam(BoardParamNode node) {
    }

    @Override
    public void visitStmt(StmtNode node) {
    }

    @Override
    public void visitPlayer(PlayersNode node) {
    }

    @Override
    public void visitTurn(TurnNode node) {
    }

    @Override
    public void visitTurnDistribution(TurnDistributionNode node) {
    }

    @Override
    public void visitWinCND(WinCNDNode node) {
    }

    @Override
    public void visitHeight(HeightNode node) {
    }

    @Override
    public void visitWidth(WidthNode node) {
    }
}
