import com.sun.xml.internal.bind.v2.model.core.ID;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.net.IDN;
import java.util.ArrayList;

abstract class PUTINNode{

}

class ProgramNode extends PUTINNode{
    public BoardNode BoardN = new BoardNode();
    public PiecesNode PieceN = new PiecesNode();
    public SetupNode SetupN = new SetupNode();
    public RulesNode RulesN = new RulesNode();
    public WinConditionNode WinConditionN = new WinConditionNode();
    public ArrayList<MethodNode> methodNA = new ArrayList<MethodNode>();

    @Override
    public String toString() {
        String temp = "";
        for (MethodNode M:methodNA) {
            temp += M.toString();
        }
        return BoardN.toString() + PieceN.toString() + SetupN.toString() + RulesN.toString() + WinConditionN.toString() + temp;
    }
}

class BoardNode extends PUTINNode{
    public SizeNode SizeN = new SizeNode();
    public ArrayList<BoardParamNode> BoardParamNA = new ArrayList<BoardParamNode>();

    @Override
    public String toString() {
        String temp = "";
        for (BoardParamNode B:BoardParamNA) {
            temp += B.toString();
        }
        return "Board[\n" + SizeN.toString() + temp + "]\n";
    }
    public String toJava(){
        return ("");
    }

}

class PiecesNode extends PUTINNode{
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (StmtNode S:StmtNA) {
            temp += S.toString();
        }
        return "\nPieces[\n" + temp + "]\n";
    }
    public String toJava(){
        return ("");
    }
}

class SetupNode extends PUTINNode{
    public PlayersNode PlayersN = null;
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (StmtNode S:StmtNA) {
            temp += S.toString();
        }
        return "\nSetup[\n" + PlayersN.toString() + temp + "]\n";
    }
    public String toJava(){
        return ("");
    }
}

class RulesNode extends PUTINNode{
    public ArrayList<TurnNode> TurnNA = new ArrayList<TurnNode>();
    public TurnDistributionNode TurnDistributionN = new TurnDistributionNode();

    @Override
    public String toString() {
        String temp = "";
        for (TurnNode T:TurnNA) {
            temp += T.toString();
        }
        return "\nRules\n" + temp + TurnDistributionN.toString() + "]\n";
    }
    public String toJava(){
        return ("");
    }
}

class WinConditionNode extends PUTINNode{
    public ArrayList<WinCNDNode> WinCNDNA = new ArrayList<WinCNDNode>();

    @Override
    public String toString() {
        String temp = "";
        for (WinCNDNode W:WinCNDNA) {
            temp += W.toString();
        }
        return "\nWinconditions[\n" + temp + "]\n";
    }
    public String toJava(){
        return ("");
    }
}

class MethodNode extends PUTINNode{
    public ArrayList<TypeNode> TypeNA1 = new ArrayList<TypeNode>();
    public IdNode IdN = new IdNode();
    public ArrayList<TypeNode> TypeNA2 = new ArrayList<TypeNode>();
    public ArrayList<IdNode> IdNA = new ArrayList<IdNode>();
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();
    public ArrayList<ReturnStmtNode> ReturnStmtNA = new ArrayList<ReturnStmtNode>();

