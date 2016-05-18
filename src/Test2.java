import org.antlr.v4.runtime.ANTLRInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Test2 {
    public static void main(String[] args){
        /*File file = new File("C:\\Users\\jacobholm\\Desktop\\TestCode.txt");
        FileInputStream fis = new FileInputStream(file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while (br.readLine() != null) {
            line += br.readLine();
        }
        br.close();
        */
        ANTLRInputStream inputStream = new ANTLRInputStream("Board[\n" +
                "\tHeight = 3;\n" +
                "\tWidth = 3;\n" +
                "]\n" +
                "\n" +
                "Pieces[\n" +
                "\tPiece Kryds = {\n" +
                "\t    Moves = (R(0,0));\n" +
                "\t}\n" +
                "\tPiece Bolle = {\n" +
                "\t    Moves = (R(0,0));\n" +
                "\t}\n" +
                "]\n" +
                "\n" +
                "Setup[\n" +
                "\tPlayers = 2;\n" +
                "\n" +
                "\tCoordinate Coord1 = (1,1);\n" +
                "\tCoordinate Coord2 = (1,2);\n" +
                "\tCoordinate Coord3 = (1,3);\n" +
                "\tCoordinate Coord4 = (2,1);\n" +
                "\tCoordinate Coord5 = (2,2);\n" +
                "\tCoordinate Coord6 = (2,3);\n" +
                "\tCoordinate Coord7 = (3,1);\n" +
                "\tCoordinate Coord8 = (3,2);\n" +
                "\tCoordinate Coord9 = (3,3);\n" +
                "\n" +
                "\tNumber TurnNumber = 0;\n" +
                "\n" +
                "\tPiece K1 = Kryds;\n" +
                "\tPiece K2 = Kryds;\n" +
                "\tPiece K3 = Kryds;\n" +
                "\tPiece B1 = Bolle;\n" +
                "\tPiece B2 = Bolle;\n" +
                "\tPiece B4 = Bolle;\n" +
                "\n" +
                "\tPlayer1.PieceList = (K1, K2, K3);\n" +
                "\tPlayer2.PieceList = (B1, B2, B4);\n" +
                "]\n" +
                "\n" +
                "Rules[\n" +
                "\tTurn Action{\n" +
                "\t\tCoordinate X = Input(\"Number\");\n" +
                "\t\tRepeatWhile(ThisBoard.Tiles(X).Count Equals 1){\n" +
                "\t\t\tX = Input(\"Number\");\n" +
                "\t\t}\n" +
                "\t\tOptions(TurnNumber){\n" +
                "\t\t\tOption 1 : { PlayerAll.Piece1.PlaceAt(X); }\n" +
                "\t\t\tOption 2 : { PlayerAll.Piece2.PlaceAt(X); }\n" +
                "\t\t\tOption 3 : { PlayerAll.Piece3.PlaceAt(X); }\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "\tTurn CheckWin{\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord1) Or PlayerAll.Piece2.CanMoveTo(Coord1) Or PlayerAll.Piece3.CanMoveTo(Coord1)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord2) Or PlayerAll.Piece2.CanMoveTo(Coord2) Or PlayerAll.Piece3.CanMoveTo(Coord2)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord3) Or PlayerAll.Piece2.CanMoveTo(Coord3) Or PlayerAll.Piece3.CanMoveTo(Coord3))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord4) Or PlayerAll.Piece2.CanMoveTo(Coord4) Or PlayerAll.Piece3.CanMoveTo(Coord4)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord5) Or PlayerAll.Piece2.CanMoveTo(Coord5) Or PlayerAll.Piece3.CanMoveTo(Coord5)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord6) Or PlayerAll.Piece2.CanMoveTo(Coord6) Or PlayerAll.Piece3.CanMoveTo(Coord6))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord7) Or PlayerAll.Piece2.CanMoveTo(Coord7) Or PlayerAll.Piece3.CanMoveTo(Coord7)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord8) Or PlayerAll.Piece2.CanMoveTo(Coord8) Or PlayerAll.Piece3.CanMoveTo(Coord8)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord9) Or PlayerAll.Piece2.CanMoveTo(Coord9) Or PlayerAll.Piece3.CanMoveTo(Coord9))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord1) Or PlayerAll.Piece2.CanMoveTo(Coord1) Or PlayerAll.Piece3.CanMoveTo(Coord1)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord4) Or PlayerAll.Piece2.CanMoveTo(Coord4) Or PlayerAll.Piece3.CanMoveTo(Coord4)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord7) Or PlayerAll.Piece2.CanMoveTo(Coord7) Or PlayerAll.Piece3.CanMoveTo(Coord7))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord2) Or PlayerAll.Piece2.CanMoveTo(Coord2) Or PlayerAll.Piece3.CanMoveTo(Coord2)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord5) Or PlayerAll.Piece2.CanMoveTo(Coord5) Or PlayerAll.Piece3.CanMoveTo(Coord5)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord8) Or PlayerAll.Piece2.CanMoveTo(Coord8) Or PlayerAll.Piece3.CanMoveTo(Coord8))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord3) Or PlayerAll.Piece2.CanMoveTo(Coord3) Or PlayerAll.Piece3.CanMoveTo(Coord3)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord6) Or PlayerAll.Piece2.CanMoveTo(Coord6) Or PlayerAll.Piece3.CanMoveTo(Coord6)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord9) Or PlayerAll.Piece2.CanMoveTo(Coord9) Or PlayerAll.Piece3.CanMoveTo(Coord9))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord1) Or PlayerAll.Piece2.CanMoveTo(Coord1) Or PlayerAll.Piece3.CanMoveTo(Coord1)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord5) Or PlayerAll.Piece2.CanMoveTo(Coord5) Or PlayerAll.Piece3.CanMoveTo(Coord5)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord9) Or PlayerAll.Piece2.CanMoveTo(Coord9) Or PlayerAll.Piece3.CanMoveTo(Coord9))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tIf((PlayerAll.Piece1.CanMoveTo(Coord3) Or PlayerAll.Piece2.CanMoveTo(Coord3) Or PlayerAll.Piece3.CanMoveTo(Coord3)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord5) Or PlayerAll.Piece2.CanMoveTo(Coord5) Or PlayerAll.Piece3.CanMoveTo(Coord5)) And" +
                "\t\t   (PlayerAll.Piece1.CanMoveTo(Coord7) Or PlayerAll.Piece2.CanMoveTo(Coord7) Or PlayerAll.Piece3.CanMoveTo(Coord7))){\n" +
                "\t\t    PlayerAll.Win();\n" +
                "\t\t}\n" +
                "\t\tTie();\n" +
                "\t}\n" +
                "\t\n" +
                "\tTurnDistribution{\n" +
                "\t\tTurnNumber = TurnNumber + 1;\n" +
                "\t\tPlayer1.CurrentTurn = Action;\n" +
                "\t\tPlayer2.CurrentTurn = Action;\n" +
                "\t}\n" +
                "]\n" +
                "\n" +
                "WinConditions[\n" +
                "\tIf(TurnNumber Equals 3){\n" +
                "\t\tPlayer1.CurrentTurn = CheckWin;\n" +
                "\t\tPlayer2.CurrentTurn = CheckWin;\n" +
                "\t}\n" +
                "]");
        PUTINLexer lexer = new PUTINLexer(inputStream);
        org.antlr.v4.runtime.TokenStream tokenStream = new org.antlr.v4.runtime.CommonTokenStream(lexer);
        PUTINParser Parser = new PUTINParser(tokenStream);
        BuildAstVisitor BuildAST = new BuildAstVisitor();
        PUTINNode node = BuildAST.visitProgram(Parser.program());
        HashMap<String, SymbolTableEntry> SymbolTable = new HashMap<String, SymbolTableEntry>();
        BuildSymbolTable BuildSym = new BuildSymbolTable();
        SymbolTable = BuildSym.ReturnSymbolTable(node);
        GenerateCode GC = new GenerateCode();
        ArrayList<ArrayList<String>> result = GC.getThings((ProgramNode) node, SymbolTable);
        ArrayList<String> ErrorLog = BuildSym.getErrorLog();

        if (ErrorLog.size() == 0){
            try {
                WriterClass W = new WriterClass("KB");
                W.WriteThis(result, "KB"); //gets initial code setup from the headersetup class
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            for (String S : ErrorLog) {
                System.out.print(S + "\n");
            }
        }


        System.out.print("");
        /*for (String key : SymbolTable.keySet()) {
            System.out.println("\n" + key);
            for (String key2 : SymbolTable.get(key).SymbolTable.keySet()) {
                System.out.print("  " + key2 + "  |");
            }
            if (!SymbolTable.get(key).SymbolTable.isEmpty()){
                System.out.print("\n");
            }
        }*/



        //System.out.print(node.toString());
    }
}
