import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Div;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;
import jdk.nashorn.internal.ir.UnaryNode;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.MissingResourceException;

public class BuildSymbolTable implements VisitAST{
    HashMap<String, SymbolTableEntry> SymbolTable = new HashMap<String, SymbolTableEntry>();
    ArrayList<String> ErrorLog = new ArrayList<String>();

    public ArrayList<String> getErrorLog(){
        return ErrorLog;
    }

    public HashMap<String, SymbolTableEntry> ReturnSymbolTable(PUTINNode AST){
        SymbolTableEntry entry = new SymbolTableEntry();

        SymbolTableEntry entry1 = new SymbolTableEntry();
        entry1.ID = "Height";
        entry1.type = SymbolTableEntry.Type.Number;
        SymbolTable.put(entry1.ID, entry1);

        SymbolTableEntry entry2 = new SymbolTableEntry();
        entry2.ID = "Width";
        entry2.type = SymbolTableEntry.Type.Number;
        SymbolTable.put(entry2.ID, entry2);

        SymbolTableEntry entry3 = new SymbolTableEntry();
        entry3.ID = "IllegalTiles";
        entry3.type = SymbolTableEntry.Type.SpecialTiles;
        SymbolTable.put(entry3.ID, entry3);

        SymbolTableEntry entry4 = new SymbolTableEntry();
        entry4.ID = "ThisBoard";
        entry4.type = SymbolTableEntry.Type.Board;
        SymbolTable.put(entry4.ID, entry4);

        SymbolTableEntry entry5 = new SymbolTableEntry();
        entry5.ID = "ThisBoard.Tiles()";
        entry5.type = SymbolTableEntry.Type.Coordinate;

        SymbolTableEntry entry51 = new SymbolTableEntry();
        entry51.type = SymbolTableEntry.Type.Coordinate;
        entry51.ID = "Coordinate";
        entry5.inputs.add(entry51);

        SymbolTable.put(entry5.ID, entry5);

        SymbolTableEntry entry6 = new SymbolTableEntry();
        entry6.ID = "ThisBoard.Tiles().Is()";
        entry6.type = SymbolTableEntry.Type.Boolean;

        SymbolTableEntry entry61 = new SymbolTableEntry();
        entry61.type = SymbolTableEntry.Type.SpecialTiles;
        entry61.ID = "SpecialTiles";
        entry6.inputs.add(entry61);

        SymbolTable.put(entry6.ID, entry6);

        SymbolTableEntry entry7 = new SymbolTableEntry();
        entry7.ID = "ThisBoard.Tiles().Count";
        entry7.type = SymbolTableEntry.Type.Number;
        SymbolTable.put(entry7.ID, entry7);

        SymbolTableEntry entry8 = new SymbolTableEntry();
        entry8.ID = "ThisBoard.Tiles().PieceX.Remove()";
        entry8.type = SymbolTableEntry.Type.Boolean;
        SymbolTable.put(entry8.ID, entry8);

        SymbolTableEntry entry9 = new SymbolTableEntry();
        entry9.ID = "Input()";
        entry9.type = SymbolTableEntry.Type.Any;

        SymbolTableEntry entry91 = new SymbolTableEntry();
        entry91.type = SymbolTableEntry.Type.Text;
        entry91.ID = "Text";
        entry9.inputs.add(entry91);

        SymbolTable.put(entry9.ID, entry9);

        SymbolTableEntry entry10 = new SymbolTableEntry();
        entry10.ID = "Tie()";
        entry10.type = SymbolTableEntry.Type.Any;
        SymbolTable.put(entry10.ID, entry10);

        visitProgram((ProgramNode) AST);
        return SymbolTable;
    }

    @Override
    public void visitProgram(ProgramNode node){
        for (MethodNode M: node.methodNA) {
            visitMethod(M);
        }
        visitBoard(node.BoardN);
        visitPieces(node.PieceN);
        visitSetup(node.SetupN);
        visitRules(node.RulesN);
        visitWinCondition(node.WinConditionN);
        for (MethodNode M: node.methodNA) {
            ReadyMethods(M);
        }
    }

    @Override
    public void visitBoard(BoardNode node){
        visitSize(node.SizeN);
        for (BoardParamNode B : node.BoardParamNA) {
            visitBoardParam(B);
        }
    }

    @Override
    public void visitPieces(PiecesNode node){
        for (StmtNode S : node.StmtNA) {
            visitStmt(S);
        }
    }

    @Override
    public void visitSetup(SetupNode node){
        visitPlayer(node.PlayersN);
        for (StmtNode S : node.StmtNA) {
            visitStmt(S);
        }
    }

    @Override
    public void visitRules(RulesNode node){
        for (TurnNode T : node.TurnNA) {
            visitTurn(T);
        }
        visitTurnDistribution(node.TurnDistributionN);
    }

    @Override
    public void visitWinCondition(WinConditionNode node){
        for (WinCNDNode W : node.WinCNDNA) {
            visitWinCND(W);
        }
    }