    @Override
    public String toString() {
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        String temp4 = "";
        for (TypeNode T:TypeNA1) {
            temp1 += T.toString() + " ";
        }
        for (int i = 0; i < TypeNA2.size(); i++){
            temp2 += TypeNA2.get(i).toString() + " ";
            temp2 += IdNA.get(i).toString();
            if (i != TypeNA2.size()-1){
                temp2 += ", ";
            }
        }
        for (StmtNode S:StmtNA) {
            temp3 += S.toString();
        }
        if (ReturnStmtNA.size() == 1){
            temp4 = ReturnStmtNA.get(0).toString();
        }
        return "\n" + temp1 + IdN.toString() + "(" + temp2 + "){\n" + temp3 + temp4 + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class SizeNode extends PUTINNode{
    public HeightNode HeightN = new HeightNode();
    public WidthNode WidthN = new WidthNode();

    @Override
    public String toString() {
        return HeightN.toString() + WidthN.toString();
    }
    public String toJava(){
        return ("");
    }
}

abstract class BoardParamNode extends PUTINNode{

}

abstract class StmtNode extends PUTINNode{

}

abstract class PlayersNode extends PUTINNode{

}

class PlayersNode1 extends PlayersNode{
    public NumberValueNode NumberValueN = new NumberValueNode();

    @Override
    public String toString() {
        return "Players = " + (int)NumberValueN.Value + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class PlayersNode2 extends PlayersNode{
    public ArrayList<IdNode> IdNA = new ArrayList<IdNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < IdNA.size(); i++){
            temp += IdNA.get(i).toString();
            if (i != IdNA.size()-1){
                temp += ", ";
            }
        }
        return "Players = (" + temp + ");\n";
    }
    public String toJava(){
        return ("");
    }
}

class TurnNode extends PUTINNode{
    public IdNode IdN = new IdNode();
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (StmtNode S:StmtNA) {
            temp += S.toString();
        }
        return "Turn " + IdN.toString() + "{\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class TurnDistributionNode extends PUTINNode{
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (StmtNode S:StmtNA) {
            temp += S.toString();
        }
        return "TurnDistribution " + "{\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

abstract class WinCNDNode extends PUTINNode{

}

class WinCNDNode1 extends WinCNDNode{
    public IfStmtNode IfStmtN = new IfStmtNode();

    @Override
    public String toString() {
        return IfStmtN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class WinCNDNode2 extends WinCNDNode{
    public OptionsStmtNode OptionsStmtN = new OptionsStmtNode();

    @Override
    public String toString() {
        return OptionsStmtN.toString();
    }
    public String toJava(){
        return ("");
    }
}

abstract class TypeNode extends PUTINNode{

}

class NumberTNode extends TypeNode{
    @Override
    public String toString() {
        return "Number";
    }
    public String toJava(){
        return ("");
    }
}

class TextTNode extends TypeNode{
    @Override
    public String toString() {
        return "Text";
    }
    public String toJava(){
        return ("");
    }
}

class BooleanTNode extends TypeNode{
    @Override
    public String toString() {
        return "Boolean";
    }
    public String toJava(){
        return ("");
    }
}

class PlayerTNode extends TypeNode{
    @Override
    public String toString() {
        return "Player";
    }
    public String toJava(){
        return ("");
    }
}

class PieceTNode extends TypeNode{
    @Override
    public String toString() {
        return "Piece";
    }
    public String toJava(){
        return ("");
    }
}

class ListTNode extends TypeNode{
    @Override
    public String toString() {
        return "List";
    }
    public String toJava(){
        return ("");
    }
}

class CoordinateTNode extends TypeNode{
    @Override
    public String toString() {
        return "Coordinate";
    }
    public String toJava(){
        return ("");
    }
}

class HeightNode extends PUTINNode{
    public NumberValueNode NumberValueN = new NumberValueNode();

    @Override
    public String toString() {
        return "Height = " + ((int)Double.parseDouble(NumberValueN.toString())) + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class WidthNode extends PUTINNode{
    public NumberValueNode NumberValueN = new NumberValueNode();

    @Override
    public String toString() {
        return "Width = " + ((int)Double.parseDouble(NumberValueN.toString())) + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class IlligalTilesNode extends BoardParamNode{
    public ArrayList<CoordinateNode> CoordinateNA = new ArrayList<CoordinateNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < CoordinateNA.size(); i++){
            temp += CoordinateNA.get(i).toString();
            if (i != CoordinateNA.size()-1){
                temp += ", ";
            }
        }
        return "IllegalTiles = (" + temp + ");\n" ;
    }
    public String toJava(){
        return ("");
    }
}

class SpecialTilesNode extends BoardParamNode{
    public IdNode IdN = new IdNode();
    public ArrayList<CoordinateNode> CoordinateNA = new ArrayList<CoordinateNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < CoordinateNA.size(); i++){
            temp += CoordinateNA.get(i).toString();
            if (i != CoordinateNA.size()-1){
                temp += ", ";
            }
        }
        return "SpecialTiles " + IdN.toString() + " = (" + temp + ");\n" ;
    }
    public String toJava(){
        return ("");
    }
}

abstract class AssignmentStmtNode extends StmtNode{

}

class AssignmentStmtNode1 extends AssignmentStmtNode{
    public TypeNode TypeN = null;
    public IdNode IdN = new IdNode();
    public PieceTypeNode PieceTypeN = new PieceTypeNode();

    @Override
    public String toString() {
        return TypeN.toString() + " " + IdN.toString() + " = " + PieceTypeN.toString() + "\n";
    }
    public String toJava(){
        return ("");
    }
}

class AssignmentStmtNode2 extends AssignmentStmtNode{
    public TypeNode TypeN = null;
    public IdNode IdN = new IdNode();
    public ExpressionNode ExpressionN = null;

    @Override
    public String toString() {
        return TypeN.toString() + " " + IdN.toString() + " = " + ExpressionN.toString() + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class AssignmentStmtNode3 extends AssignmentStmtNode{
    public ArrayList<IdNode> IdNA = new ArrayList<IdNode>();
    public ExpressionNode ExpressionN = null;

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < IdNA.size(); i++){
            temp += IdNA.get(i).toString();
            if (i != IdNA.size()-1){
                temp += ".";
            }
        }
        return temp + " = " + ExpressionN.toString() + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class IfStmtNode extends StmtNode{
    public ExpressionNode ExpressionN = null;
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();
    public ArrayList<ElsIfNode> ElsIfNA = new ArrayList<ElsIfNode>();
    public ArrayList<ElsNode> ElsNA = new ArrayList<ElsNode>();

    @Override
    public String toString() {
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp1 += StmtNA.get(i).toString();
        }
        for (int i = 0; i < ElsIfNA.size(); i++){
            temp2 += ElsIfNA.get(i).toString();
        }
        for (int i = 0; i < ElsNA.size(); i++){
            temp3 += ElsNA.get(i).toString();
        }
        return "If(" + ExpressionN.toString() + "){\n" + temp1 + "}\n" + temp2 + temp3;
    }
    public String toJava(){
        return ("");
    }
}

class RepeatWhileStmtNode extends StmtNode{
    public ExpressionNode ExpressionN = null;
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "RepeatWhile(" + ExpressionN.toString() + "){\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class RepeatStmtNode extends StmtNode{
    public NumberValueNode NumberValueN = new NumberValueNode();
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "Repeat(" + NumberValueN.toString() + "){\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class OptionsStmtNode extends StmtNode{
    public ExpressionNode ExpressionN = null;
    public ArrayList<OptionNode> OptionNA = new ArrayList<OptionNode>();
    public ArrayList<DefNode> DefNA = new ArrayList<DefNode>();

    @Override
    public String toString() {
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < OptionNA.size(); i++){
            temp1 += OptionNA.get(i).toString();
        }
        for (int i = 0; i < DefNA.size(); i++){
            temp2 += DefNA.get(i).toString();
        }
        return "Options(" + ExpressionN.toString() + "){\n" + temp1 + temp2 + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class ReturnStmtNode extends StmtNode{
    public ExpressionNode ExpressionN = null;

    @Override
    public String toString() {
        return "Return " + ExpressionN.toString() + ";\n";
    }
    public String toJava(){
        return ("");
    }
}

class ForeachStmtNode extends StmtNode{
    public TypeNode TypeN = null;
    public IdNode IdN = new IdNode();
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "ForEach(" + TypeN.toString() + " In " + IdN + "){\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class MethodCallNode extends StmtNode{
    public ArrayList<MCNode> MCNA = new ArrayList<MCNode>();
    public IdNode IdN = new IdNode();
    public ArrayList<ValueNode> ValueNA = new ArrayList<ValueNode>();

    @Override
    public String toString() {
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < MCNA.size(); i++){
            temp1 += MCNA.get(i).toString();
        }
        for (int i = 0; i < ValueNA.size(); i++){
            if (ValueNA.get(i) instanceof NumberValueNode){
                temp2 += (int) Double.parseDouble(ValueNA.get(i).toString());
            }
            else{
                temp2 += ValueNA.get(i).toString();
            }
            if (i != ValueNA.size()-1){
                temp2 += ", ";
            }
        }
        return temp1 + IdN.toString() + "(" + temp2 + ");\n";
    }
    public String toJava(){
        return ("");
    }
}

abstract class MCNode extends PUTINNode{

}

class MCNode1 extends MCNode{
    public IdNode IdN = new IdNode();

    @Override
    public String toString() {
        return IdN.toString() + ".";
    }
    public String toJava(){
        return ("");
    }
}

class MCNode2 extends MCNode{
    public IdNode IdN = new IdNode();
    public ArrayList<ValueNode> ValueNA = new ArrayList<ValueNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < ValueNA.size(); i++){
            temp += ValueNA.get(i).toString();
            if (i != ValueNA.size()-1){
                temp += ", ";
            }
        }
        return IdN.toString() + "(" + temp + ").";
    }
    public String toJava(){
        return ("");
    }
}

class PieceTypeNode extends PUTINNode{
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "{" + temp + "}";
    }
    public String toJava(){
        return ("");
    }
}

abstract class ExpressionNode extends PUTINNode{

}

abstract class BinaryExpressionNode extends ExpressionNode{
    public ExpressionNode LeftN = null;
    public ExpressionNode RightN = null;
}

class AndNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " And " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class OrNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " Or " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class EqualsNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " Equals " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class NotEqualsNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " NotEquals " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class LessThanNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " LessThan " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class LargerThanNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " LargerThan " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class EqualOrLessThanNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " EqualOrLessThan " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class EqualOrLargerThanNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " EqualOrLargerThan " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class AddNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " + " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class SubtractNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " - " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class multiplyNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " * " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class DivideNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " / " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class ModNode extends BinaryExpressionNode{
    @Override
    public String toString() {
        return LeftN.toString() + " Mod " + RightN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class MinusNode extends ExpressionNode{
    public ExpressionNode InnerN;

    @Override
    public String toString() {
        return "-" + InnerN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class NegationNode extends ExpressionNode{
    public ExpressionNode InnerN;

    @Override
    public String toString() {
        return "!" + InnerN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class ValueTermNode extends ExpressionNode{
    public ValueNode ValueN;

    @Override
    public String toString() {
        return ValueN.toString();
    }
    public String toJava(){
        return ("");
    }
}

class ElsIfNode extends PUTINNode{
    public ExpressionNode ExpressionN = null;
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "ElseIf(" + ExpressionN.toString() + "){\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class ElsNode extends PUTINNode{
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "Else{\n" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class OptionNode extends PUTINNode{
    public ExpressionNode ExpressionN = null;
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "Option " + ExpressionN.toString() + " : {" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class DefNode extends PUTINNode{
    public ArrayList<StmtNode> StmtNA = new ArrayList<StmtNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtNA.size(); i++){
            temp += StmtNA.get(i).toString();
        }
        return "Default : {" + temp + "}\n";
    }
    public String toJava(){
        return ("");
    }
}

class CoordinateNode extends PUTINNode{
    public ArrayList<NumberValueNode> NumberValueNA = new ArrayList<NumberValueNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < NumberValueNA.size(); i++){
            temp += NumberValueNA.get(i).toString();
            if (i != NumberValueNA.size()-1){
                temp += ", ";
            }
        }
        return "(" + temp + ")";
    }
    public String toJava(){
        return ("");
    }
}

abstract class ValueNode extends PUTINNode{
    public String toJava(){
        return ("");
    }
}

class NumberValueNode extends ValueNode{
    public double Value = 0.0;

    @Override
    public String toString() {
        return Double.toString(Value);
    }
    @Override
    public String toJava(){
        return ("Double");
    }
}

class TextValueNode extends ValueNode{
    public String Value = "";

    @Override
    public String toString() {
        return Value;
    }
    @Override
    public String toJava(){
        return ("String");
    }
}

class BoolValueNode extends ValueNode{
    public boolean Value = true;

    @Override
    public String toString() {
        if (Value)
            return "True";
        else
            return "False";
    }
    @Override
    public String toJava(){
        return ("Boolean");
    }
}

class CoordinateValueNode extends ValueNode{
    public CoordinateNode CoordinateN = new CoordinateNode();

    @Override
    public String toString() {
        return CoordinateN.toString();
    }
    @Override
    public String toJava(){
        return ("Coordinate");
    }
}

class MoveValueNode extends ValueNode{
    public DirectionNode DirectionN = null;
    public ExpressionNode ExpressionN = null;

    @Override
    public String toString() {
        return DirectionN.toString() + ExpressionN.toString();
    }
    @Override
    public String toJava(){
        return ("Move");
    }
}

class StmtMethodValueNode extends ValueNode{
    public ArrayList<StmtMethodNode> StmtMethodNA = new ArrayList<StmtMethodNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < StmtMethodNA.size(); i++){
            temp += StmtMethodNA.get(i).toString();
            if (i != StmtMethodNA.size()-1){
                temp += ".";
            }
        }
        return temp;
    }
    @Override
    public String toJava(){
        String temp = "";
        for (int i = 0; i < StmtMethodNA.size(); i++){
            temp += StmtMethodNA.get(i).toString();
            if (i != StmtMethodNA.size()-1){
                temp += ".";
            }
        }
        return (temp);
    }
}

class ListValueNode extends ValueNode{
    public ArrayList<ValueNode> ValueNA = new ArrayList<ValueNode>();

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < ValueNA.size(); i++){
            temp += ValueNA.get(i).toString();
            if (i != ValueNA.size()-1){
                temp += ", ";
            }
        }
        return "(" + temp + ")";
    }
    @Override
    public String toJava(){
        return ("List");
    }
}

abstract class StmtMethodNode extends PUTINNode{
    public ArrayList<IdNode> IdNA = new ArrayList<IdNode>();
}

class StmtMethodNode1 extends StmtMethodNode{
    public ArrayList<ValueNode> ValueNA = new ArrayList<ValueNode>();

    @Override
    public String toString() {
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < IdNA.size(); i++){
            temp1 += IdNA.get(i).toString();
            if (i != IdNA.size()-1){
                temp1 += ".";
            }
        }
        for (int i = 0; i < ValueNA.size(); i++){
            temp2 += ValueNA.get(i).toString();
            if (i != ValueNA.size()-1){
                temp2 += ", ";
            }
        }
        return temp1 + "(" + temp2 + ")";
    }
    public String toJava(){
        return ("");
    }
}

class StmtMethodNode2 extends StmtMethodNode{

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < IdNA.size(); i++){
            temp += IdNA.get(i).toString();
            if (i != IdNA.size()-1){
                temp += ".";
            }
        }
        return temp;
    }
    public String toJava(){
        return ("");
    }
}

abstract class DirectionNode extends PUTINNode{

}

class HDirectionNode extends DirectionNode{
    @Override
    public String toString() {
        return "H";
    }
    public String toJava(){
        return ("");
    }
}

class VDirectionNode extends DirectionNode{
    @Override
    public String toString() {
        return "V";
    }
    public String toJava(){
        return ("");
    }
}

class RDirectionNode extends DirectionNode{
    @Override
    public String toString() {
        return "R";
    }
    public String toJava(){
        return ("");
    }
}

class IdNode extends PUTINNode{
    public String Value = "";

    @Override
    public String toString() {
        return Value;
    }
    public String toJava(){
        return ("");
    }
}