//import com.sun.javafx.collections.ArrayListenerHelper;


import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Minus;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.net.IDN;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateCode implements VisitAST{
    public ArrayList<ArrayList<String>> results=new ArrayList<ArrayList<String>>();
    public HashMap<String, SymbolTableEntry> Symboltable;

    public ArrayList<ArrayList<String>> getThings(ProgramNode node, HashMap<String, SymbolTableEntry> Sym){
        results.add(new ArrayList<String>());
        results.add(new ArrayList<String>());
        Symboltable = Sym;
        visitProgram(node);
        return results;
    }

    @Override
    public void visitProgram(ProgramNode node) {
        results.get(0).add("//Board");
        visitBoard(node.BoardN);
        visitPieces(node.PieceN);
        results.get(0).add("//Setup");
        results.get(0).add("Board.setPlayerList(PlayerList);");
        visitSetup(node.SetupN);
        visitRules(node.RulesN);
        results.get(0).add("//WinCondition");
        visitWinCondition(node.WinConditionN);
        for (MethodNode M: node.methodNA) {
            visitMethod(M);
        }
    }

    @Override
    public void visitBoard(BoardNode node) {
        visitSize(node.SizeN);
        results.get(1).add("ArrayList<Coordinate> IllegalTiles = new ArrayList<Coordinate>();");
        for (BoardParamNode B : node.BoardParamNA) {
            visitBoardParam(B);
        }
    }
    @Override
    public void visitPieces(PiecesNode node) {
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, true)) {
                results.get(0).add(ST);
            }
        }
    }

    @Override
    public void visitSetup(SetupNode node) {
        visitPlayer(node.PlayersN);
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, true)) {
                results.get(0).add(ST);
            }
        }
    }

    @Override
    public void visitRules(RulesNode node) {
        for (TurnNode T : node.TurnNA) {
            visitTurn(T);
        }
        visitTurnDistribution(node.TurnDistributionN);
    }

    @Override
    public void visitWinCondition(WinConditionNode node) {
        ArrayList<String> Win = new ArrayList<String>();
        Win.add("public Boolean WinCondition(){");
        for (WinCNDNode W : node.WinCNDNA) {
            if (W instanceof WinCNDNode1){
                for (String ST : visitStmtCG(((WinCNDNode1) W).IfStmtN, false)) {
                    Win.add(ST);
                }
            }
            else if (W instanceof WinCNDNode2){
                for (String ST : visitStmtCG(((WinCNDNode2) W).OptionsStmtN, false)) {
                    Win.add(ST);
                }
            }
        }
        Win.add("return true;");
        Win.add("}");
        results.add(Win);
    }

    @Override
    public void visitMethod(MethodNode node) {
        ArrayList<String> Meth = new ArrayList<String>();
        String temp1 = "void";
        String temp2 = "";
        if (node.TypeNA1.size() == 1){
            temp1 = node.TypeNA1.get(0).toString();
        }
        for (int i = 0; i < node.TypeNA2.size(); i++){
            temp2 += node.TypeNA2.get(i).toString() + " ";
            temp2 += node.IdNA.get(i).toString();
            if (i < node.TypeNA2.size() - 1){
                temp2 += ", ";
            }
        }
        Meth.add("public " + temp1 + " " + node.IdN.toString() + "(" + temp2 + "){");
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, false)) {
                Meth.add(ST);
            }
        }
        for (ReturnStmtNode R : node.ReturnStmtNA) {
            Meth.add("return " + makeJavaExpression(R.ExpressionN) + ";");
        }
        Meth.add("}");
        results.add(Meth);
    }

    @Override
    public void visitSize(SizeNode node) {
        visitHeight(node.HeightN);
        visitWidth(node.WidthN);
    }

    @Override
    public void visitBoardParam(BoardParamNode node) {
        if (node instanceof IlligalTilesNode){
            for (CoordinateNode C : ((IlligalTilesNode) node).CoordinateNA) {
                results.get(0).add("IllegalTiles.add(new Coordinate(" + C.NumberValueNA.get(0).Value + ", " + C.NumberValueNA.get(1).Value + "));");
            }
        }
        else if (node instanceof SpecialTilesNode){
            results.get(1).add("ArrayList<Coordinate> " + ((SpecialTilesNode) node).IdN.toString() + " = new ArrayList<Coordinate>();");
            for (CoordinateNode C : ((SpecialTilesNode) node).CoordinateNA) {
                results.get(0).add(((SpecialTilesNode) node).IdN.toString() + ".add(new Coordinate(" + C.NumberValueNA.get(0).Value + ", " + C.NumberValueNA.get(1).Value + "));");
            }
        }
    }

    @Override
    public void visitStmt(StmtNode node) {
        // We use visitStmtCG
    }

    public ArrayList<String> visitStmtCG(StmtNode node, Boolean inMain) {
        ArrayList<String> tempResult = new ArrayList<String>();
        if (node instanceof AssignmentStmtNode1){
            results.get(1).add("ArrayList<Move> " + ((AssignmentStmtNode1) node).IdN.toString() + "Moves = new ArrayList<Move>();");
            for (StmtNode S : ((AssignmentStmtNode1) node).PieceTypeN.StmtNA) {
                for (String ST : visitStmtCG(S, !inMain)) {
                    results.get(0).add(((AssignmentStmtNode1) node).IdN.toString() + ST);
                }
            }
            ArrayList<String> Piece = new ArrayList<String>();
            Piece.add("public class " + ((AssignmentStmtNode1) node).IdN.toString() + " extends Piece {");
            Piece.add("    @Override");
            Piece.add("    public Boolean MoveTo(Coordinate input){");
            Piece.add("        if (!PieceCheckOne(input)){");
            Piece.add("            return false;");
            Piece.add("        }");
            Piece.add("        if (!PieceCheckTwo(input, Coord, MoveList)){");
            Piece.add("            return false;");
            Piece.add("        }");
            Piece.add("        Coord = input;");
            Piece.add("        return true;");
            Piece.add("    }");
            Piece.add("");
            Piece.add("    @Override");
            Piece.add("    public Boolean CanMoveTo(Coordinate input){");
            Piece.add("        if (!PieceCheckOne(input)){");
            Piece.add("            return false;");
            Piece.add("        }");
            Piece.add("        if (!PieceCheckTwo(input, Coord, MoveList)){");
            Piece.add("            return false;");
            Piece.add("        }");
            Piece.add("        return true;");
            Piece.add("    }");
            Piece.add("");
            Piece.add("    @Override");
            Piece.add("    public Boolean PlaceAt(Coordinate input){");
            Piece.add("        if (!PieceCheckOne(input)){");
            Piece.add("            return false;");
            Piece.add("        }");
            Piece.add("        Coord = input;");
            Piece.add("        return true;");
            Piece.add("    }");
            Piece.add("}");

            results.add(Piece);
        }
        else if (node instanceof AssignmentStmtNode2){
            if (((AssignmentStmtNode2) node).ExpressionN instanceof ValueTermNode && ((ValueTermNode) ((AssignmentStmtNode2) node).ExpressionN).ValueN instanceof ListValueNode){
                String temp = "";
                if (((ListValueNode) ((ValueTermNode) ((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.get(0) instanceof StmtMethodValueNode){
                    temp = Symboltable.get(((ListValueNode) ((ValueTermNode) ((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.get(0).toString()).type.toString();
                }
                else {
                    temp = ((ListValueNode) ((ValueTermNode) ((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.get(0).toJava();
                }
                if (!inMain){
                    tempResult.add("ArrayList<" + temp + "> " + ((AssignmentStmtNode2) node).IdN.toString() + " = new ArrayList<" + temp + ">();");
                }
                else {
                    results.get(1).add("ArrayList<" + temp + "> " + ((AssignmentStmtNode2) node).IdN.toString() + " = new ArrayList<" + temp + ">();");
                }
                for (int i = 0; i < ((ListValueNode) ((ValueTermNode)((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.size(); i++) {
                    if (!inMain){
                        tempResult.add(((AssignmentStmtNode2) node).IdN.toString() + ".add(" + ((ListValueNode) ((ValueTermNode)((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.get(i).toString() + ");");
                    }
                    else {
                        results.get(1).add(((AssignmentStmtNode2) node).IdN.toString() + ".add(" + ((ListValueNode) ((ValueTermNode)((AssignmentStmtNode2) node).ExpressionN).ValueN).ValueNA.get(i).toString() + ");");
                    }
                }
            }
            else {
                if (((AssignmentStmtNode2) node).TypeN instanceof PieceTNode){
                    if (!inMain){
                        tempResult.add(((AssignmentStmtNode2) node).ExpressionN.toString() + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = new " + ((AssignmentStmtNode2) node).ExpressionN.toString() + "();");
                        tempResult.add(((AssignmentStmtNode2) node).IdN.toString() + ".MoveList = " + ((AssignmentStmtNode2) node).ExpressionN.toString() + "Moves;");
                    }
                    else {
                        results.get(1).add(((AssignmentStmtNode2) node).ExpressionN.toString() + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = new " + ((AssignmentStmtNode2) node).ExpressionN.toString() + "();");
                        tempResult.add(((AssignmentStmtNode2) node).IdN.toString() + ".MoveList = " + ((AssignmentStmtNode2) node).ExpressionN.toString() + "Moves;");
                    }
                }
                else if (((AssignmentStmtNode2) node).TypeN instanceof CoordinateTNode && ((AssignmentStmtNode2) node).ExpressionN.toString().equals("Input(\"Number\")")){
                    if (!inMain){
                        tempResult.add(((AssignmentStmtNode2) node).TypeN.toString() + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = new Coordinate(Double.parseDouble(Input(\"Number\")), Double.parseDouble(Input(\"Number\")));");
                    }
                    else {
                        results.get(1).add(((AssignmentStmtNode2) node).TypeN.toString() + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = new Coordinate(Double.parseDouble(Input(\"Number\")), Double.parseDouble(Input(\"Number\")));");
                    }
                }
                else {
                    String temp = "";
                    if (((AssignmentStmtNode2) node).TypeN.toString().equals("Number")){
                        temp = "Double";
                    }
                    else if (((AssignmentStmtNode2) node).TypeN.toString().equals("Text")){
                        temp = "String";
                    }
                    else {
                        temp = ((AssignmentStmtNode2) node).TypeN.toString();
                    }
                    if (!inMain){
                        tempResult.add(temp + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = " + makeJavaExpression(((AssignmentStmtNode2) node).ExpressionN) + ";");
                    }
                    else {
                        results.get(1).add(temp + " " + ((AssignmentStmtNode2) node).IdN.toString() + " = " + makeJavaExpression(((AssignmentStmtNode2) node).ExpressionN) + ";");
                    }
                }
            }
        }
        else if (node instanceof AssignmentStmtNode3){
            Boolean GoFurther = false;
            if (((AssignmentStmtNode3) node).ExpressionN instanceof ValueTermNode && ((ValueTermNode) ((AssignmentStmtNode3) node).ExpressionN).ValueN instanceof ListValueNode){
                String HFirst = "";
                String VFirst = "";
                for (ValueNode  V1 : ((ListValueNode) ((ValueTermNode) ((AssignmentStmtNode3) node).ExpressionN).ValueN).ValueNA) {
                    if (V1 instanceof MoveValueNode){
                        if (((MoveValueNode) V1).DirectionN instanceof RDirectionNode){
                            tempResult.add("Moves.add(new Move" + ((MoveValueNode) V1).ExpressionN.toString() + ");");
                        }
                        else {
                            if (((MoveValueNode) V1).DirectionN instanceof HDirectionNode){
                                HFirst = ((MoveValueNode) V1).ExpressionN.toString().replaceAll("\\(", "").replaceAll("\\)", "");
                            }
                            if (((MoveValueNode) V1).DirectionN instanceof VDirectionNode){
                                VFirst = ((MoveValueNode) V1).ExpressionN.toString().replaceAll("\\(", "").replaceAll("\\)", "");
                            }
                        }
                    }
                    else if (V1 instanceof ListValueNode){
                        String HSecond = "";
                        String VSecond = "";
                        for (ValueNode V2 : ((ListValueNode) V1).ValueNA) {
                            if (V2 instanceof MoveValueNode){
                                if (((MoveValueNode) V2).DirectionN instanceof RDirectionNode){
                                    tempResult.add("Moves.add(new Move" + ((MoveValueNode) V2).ExpressionN.toString() + ");");
                                }
                                else {
                                    if (((MoveValueNode) V2).DirectionN instanceof HDirectionNode){
                                        HSecond = ((MoveValueNode) V2).ExpressionN.toString().replaceAll("\\(", "").replaceAll("\\)", "");
                                    }
                                    if (((MoveValueNode) V2).DirectionN instanceof VDirectionNode){
                                        VSecond = ((MoveValueNode) V2).ExpressionN.toString().replaceAll("\\(", "").replaceAll("\\)", "");
                                    }
                                }
                            }
                            else {
                                GoFurther = true;
                            }
                        }
                        if (!GoFurther){
                            if (!HSecond.equals("") && !VSecond.equals("")){
                                tempResult.add("Moves.add(new Move(" + HSecond + ", " + VSecond + "));");
                            }
                            else if (!HSecond.equals("")){
                                tempResult.add("Moves.add(new Move(" + HSecond + ", 0.0, 0.0));");
                            }
                            else if (!VSecond.equals("")){
                                tempResult.add("Moves.add(new Move(0,0, 0,0, " + VSecond + "));");
                            }
                        }
                    }
                    else {
                        GoFurther = true;
                    }
                }
                if (!GoFurther){
                    if (!HFirst.equals("") && !VFirst.equals("")){
                        tempResult.add("Moves.add(new Move(" + HFirst + ", " + VFirst + "));");
                    }
                    else if (!HFirst.equals("")){
                        tempResult.add("Moves.add(new Move(" + HFirst + ", 0.0, 0.0));");
                    }
                    else if (!VFirst.equals("")){
                        tempResult.add("Moves.add(new Move(0,0, 0,0, " + VFirst + "));");
                    }
                }
            }
            else {
                GoFurther = true;
            }
            if (GoFurther){
                if (((AssignmentStmtNode3) node).IdNA.get(((AssignmentStmtNode3) node).IdNA.size() - 1).toString().equals("CurrentTurn")){
                    tempResult.add(makeJavaExpression(((AssignmentStmtNode3) node).ExpressionN) + "(" + ((AssignmentStmtNode3) node).IdNA.get(((AssignmentStmtNode3) node).IdNA.size() - 2).toString().replaceAll("PlayerAll", "P") + ");");
                }
                else {
                    String temp = "";
                    for (int i = 0; i < ((AssignmentStmtNode3) node).IdNA.size(); i++){
                        temp += ((AssignmentStmtNode3) node).IdNA.get(i).toString();
                        if (i < ((AssignmentStmtNode3) node).IdNA.size() - 1){
                            temp += ".";
                        }
                    }
                    temp = temp.replaceAll("PlayerAll\\.", "P.");
                    if (((AssignmentStmtNode3) node).ExpressionN instanceof ValueTermNode && ((ValueTermNode) ((AssignmentStmtNode3) node).ExpressionN).ValueN instanceof ListValueNode){
                        for (int i = 0; i < ((ListValueNode) ((ValueTermNode)((AssignmentStmtNode3) node).ExpressionN).ValueN).ValueNA.size(); i++) {
                            tempResult.add(temp + ".add(" + ((ListValueNode) ((ValueTermNode)((AssignmentStmtNode3) node).ExpressionN).ValueN).ValueNA.get(i).toString() + ");");
                        }
                    }
                    else if (((AssignmentStmtNode3) node).ExpressionN.toString().equals("Input(\"Number\")")){
                        Boolean Contain = false;
                        for (SymbolTableEntry E1 : Symboltable.values()) {
                            if (E1.type == SymbolTableEntry.Type.Turn){
                                if (E1.SymbolTable.containsKey(temp) && E1.SymbolTable.get(temp).type == SymbolTableEntry.Type.Coordinate){
                                    Contain = true;
                                }
                            }
                        }
                        if (Contain){
                            tempResult.add(temp + " = new Coordinate(Double.parseDouble(Input(\"Number\")), Double.parseDouble(Input(\"Number\")));");
                        }
                        else {
                            tempResult.add(temp + " = " + makeJavaExpression(((AssignmentStmtNode3) node).ExpressionN) + ";");
                        }
                    }
                    else {
                        tempResult.add(temp + " = " + makeJavaExpression(((AssignmentStmtNode3) node).ExpressionN) + ";");
                    }
                }
            }
        }
        else if (node instanceof IfStmtNode){
            tempResult.add("if (" + makeJavaExpression(((IfStmtNode) node).ExpressionN) + "){");
            for (StmtNode S : ((IfStmtNode) node).StmtNA) {
                for (String ST : visitStmtCG(S, inMain)) {
                    tempResult.add(ST);
                }
            }
            tempResult.add("}");
            for (ElsIfNode EI : ((IfStmtNode) node).ElsIfNA) {
                tempResult.add("else if (" + makeJavaExpression(EI.ExpressionN) + "){");
                for (StmtNode S : EI.StmtNA) {
                    for (String ST : visitStmtCG(S, inMain)) {
                        tempResult.add(ST);
                    }
                }
                tempResult.add("}");
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
        else if (node instanceof RepeatWhileStmtNode){
            tempResult.add("while (" + makeJavaExpression(((RepeatWhileStmtNode) node).ExpressionN) + "){");
            for (StmtNode S : ((RepeatWhileStmtNode) node).StmtNA) {
                for (String ST : visitStmtCG(S, inMain)) {
                    tempResult.add(ST);
                }
            }
            tempResult.add("}");
        }
        else if (node instanceof RepeatStmtNode){
            tempResult.add("for (int i = 0; i < " + ((RepeatStmtNode) node).NumberValueN + "; i++){");
            for (StmtNode S : ((RepeatStmtNode) node).StmtNA) {
                for (String ST : visitStmtCG(S, inMain)) {
                    tempResult.add(ST);
                }
            }
            tempResult.add("}");
        }
        else if (node instanceof OptionsStmtNode){
            tempResult.add("switch (String.valueOf(" + makeJavaExpression(((OptionsStmtNode) node).ExpressionN) + ")){");
            for (OptionNode O : ((OptionsStmtNode) node).OptionNA) {
                tempResult.add("case \"" + O.ExpressionN.toString() + "\" : " + visitStmtCG(O.StmtNA.get(0), inMain).get(0));
                for (int i = 1; i < visitStmtCG(O.StmtNA.get(0), inMain).size(); i++){
                    tempResult.add(visitStmtCG(O.StmtNA.get(0), inMain).get(i));
                }
                for (int i = 1; i < O.StmtNA.size(); i++) {
                    for (String ST : visitStmtCG(O.StmtNA.get(i), inMain)) {
                        tempResult.add(ST);
                    }
                }
                tempResult.add("break;");
            }
            for (DefNode D : ((OptionsStmtNode) node).DefNA) {
                tempResult.add("default : " + visitStmtCG(D.StmtNA.get(0), inMain));
                tempResult.add("break;");
            }
            tempResult.add("}");
        }
        else if (node instanceof ForeachStmtNode){
            String temp = "";
            if (((ForeachStmtNode) node).IdN.toString().equals("PlayerPieceList")){
                temp = "P.PieceList";
            }
            else {
                temp = ((ForeachStmtNode) node).IdN.toString();
            }
            tempResult.add("for (" + ((ForeachStmtNode) node).TypeN + " subPart : " + temp + "){");
            for (StmtNode S : ((ForeachStmtNode) node).StmtNA) {
                for (String ST : visitStmtCG(S, inMain)) {
                    tempResult.add(ST);
                }
            }
            tempResult.add("}");
        }
        else if (node instanceof MethodCallNode){
            String temp1 = "";
            String temp2 = "";
            String temp3 = "";
            for (int i = 0; i < ((MethodCallNode) node).MCNA.size(); i++){
                if (((MethodCallNode) node).MCNA.get(i).toString().equals("PlayerAll.")){
                    temp1 += "P.";
                }
                else if (((MethodCallNode) node).MCNA.get(i).toString().equals("ThisBoard.")){
                    temp1 += "Board.";
                }
                else {
                    temp1 += ((MethodCallNode) node).MCNA.get(i).toString();
                    String temp4 = temp1.replaceAll(".*Piece", "").replaceAll("\\.", "");
                    try{
                        temp4 = Integer.toString(Integer.parseInt(temp4) - 1);
                    }
                    catch (NumberFormatException e){

                    }
                    temp1 = temp1.replaceAll("Piece[0-9]+", "PieceList.get(" + temp4 + ")");
                }
            }
            if (((MethodCallNode) node).IdN.toString().equals("Add")){
                temp2 = "add";
            }
            else {
                temp2 = ((MethodCallNode) node).IdN.toString();
            }
            if (((MethodCallNode) node).IdN.toString().equals("Remove")){
                if (temp1.replaceAll("\\.Tiles\\(.*\\)\\.PieceList\\.get\\(.*\\).", ".Tiles").equals("Board.Tiles")){
                    tempResult.add("for (Piece TilePiece : " + temp1.replaceAll("\\.PieceList\\.get\\(.*\\)\\.", "") + "){");
                    tempResult.add("TilePiece.Coord = new Coordinate(0.0, 0.0);");
                    tempResult.add("}");
                }
                else {
                    tempResult.add(temp1.replaceAll("\\.$", "") + ".Coord = new Coordinate(0.0, 0.0);");
                }
            }
            else {
                for (int i = 0; i < ((MethodCallNode) node).ValueNA.size(); i++){
                    if (((MethodCallNode) node).ValueNA.get(i) instanceof CoordinateValueNode){
                        temp3 = "new Coordinate(" + ((CoordinateValueNode) ((MethodCallNode) node).ValueNA.get(i)).CoordinateN.NumberValueNA.get(0).Value + ", " + ((CoordinateValueNode) ((MethodCallNode) node).ValueNA.get(i)).CoordinateN.NumberValueNA.get(1).Value  + ")";
                    }
                    else {
                        temp3 += ((MethodCallNode) node).ValueNA.get(i).toString();
                        String temp4 = temp3.replaceAll(".*Piece", "");
                        try{
                            temp4 = Integer.toString(Integer.parseInt(temp4) - 1);
                        }
                        catch (NumberFormatException e){

                        }
                        temp3 = temp3.replaceAll("Piece[0-9]+", "P.PieceList.get(" + temp4 + ")");
                    }
                    if (i < ((MethodCallNode) node).ValueNA.size() - 1){
                        temp3 += ", ";
                    }
                }
                if (temp1.replaceAll(".*\\.PlayerList\\.", "PlayerList").equals("PlayerList")){
                    tempResult.add(temp1 + temp2 + "(\"" + temp3 + "\");");
                }
                else {
                    tempResult.add(temp1 + temp2 + "(" + temp3 + ");");
                }
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
            if (((ValueTermNode) node).ValueN instanceof CoordinateValueNode){
                Expression = "new Coordinate(" + ((CoordinateValueNode) ((ValueTermNode) node).ValueN).CoordinateN.NumberValueNA.get(0).Value + ", " + ((CoordinateValueNode) ((ValueTermNode) node).ValueN).CoordinateN.NumberValueNA.get(1).Value + ")";
            }
            else if (((ValueTermNode) node).ValueN instanceof MoveValueNode){

            }
            else if (((ValueTermNode) node).ValueN instanceof StmtMethodValueNode){
                String temp = "";
                Expression = ((ValueTermNode) node).ValueN.toString();
                Expression = Expression.replaceAll("PlayerAll\\.", "P.");
                Expression = Expression.replaceAll("ThisBoard\\.", "Board.");
                Expression = Expression.replaceAll("\\.Count$", "\\.size()");
                ArrayList<StmtMethodNode> SMNA = ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA;
                if (SMNA.size() > 1 && SMNA.get(SMNA.size() - 1).IdNA.get(0).toString().equals("Contains")){
                    String temp1 = ((ValueTermNode) node).ValueN.toString().replaceAll(".Contains\\(.*\\)", "");
                    String temp2 = ((StmtMethodNode1) SMNA.get(SMNA.size() - 1)).ValueNA.get(0).toString();
                    Expression = "Contains(" + temp1 + ", new " + temp2 + "())";
                }
                if (SMNA.size() > 1 && SMNA.get(SMNA.size() - 1).IdNA.get(0).toString().equals("Is")){
                    String temp1 = ((StmtMethodNode1) SMNA.get(SMNA.size() - 1)).ValueNA.get(0).toString();
                    String temp2 = ((StmtMethodNode1) SMNA.get(SMNA.size() - 2)).ValueNA.get(0).toString();
                    Expression = temp1 + ".contains(" + temp2 + ")";
                }
                Expression = Expression.replaceAll("Input\\(\"Number\"\\)", "Double.parseDouble(Input(\\\"Number\\\"))");
                temp = Expression.replaceAll(".*Piece", "").replaceAll("\\..*", "");
                try{
                    temp = Integer.toString(Integer.parseInt(temp) - 1);
                }
                catch (NumberFormatException e){

                }
                Expression = Expression.replaceAll("Piece[0-9]+\\.", "PieceList.get(" + temp + ").");
            }
            else if (((ValueTermNode) node).ValueN instanceof ListValueNode){

            }
            else {
                Expression = ((ValueTermNode) node).ValueN.toString();
            }
        }
        return Expression;
    }

    @Override
    public void visitPlayer(PlayersNode node) {
        if (node instanceof PlayersNode1){
            for (int i = 1; i <= ((PlayersNode1) node).NumberValueN.Value; i++){
                results.get(1).add("Player Player" + i + " = new Player();");
                results.get(0).add("PlayerList.add(Player" + i + ");");
                results.get(0).add("Player" + i + ".Name = \"Player" + i + "\";");
            }
        }
        else if (node instanceof PlayersNode2){
            for (IdNode I : ((PlayersNode2) node).IdNA) {
                results.get(1).add("Player " + I.toString() + " = new Player();");
                results.get(0).add("PlayerList.add(" + I.toString() + ");");
                results.get(0).add(I.toString() + ".Name = \"" + I.toString() + "\";");
            }
        }
    }

    @Override
    public void visitTurn(TurnNode node) {
        ArrayList<String> turn = new ArrayList<String>();
        turn.add("public void " + node.IdN.toString() + "(Player P){");
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, false)) {
                turn.add(ST);
            }
        }
        turn.add("}");
        results.add(turn);
    }

    @Override
    public void visitTurnDistribution(TurnDistributionNode node) {
        ArrayList<String> turn = new ArrayList<String>();
        turn.add("public void TurnDistribution(){");
        for (StmtNode S : node.StmtNA) {
            for (String ST : visitStmtCG(S, false)) {
                turn.add(ST);
            }
            turn.add("PrintBoard();");
        }
        turn.add("}");
        results.add(turn);
    }

    @Override
    public void visitWinCND(WinCNDNode node) {

    }

    @Override
    public void visitHeight(HeightNode node) {
        Double d =  node.NumberValueN.Value;
        results.get(0).add("Board.Height = " + Integer.toString(d.intValue()) + ";");
    }

    @Override
    public void visitWidth(WidthNode node) {
        Double d =  node.NumberValueN.Value;
        results.get(0).add("Board.Width = " + Integer.toString(d.intValue()) + ";");
    }
}