    @Override
    public void visitMethod(MethodNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();

        for (int i = 0; i < node.IdNA.size(); i++) {
            SymbolTableEntry input = new SymbolTableEntry();
            input.ID = node.IdNA.get(i).Value;
            switch (node.TypeNA2.get(i).toString()) {
                case "Piece": input.type = SymbolTableEntry.Type.Piece; break;
                case "Number": input.type = SymbolTableEntry.Type.Number; break;
                case "Text": input.type = SymbolTableEntry.Type.Text; break;
                case "Boolean": input.type = SymbolTableEntry.Type.Boolean; break;
                case "Player": input.type = SymbolTableEntry.Type.Player; break;
                case "List": input.type = SymbolTableEntry.Type.List; break;
                case "Coordinate": input.type = SymbolTableEntry.Type.Coordinate; break;
            }
            entry.SymbolTable.put(input.ID, input);
            entry.inputs.add(input);

            if (input.type == SymbolTableEntry.Type.Piece){
                SymbolTableEntry E1 = new SymbolTableEntry();
                E1.type = SymbolTableEntry.Type.Any;
                E1.ID = input.ID + ".PlaceAt()";

                SymbolTableEntry E11 = new SymbolTableEntry();
                E11.type = SymbolTableEntry.Type.Coordinate;
                E11.ID = "Coordinate";
                E1.inputs.add(E11);

                entry.SymbolTable.put(E1.ID, E1);

                SymbolTableEntry E2 = new SymbolTableEntry();
                E2.type = SymbolTableEntry.Type.Any;
                E2.ID = input.ID + ".MoveTo()";

                SymbolTableEntry E21 = new SymbolTableEntry();
                E21.type = SymbolTableEntry.Type.Coordinate;
                E21.ID = "Coordinate";
                E2.inputs.add(E21);

                entry.SymbolTable.put(E2.ID, E2);

                SymbolTableEntry E3 = new SymbolTableEntry();
                E3.type = SymbolTableEntry.Type.Any;
                E3.ID = input.ID + ".Remove()";
                entry.SymbolTable.put(E3.ID, E3);

                SymbolTableEntry E4 = new SymbolTableEntry();
                E4.type = SymbolTableEntry.Type.Any;
                E4.ID = input.ID + ".CanMoveTo()";

                SymbolTableEntry E41 = new SymbolTableEntry();
                E41.type = SymbolTableEntry.Type.Coordinate;
                E41.ID = "Coordinate";
                E4.inputs.add(E41);

                entry.SymbolTable.put(E4.ID, E4);
            }
        }

        if (node.TypeNA1.size() == 1){
            switch (node.TypeNA1.get(0).toString()) {
                case "Piece": entry.type = SymbolTableEntry.Type.Piece; break;
                case "Number": entry.type = SymbolTableEntry.Type.Number; break;
                case "Text": entry.type = SymbolTableEntry.Type.Text; break;
                case "Boolean": entry.type = SymbolTableEntry.Type.Boolean; break;
                case "Player": entry.type = SymbolTableEntry.Type.Player; break;
                case "List": entry.type = SymbolTableEntry.Type.List; break;
                case "Coordinate": entry.type = SymbolTableEntry.Type.Coordinate; break;
            }
        }
        entry.ID = node.IdN.toString() + "()";
        SymbolTable.put(node.IdN.toString(),entry);
    }

    public void ReadyMethods(MethodNode node){
        for (SymbolTableEntry  E : SymbolTable.values()) {
            SymbolTable.get(node.IdN.toString()).SymbolTable.put(E.ID, E);
        }
        for (StmtNode S : node.StmtNA) {
            if (getEntry(S, SymbolTable.get(node.IdN.toString()).SymbolTable).ID != ""){
                SymbolTable.get(node.IdN.toString()).SymbolTable.put(getEntry(S, SymbolTable.get(node.IdN.toString()).SymbolTable).ID, getEntry(S, SymbolTable.get(node.IdN.toString()).SymbolTable));
            }
        }
        if(node.TypeNA1.size() == 1 && node.ReturnStmtNA.size() == 1) {
            ExpressionNode temp = node.ReturnStmtNA.get(0).ExpressionN;
            SymbolTableEntry.Type T = checkExpression(temp, SymbolTable.get(node.IdN.toString()).SymbolTable);
            TypeNode typeNode = node.TypeNA1.get(0);
            if (typeNode.toString() != T.toString() && T != SymbolTableEntry.Type.Any){
                ErrorLog.add("Return type in method dont match\n");
            }
        }
        else if (node.TypeNA1.size() == 0 && node.ReturnStmtNA.size() == 1){
            ErrorLog.add("No return type found\n");
        }
        else if (node.TypeNA1.size() == 1 && node.ReturnStmtNA.size() == 0){
            ErrorLog.add("No return statement found\n");
        }
    }

    @Override
    public void visitSize(SizeNode node) {
        visitHeight(node.HeightN);
        visitWidth(node.WidthN);
    }

    @Override
    public void visitBoardParam(BoardParamNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();
        if(node instanceof SpecialTilesNode){
            entry.type = SymbolTableEntry.Type.SpecialTiles;
            entry.ID = ((SpecialTilesNode) node).IdN.toString();
            if (SymbolTable.get(entry.ID) == null){
                SymbolTable.put(((SpecialTilesNode) node).IdN.toString(),entry);
            }
        }
    }

    public SymbolTableEntry getEntry(StmtNode node, HashMap<String, SymbolTableEntry> Sym){
        SymbolTableEntry entry = new SymbolTableEntry();

        if (node instanceof AssignmentStmtNode2){
            switch (((AssignmentStmtNode2) node).TypeN.toString()) {
                case "Piece": entry.type = SymbolTableEntry.Type.Piece; break;
                case "Number": entry.type = SymbolTableEntry.Type.Number; break;
                case "Text": entry.type = SymbolTableEntry.Type.Text; break;
                case "Boolean": entry.type = SymbolTableEntry.Type.Boolean; break;
                case "Player": entry.type = SymbolTableEntry.Type.Player; break;
                case "List": entry.type = SymbolTableEntry.Type.List; break;
                case "Coordinate": entry.type = SymbolTableEntry.Type.Coordinate; break;
            }
            entry.ID = ((AssignmentStmtNode2) node).IdN.toString();
            SymbolTableEntry.Type T = checkExpression(((AssignmentStmtNode2) node).ExpressionN, Sym);
            if (entry.type != T && T != SymbolTableEntry.Type.Any){
                ErrorLog.add("Type and expression of AssignmentStmtNode2 dont match\n");
            }
            if (entry.type == SymbolTableEntry.Type.Piece){
                SymbolTableEntry E1 = new SymbolTableEntry();
                E1.type = SymbolTableEntry.Type.Any;
                E1.ID = entry.ID + ".PlaceAt()";

                SymbolTableEntry E11 = new SymbolTableEntry();
                E11.type = SymbolTableEntry.Type.Coordinate;
                E11.ID = "Coordinate";
                E1.inputs.add(E11);

                Sym.put(E1.ID, E1);

                SymbolTableEntry E2 = new SymbolTableEntry();
                E2.type = SymbolTableEntry.Type.Any;
                E2.ID = entry.ID + ".MoveTo()";

                SymbolTableEntry E21 = new SymbolTableEntry();
                E21.type = SymbolTableEntry.Type.Coordinate;
                E21.ID = "Coordinate";
                E2.inputs.add(E21);

                Sym.put(E2.ID, E2);

                SymbolTableEntry E3 = new SymbolTableEntry();
                E3.type = SymbolTableEntry.Type.Any;
                E3.ID = entry.ID + ".Remove()";
                Sym.put(E3.ID, E3);

                SymbolTableEntry E4 = new SymbolTableEntry();
                E4.type = SymbolTableEntry.Type.Any;
                E4.ID = entry.ID + ".CanMoveTo()";

                SymbolTableEntry E41 = new SymbolTableEntry();
                E41.type = SymbolTableEntry.Type.Coordinate;
                E41.ID = "Coordinate";
                E4.inputs.add(E41);

                Sym.put(E4.ID, E4);
            }
        }
        else if (node instanceof AssignmentStmtNode3){
            String tempString = "";
            for (int i = 0; i < ((AssignmentStmtNode3) node).IdNA.size(); i++){
                tempString += ((AssignmentStmtNode3) node).IdNA.get(i).toString();
                if (i != ((AssignmentStmtNode3) node).IdNA.size()-1){
                    tempString += ".";
                }
            }
            SymbolTableEntry.Type T = checkExpression(((AssignmentStmtNode3) node).ExpressionN, Sym);
            if (Sym.containsKey(tempString)){
                if (Sym.get(tempString).type != T && T != SymbolTableEntry.Type.Any){
                    ErrorLog.add("Type and expression of AssignmentStmtNode3 dont match\n");
                }
            }
        }
        else if (node instanceof IfStmtNode){
            ExpressionNode temp = ((IfStmtNode) node).ExpressionN;
            SymbolTableEntry.Type type = checkExpression(temp, Sym);
            if (type != SymbolTableEntry.Type.Boolean){
                ErrorLog.add("Not bool in If statement\n");
            }
            for (StmtNode S : ((IfStmtNode) node).StmtNA) {
                if (getEntry(S, Sym).ID != ""){
                    Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                }
            }
            for (ElsIfNode ELS : ((IfStmtNode) node).ElsIfNA) {
                for (StmtNode S : ELS.StmtNA) {
                    if (getEntry(S, Sym).ID != ""){
                        Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                    }
                }
            }
            if(((IfStmtNode) node).ElsNA.size() == 1) {
                for (StmtNode S : ((IfStmtNode) node).ElsNA.get(0).StmtNA) {
                    if (getEntry(S, Sym).ID != ""){
                        Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                    }
                }
            }
        }
        else if (node instanceof RepeatWhileStmtNode){ // Her
            ExpressionNode temp = ((RepeatWhileStmtNode) node).ExpressionN;
            SymbolTableEntry.Type type = checkExpression(temp, Sym);
            if (type != SymbolTableEntry.Type.Boolean){
                ErrorLog.add("Not bool in RepeatWhile statement\n");
            }
            for (StmtNode S : ((RepeatWhileStmtNode) node).StmtNA) {
                if (getEntry(S, Sym).ID != ""){
                    Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                }
            }
        }
        else if (node instanceof RepeatStmtNode){
            for (StmtNode S : ((RepeatStmtNode) node).StmtNA) {
                if (getEntry(S, Sym).ID != ""){
                    Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                }
            }
        }
        else if (node instanceof OptionsStmtNode){
            ExpressionNode temp = ((OptionsStmtNode) node).ExpressionN;
            SymbolTableEntry.Type type = checkExpression(temp,Sym);
            if (type != SymbolTableEntry.Type.Number && type != SymbolTableEntry.Type.Any){
                ErrorLog.add("Not a number in OptionsStmt\n");
            }
            for (OptionNode O : ((OptionsStmtNode) node).OptionNA) {
                type = checkExpression(O.ExpressionN, Sym);
                if (type != SymbolTableEntry.Type.Number && type != SymbolTableEntry.Type.Any){
                    ErrorLog.add("Not a number in Option\n");
                }
                for (StmtNode S : O.StmtNA) {
                    if (getEntry(S, Sym).ID != ""){
                        Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                    }
                }
            }
            if(((OptionsStmtNode) node).DefNA.size() == 1) {
                for (StmtNode S : ((OptionsStmtNode) node).DefNA.get(0).StmtNA) {
                    if (getEntry(S, Sym).ID != ""){
                        Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                    }
                }
            }
        }
        else if (node instanceof ForeachStmtNode){
            if (Sym.containsKey(((ForeachStmtNode) node).IdN.toString())){
                if(Sym.get(((ForeachStmtNode) node).IdN.toString()).type != SymbolTableEntry.Type.List){
                    ErrorLog.add("Not a List in ForEach\n");
                }
            }
            else {
                ErrorLog.add("Non defined ID in Foreach\n");
            }
            for (StmtNode S : ((ForeachStmtNode) node).StmtNA) {
                if (getEntry(S, Sym).ID != ""){
                    Sym.put(getEntry(S, Sym).ID, getEntry(S, Sym));
                }
            }
        }
        else if (node instanceof MethodCallNode){
            String temp = "";
            for (MCNode M : ((MethodCallNode) node).MCNA) {
                if (M instanceof MCNode1){
                    if (((MCNode1) M).IdN.toString().replaceAll("[0-9]", "X").equals("PieceX")){
                        temp += ((MCNode1) M).IdN.toString().replaceAll("[0-9]", "X") + ".";
                    }
                    else {
                        temp += ((MCNode1) M).IdN.toString() + ".";
                    }
                }
                if (M instanceof MCNode2){
                    temp += ((MCNode2) M).IdN.toString() + "().";
                }
            }
            temp += ((MethodCallNode) node).IdN.toString() + "()";
            if (!Sym.containsKey(temp)){
                ErrorLog.add("Method not found\n");
            }
            else {
                if (Sym.get(temp).inputs.size() == ((MethodCallNode) node).ValueNA.size()){
                    for (int i = 0; i < Sym.get(temp).inputs.size(); i++){
                        if (((MethodCallNode) node).ValueNA.get(i) instanceof NumberValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Number && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof CoordinateValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Coordinate && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof ListValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.List && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof BoolValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Boolean && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof TextValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Text && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof MoveValueNode){
                            if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Move && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                ErrorLog.add("Method input type dont match\n");
                            }
                        }
                        else if (((MethodCallNode) node).ValueNA.get(i) instanceof StmtMethodValueNode){
                            if (Sym.containsKey(((MethodCallNode) node).ValueNA.get(i).toString())){
                                if (Sym.get(((MethodCallNode) node).ValueNA.get(i).toString()).type != Sym.get(temp).inputs.get(i).type){
                                    ErrorLog.add("Method input type dont match\n");
                                }
                            }
                        }
                    }
                }
                else {
                    ErrorLog.add("Wrong amount of input in method");
                }
            }
        }

        return entry;
    }

    @Override
    public void visitStmt(StmtNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();
        if (node instanceof AssignmentStmtNode1){
            SymbolTableEntry entry1 = new SymbolTableEntry();
            entry1.ID = "Moves";
            entry1.type = SymbolTableEntry.Type.List;
            entry.SymbolTable.put(entry1.ID, entry1);
            for (StmtNode S : ((AssignmentStmtNode1) node).PieceTypeN.StmtNA) {
                if (getEntry(S, entry.SymbolTable).ID != ""){
                    entry.SymbolTable.put(getEntry(S, entry.SymbolTable).ID, getEntry(S, entry.SymbolTable));
                }
            }
            entry.type = SymbolTableEntry.Type.Piece;
            entry.ID = ((AssignmentStmtNode1) node).IdN.toString();
            SymbolTable.put(((AssignmentStmtNode1) node).IdN.toString(),entry);
        }
        else {
            if (getEntry(node, SymbolTable).ID != ""){
                SymbolTable.put(getEntry(node, SymbolTable).ID, getEntry(node, SymbolTable));
            }
        }
        if (node instanceof AssignmentStmtNode3){
            String tempString = "";
            for (int i = 0; i < ((AssignmentStmtNode3) node).IdNA.size(); i++){
                tempString += ((AssignmentStmtNode3) node).IdNA.get(i).toString();
                if (i != ((AssignmentStmtNode3) node).IdNA.size()-1){
                    tempString += ".";
                }
            }
            if (SymbolTable.containsKey(tempString)){
                SymbolTableEntry.Type type = SymbolTable.get(tempString).type;
                //Check expression
                ExpressionNode temp = ((AssignmentStmtNode3) node).ExpressionN;
                if (temp instanceof ValueTermNode && ((ValueTermNode) temp).ValueN instanceof ListValueNode){
                    boolean containId = true;
                    boolean containPieces = true;
                    for (ValueNode V : ((ListValueNode) ((ValueTermNode) temp).ValueN).ValueNA) {
                        if (V instanceof StmtMethodValueNode){
                            if (SymbolTable.containsKey(V.toString())){
                                if (SymbolTable.get(V.toString()).type == SymbolTableEntry.Type.Piece){
                                    containPieces = false;
                                }
                            }
                        }
                    }
                    if (containPieces){
                        for (int i = 0; i < ((ListValueNode) ((ValueTermNode) temp).ValueN).ValueNA.size(); i++) {
                            SymbolTableEntry entry1 = new SymbolTableEntry();

                            entry1.ID = tempString + ".Piece" + i;
                            entry1.type = SymbolTableEntry.Type.Piece;
                            SymbolTable.put(entry1.ID, entry1);

                            SymbolTableEntry entry2 = new SymbolTableEntry();
                            entry2.ID = tempString + ".Piece" + i + ".CanMoveTo()";
                            entry2.type = SymbolTableEntry.Type.Boolean;

                            SymbolTableEntry entry21 = new SymbolTableEntry();
                            entry21.type = SymbolTableEntry.Type.Coordinate;
                            entry21.ID = "Coordinate";
                            entry2.inputs.add(entry21);

                            SymbolTable.put(entry2.ID, entry2);

                            SymbolTableEntry entry3 = new SymbolTableEntry();
                            entry3.ID = tempString + ".Piece" + i + ".MoveTo()";
                            entry3.type = SymbolTableEntry.Type.Boolean;

                            SymbolTableEntry entry31 = new SymbolTableEntry();
                            entry31.type = SymbolTableEntry.Type.Coordinate;
                            entry31.ID = "Coordinate";
                            entry3.inputs.add(entry31);

                            SymbolTable.put(entry3.ID, entry3);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void visitPlayer(PlayersNode node) {
        if (node instanceof PlayersNode1){

            for (int i = 1; i <= ((PlayersNode1) node).NumberValueN.Value; i++){
                String temp = "Player" + i;

                SymbolTableEntry entry1 = new SymbolTableEntry();
                entry1.ID = temp;
                entry1.type = SymbolTableEntry.Type.Player;
                SymbolTable.put(entry1.ID, entry1);

                SymbolTableEntry entry2 = new SymbolTableEntry();
                entry2.ID = temp + ".PieceList";
                entry2.type = SymbolTableEntry.Type.List;
                SymbolTable.put(entry2.ID, entry2);

                SymbolTableEntry entry3 = new SymbolTableEntry();
                entry3.ID = temp + ".PieceList.Contains()";
                entry3.type = SymbolTableEntry.Type.Boolean;

                SymbolTableEntry entry31 = new SymbolTableEntry();
                entry31.type = SymbolTableEntry.Type.Piece;
                entry31.ID = "Piece";
                entry3.inputs.add(entry31);

                SymbolTable.put(entry3.ID, entry3);

                SymbolTableEntry entry4 = new SymbolTableEntry();
                entry4.ID = temp + ".CurrentTurn";
                entry4.type = SymbolTableEntry.Type.Turn;
                SymbolTable.put(entry4.ID, entry4);

                SymbolTableEntry entry5 = new SymbolTableEntry();
                entry5.ID = temp + ".PlayerList";
                entry5.type = SymbolTableEntry.Type.List;
                SymbolTable.put(entry5.ID, entry5);

                SymbolTableEntry entry6 = new SymbolTableEntry();
                entry6.ID = temp + ".PlayerList.Count";
                entry6.type = SymbolTableEntry.Type.Number;
                SymbolTable.put(entry6.ID, entry6);

                SymbolTableEntry entry7 = new SymbolTableEntry();
                entry7.ID = temp + ".Win()";
                entry7.type = SymbolTableEntry.Type.Boolean;
                SymbolTable.put(entry7.ID, entry7);
            }
        }
        else if (node instanceof PlayersNode2){
            SymbolTableEntry entry = new SymbolTableEntry();

            for (IdNode I : ((PlayersNode2) node).IdNA) {
                String temp = I.Value;

                SymbolTableEntry entry1 = new SymbolTableEntry();
                entry1.ID = temp;
                entry1.type = SymbolTableEntry.Type.Player;
                SymbolTable.put(entry1.ID, entry1);

                SymbolTableEntry entry2 = new SymbolTableEntry();
                entry2.ID = temp + ".PieceList";
                entry2.type = SymbolTableEntry.Type.List;
                SymbolTable.put(entry2.ID, entry2);

                SymbolTableEntry entry3 = new SymbolTableEntry();
                entry3.ID = temp + ".PieceList.Contains()";
                entry3.type = SymbolTableEntry.Type.Boolean;

                SymbolTableEntry entry31 = new SymbolTableEntry();
                entry31.type = SymbolTableEntry.Type.Piece;
                entry31.ID = "Piece";
                entry3.inputs.add(entry31);

                SymbolTable.put(entry3.ID, entry3);

                SymbolTableEntry entry4 = new SymbolTableEntry();
                entry4.ID = temp + ".CurrentTurn";
                entry4.type = SymbolTableEntry.Type.Turn;
                SymbolTable.put(entry4.ID, entry4);

                SymbolTableEntry entry5 = new SymbolTableEntry();
                entry5.ID = temp + ".PlayerList";
                entry5.type = SymbolTableEntry.Type.List;
                SymbolTable.put(entry5.ID, entry5);

                SymbolTableEntry entry6 = new SymbolTableEntry();
                entry6.ID = temp + ".PlayerList.Count";
                entry6.type = SymbolTableEntry.Type.Number;
                SymbolTable.put(entry6.ID, entry6);

                SymbolTableEntry entry7 = new SymbolTableEntry();
                entry7.ID = temp + ".Win()";
                entry7.type = SymbolTableEntry.Type.Boolean;
                SymbolTable.put(entry7.ID, entry7);
            }
        }
    }

    @Override
    public void visitTurn(TurnNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();

        SymbolTableEntry setUp = new SymbolTableEntry();
        setUp.ID = node.IdN.toString();
        setUp.type = SymbolTableEntry.Type.Turn;
        if (!setUp.ID.toString().equals("")){
            SymbolTable.put(setUp.ID, setUp);
        }

        for (SymbolTableEntry E : SymbolTable.values()) {
            entry.SymbolTable.put(E.ID, E);
        }

        SymbolTableEntry entry1 = new SymbolTableEntry();
        entry1.ID = "PlayerPieceList";
        entry1.type = SymbolTableEntry.Type.List;
        entry.SymbolTable.put(entry1.ID, entry1);

        SymbolTableEntry entry2 = new SymbolTableEntry();
        entry2.ID = "PlayerAll";
        entry2.type = SymbolTableEntry.Type.Player;
        entry.SymbolTable.put(entry2.ID, entry2);

        SymbolTableEntry entry3 = new SymbolTableEntry();
        entry3.ID = "PlayerAll.PieceList";
        entry3.type = SymbolTableEntry.Type.List;
        entry.SymbolTable.put(entry3.ID, entry3);

        SymbolTableEntry entry4 = new SymbolTableEntry();
        entry4.ID = "PlayerAll.PieceList.Contains()";
        entry4.type = SymbolTableEntry.Type.Boolean;

        SymbolTableEntry entry41 = new SymbolTableEntry();
        entry41.type = SymbolTableEntry.Type.Piece;
        entry41.ID = "Piece";
        entry4.inputs.add(entry41);

        entry.SymbolTable.put(entry4.ID, entry4);

        SymbolTableEntry entry5 = new SymbolTableEntry();
        entry5.ID = "PlayerAll.CurrentTurn";
        entry5.type = SymbolTableEntry.Type.Turn;
        entry.SymbolTable.put(entry5.ID, entry5);

        SymbolTableEntry entry6 = new SymbolTableEntry();
        entry6.ID = "PlayerAll.PlayerList";
        entry6.type = SymbolTableEntry.Type.List;
        entry.SymbolTable.put(entry6.ID, entry6);

        SymbolTableEntry entry7 = new SymbolTableEntry();
        entry7.ID = "PlayerAll.PlayerList.Add()";
        entry7.type = SymbolTableEntry.Type.Any;

        SymbolTableEntry entry71 = new SymbolTableEntry();
        entry71.type = SymbolTableEntry.Type.Any;
        entry71.ID = "Any";
        entry7.inputs.add(entry71);

        entry.SymbolTable.put(entry7.ID, entry7);

        SymbolTableEntry entry8 = new SymbolTableEntry();
        entry8.ID = "PlayerAll.PlayerList.Count";
        entry8.type = SymbolTableEntry.Type.Number;
        entry.SymbolTable.put(entry8.ID, entry8);

        SymbolTableEntry entry9 = new SymbolTableEntry();
        entry9.ID = "PlayerAll.PieceX.CanMoveTo()";
        entry9.type = SymbolTableEntry.Type.Boolean;

        SymbolTableEntry entry91 = new SymbolTableEntry();
        entry91.type = SymbolTableEntry.Type.Coordinate;
        entry91.ID = "Coordinate";
        entry9.inputs.add(entry91);

        entry.SymbolTable.put(entry9.ID, entry9);

        SymbolTableEntry entry10 = new SymbolTableEntry();
        entry10.ID = "Input()";
        entry10.type = SymbolTableEntry.Type.Any;

        SymbolTableEntry entry101 = new SymbolTableEntry();
        entry101.type = SymbolTableEntry.Type.Text;
        entry101.ID = "Text";
        entry10.inputs.add(entry101);

        entry.SymbolTable.put(entry10.ID, entry10);

        SymbolTableEntry entry11 = new SymbolTableEntry();
        entry11.ID = "PlayerAll.PieceX.MoveTo()";
        entry11.type = SymbolTableEntry.Type.Boolean;

        SymbolTableEntry entry111 = new SymbolTableEntry();
        entry111.type = SymbolTableEntry.Type.Coordinate;
        entry111.ID = "Coordinate";
        entry11.inputs.add(entry111);

        entry.SymbolTable.put(entry11.ID, entry11);

        SymbolTableEntry entry12 = new SymbolTableEntry();
        entry12.ID = "PlayerAll.PieceX.PlaceAt()";
        entry12.type = SymbolTableEntry.Type.Boolean;

        SymbolTableEntry entry121 = new SymbolTableEntry();
        entry121.type = SymbolTableEntry.Type.Coordinate;
        entry121.ID = "Coordinate";
        entry12.inputs.add(entry121);

        entry.SymbolTable.put(entry12.ID, entry12);

        SymbolTableEntry entry13 = new SymbolTableEntry();
        entry13.ID = "Tie()";
        entry13.type = SymbolTableEntry.Type.Any;
        entry.SymbolTable.put(entry13.ID, entry13);

        SymbolTableEntry entry14 = new SymbolTableEntry();
        entry14.ID = "PlayerAll.Win()";
        entry14.type = SymbolTableEntry.Type.Any;
        entry.SymbolTable.put(entry14.ID, entry14);

        for (StmtNode S : node.StmtNA) {
            if (getEntry(S, entry.SymbolTable).ID != ""){
                entry.SymbolTable.put(getEntry(S, entry.SymbolTable).ID, getEntry(S, entry.SymbolTable));
            }
        }

        entry.ID = node.IdN.toString();
        entry.type = SymbolTableEntry.Type.Turn;
        if (!entry.ID.toString().equals("")){
            SymbolTable.put(node.IdN.toString(),entry);
        }
    }

    @Override
    public void visitTurnDistribution(TurnDistributionNode node) {
        for (StmtNode S : node.StmtNA) {
            visitStmt(S);
        }
    }

    @Override
    public void visitWinCND(WinCNDNode node) {
        if(node instanceof WinCNDNode1){
            visitStmt(((WinCNDNode1) node).IfStmtN);
        }
        else if (node instanceof WinCNDNode2){
            visitStmt(((WinCNDNode2) node).OptionsStmtN);
        }
    }

    @Override
    public void visitHeight(HeightNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();
        entry.ID = "Height";
        entry.type = SymbolTableEntry.Type.Number;
        SymbolTable.put(entry.ID,entry);
    }

    @Override
    public void visitWidth(WidthNode node) {
        SymbolTableEntry entry = new SymbolTableEntry();
        entry.ID = "Width";
        entry.type = SymbolTableEntry.Type.Number;
        SymbolTable.put(entry.ID,entry);
    }

    public SymbolTableEntry.Type checkExpression(ExpressionNode node, HashMap<String, SymbolTableEntry> Sym){
        SymbolTableEntry.Type T = null;
        SymbolTableEntry.Type T1 = null;
        SymbolTableEntry.Type T2 = null;

        if (node instanceof BinaryExpressionNode){
            if (((BinaryExpressionNode) node).LeftN instanceof ValueTermNode && ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN instanceof StmtMethodValueNode) {
                String temp = "";
                String temp2 = ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.get(0).toString().replaceAll("[0-9]","");
                if (temp2.equals("PlayerAll.Piece")){
                    temp = ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN.toString().replaceAll("[(].+[)]", "()").replaceAll("[0-9]", "X");
                }
                else {
                    for (int i = 0; i < ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.size(); i++) {
                        temp += ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.get(i).toString().replaceAll("[(].+[)]", "()");
                        if (i < ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.size() - 1){
                            temp += ".";
                        }
                    }
                }
                if (Sym.containsKey(temp)) {
                    T1 = Sym.get(temp).type;
                    int size = ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.size() - 1;
                    if (((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.get(size) instanceof StmtMethodNode1){
                        StmtMethodNode1 node1 = (StmtMethodNode1) ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).LeftN).ValueN).StmtMethodNA.get(size);
                        if (Sym.get(temp).inputs.size() == node1.ValueNA.size()){
                            for (int i = 0; i < Sym.get(temp).inputs.size(); i++){
                                if (node1.ValueNA.get(i) instanceof NumberValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Number && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof CoordinateValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Coordinate && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof ListValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.List && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof BoolValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Boolean && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof TextValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Text && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof MoveValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Move && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof StmtMethodValueNode){
                                    if (Sym.containsKey(node1.ValueNA.get(i).toString())){
                                        if (Sym.get(node1.ValueNA.get(i).toString()).type != Sym.get(temp).inputs.get(i).type){
                                            ErrorLog.add("Method input type dont match\n");
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            ErrorLog.add("Wrong amount of input in method");
                        }
                    }
                }
                else {
                    ErrorLog.add("Left StmtMethod from expression not found in Symboltable\n");
                }
            }
            else {
                T1 = checkExpression(((BinaryExpressionNode) node).LeftN, Sym);
            }

            if (((BinaryExpressionNode) node).RightN instanceof ValueTermNode && ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN instanceof StmtMethodValueNode) {
                String temp = "";
                String temp2 = ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.get(0).toString().replaceAll("[0-9]","");
                if (temp2.equals("PlayerAll.Piece")){
                    temp = ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN.toString().replaceAll("[(].+[)]", "()").replaceAll("[0-9]", "X");
                }
                else {
                    for (int i = 0; i < ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.size(); i++) {
                        temp += ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.get(i).toString().replaceAll("[(].+[)]", "()");
                        if (i < ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.size() - 1){
                            temp += ".";
                        }
                    }
                }
                if (Sym.containsKey(temp)) {
                    T2 = Sym.get(temp).type;
                    int size = ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.size() - 1;
                    if (((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.get(size) instanceof StmtMethodNode1){
                        StmtMethodNode1 node1 = (StmtMethodNode1) ((StmtMethodValueNode) ((ValueTermNode) ((BinaryExpressionNode) node).RightN).ValueN).StmtMethodNA.get(size);
                        if (Sym.get(temp).inputs.size() == node1.ValueNA.size()){
                            for (int i = 0; i < Sym.get(temp).inputs.size(); i++){
                                if (node1.ValueNA.get(i) instanceof NumberValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Number && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof CoordinateValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Coordinate && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof ListValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.List && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof BoolValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Boolean && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof TextValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Text && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof MoveValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Move && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof StmtMethodValueNode){
                                    if (Sym.containsKey(node1.ValueNA.get(i).toString())){
                                        if (Sym.get(node1.ValueNA.get(i).toString()).type != Sym.get(temp).inputs.get(i).type){
                                            ErrorLog.add("Method input type dont match\n");
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            ErrorLog.add("Wrong amount of input in method");
                        }
                    }
                }
                else {
                    ErrorLog.add("Rigth StmtMethod from expression not found in Symboltable\n");
                }
            }
            else {
                T2 = checkExpression(((BinaryExpressionNode) node).RightN, Sym);
            }
            if (T1 != null && T1 == T2){
                if (node instanceof AndNode || node instanceof OrNode){
                    if (T1 == SymbolTableEntry.Type.Boolean){
                        T = SymbolTableEntry.Type.Boolean;
                    }
                    else {
                        ErrorLog.add("Operant dont match\n");
                    }
                }
                else if (node instanceof AddNode || node instanceof SubtractNode ||
                        node instanceof multiplyNode || node instanceof DivideNode ||
                        node instanceof ModNode){
                    if (T1 == SymbolTableEntry.Type.Number){
                        T = SymbolTableEntry.Type.Number;
                    }
                    else {
                        ErrorLog.add("Operant dont match\n");
                    }
                }
                else if (node instanceof EqualsNode || node instanceof NotEqualsNode ||
                        node instanceof LessThanNode || node instanceof LargerThanNode ||
                        node instanceof EqualOrLessThanNode || node instanceof EqualOrLargerThanNode){
                    if (T1 == SymbolTableEntry.Type.Boolean || T1 == SymbolTableEntry.Type.Number){
                        T = SymbolTableEntry.Type.Boolean;
                    }
                    else {
                        ErrorLog.add("Operant dont match\n");
                    }
                }
            }
            else {
                ErrorLog.add("Left and Rigth expression dont match\n");
            }
        }
        else if (node instanceof ValueTermNode){
            if (((ValueTermNode) node).ValueN instanceof StmtMethodValueNode){
                String temp = "";
                String temp2 = ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.get(0).toString().replaceAll("[0-9]","");
                if (temp2.equals("PlayerAll.Piece")){
                    temp = ((ValueTermNode) node).ValueN.toString().replaceAll("[(].+[)]", "()").replaceAll("[0-9]", "X");
                }
                else {
                    for (int i = 0; i < ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.size(); i++) {
                        temp += ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.get(i).toString().replaceAll("[(].+[)]", "()");
                        if (i < ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.size() - 1){
                            temp += ".";
                        }
                    }
                }
                if (Sym.containsKey(temp)){
                    T = Sym.get(temp).type;
                    int size = ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.size() - 1;
                    if (((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.get(size) instanceof StmtMethodNode1){
                        StmtMethodNode1 node1 = (StmtMethodNode1) ((StmtMethodValueNode) ((ValueTermNode) node).ValueN).StmtMethodNA.get(size);
                        if (Sym.get(temp).inputs.size() == node1.ValueNA.size()){
                            for (int i = 0; i < Sym.get(temp).inputs.size(); i++){
                                if (node1.ValueNA.get(i) instanceof NumberValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Number && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof CoordinateValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Coordinate && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof ListValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.List && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof BoolValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Boolean && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof TextValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Text && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof MoveValueNode){
                                    if (Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Move && Sym.get(temp).inputs.get(i).type != SymbolTableEntry.Type.Any){
                                        ErrorLog.add("Method input type dont match\n");
                                    }
                                }
                                else if (node1.ValueNA.get(i) instanceof StmtMethodValueNode){
                                    if (Sym.containsKey(node1.ValueNA.get(i).toString())){
                                        if (Sym.get(node1.ValueNA.get(i).toString()).type != Sym.get(temp).inputs.get(i).type){
                                            ErrorLog.add("Method input type dont match\n");
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            ErrorLog.add("Wrong amount of input in method");
                        }
                    }
                }
                else {
                    ErrorLog.add("Non defined ID in expression\n");
                }
            }
            else if (((ValueTermNode) node).ValueN instanceof BoolValueNode){
                T = SymbolTableEntry.Type.Boolean;
            }
            else if (((ValueTermNode) node).ValueN instanceof NumberValueNode){
                T = SymbolTableEntry.Type.Number;
            }
            else if (((ValueTermNode) node).ValueN instanceof TextValueNode){
                T = SymbolTableEntry.Type.Text;
            }
            else if (((ValueTermNode) node).ValueN instanceof CoordinateValueNode){
                T = SymbolTableEntry.Type.Coordinate;
            }
            else if (((ValueTermNode) node).ValueN instanceof ListValueNode){
                String temp = "";
                if (((ListValueNode) ((ValueTermNode) node).ValueN).ValueNA.get(0) instanceof StmtMethodValueNode){
                    temp = Sym.get(((ListValueNode) ((ValueTermNode) node).ValueN).ValueNA.get(0).toString()).type.toString();
                }
                else {
                    temp = ((ListValueNode) ((ValueTermNode) node).ValueN).ValueNA.get(0).toJava();
                }
                for (ValueNode V : ((ListValueNode) ((ValueTermNode) node).ValueN).ValueNA) {
                    if (temp == "Move"){
                        if (V instanceof StmtMethodValueNode){
                            if (temp != Sym.get(V.toString()).type.toString() && "List" != Sym.get(V.toString()).type.toString()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                        else {
                            if (temp != V.toJava() && "List" != V.toJava()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                    }
                    else if (temp == "List"){
                        if (V instanceof StmtMethodValueNode){
                            if ("Move" == Sym.get(V.toString()).type.toString()){
                                temp = "Move";
                            }
                            else if (temp != Sym.get(V.toString()).type.toString()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                        else {
                            if (temp != V.toJava()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                    }
                    else {
                        if (V instanceof StmtMethodValueNode){
                            if (temp != Sym.get(V.toString()).type.toString()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                        else {
                            if (temp != V.toJava()){
                                ErrorLog.add("All types in list dont match");
                            }
                        }
                    }
                }
                T = SymbolTableEntry.Type.List;
            }
            else if (((ValueTermNode) node).ValueN instanceof MoveValueNode){
                T = SymbolTableEntry.Type.Move;
            }
        }
        else if (node instanceof NegationNode){
            if (checkExpression(((NegationNode) node).InnerN, Sym) == SymbolTableEntry.Type.Boolean){
                T = SymbolTableEntry.Type.Boolean;
            }
            else {
                ErrorLog.add("not a Boolean in negationNode");
            }
        }
        else if (node instanceof MinusNode){
            if (checkExpression(((MinusNode) node).InnerN, Sym) == SymbolTableEntry.Type.Number){
                T = SymbolTableEntry.Type.Number;
            }
            else {
                ErrorLog.add("not a Number in minusNode");
            }
        }

        return T;
    }
}
