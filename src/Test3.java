import org.antlr.v4.runtime.ANTLRInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Test3 {
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
                "]\n" +
                "\n" +
                "Setup[\n" +
                "\tPlayers = 2;\n" +
                "\tNumber X = 10;\n" +
                "\tIf(X Equals 2){\n" +
                "\t\tX = X + 2;\n" +
                "\t}\n" +
                "\tElse{\n" +
                "\t\tX = X + 1;\n" +
                "\t}\n" +
                "]\n" +
                "\n" +
                "Rules[\n" +
                "\tTurn Action{\n" +
                "\t}\n" +
                "\t\n" +
                "\tTurnDistribution{\n" +
                "\t}\n" +
                "]\n" +
                "\n" +
                "WinConditions[\n" +
                "]");
        PUTINLexer lexer = new PUTINLexer(inputStream);
        org.antlr.v4.runtime.TokenStream tokenStream = new org.antlr.v4.runtime.CommonTokenStream(lexer);
        PUTINParser Parser = new PUTINParser(tokenStream);
        BuildAstVisitor BuildAST = new BuildAstVisitor();
        PUTINNode node = BuildAST.visitProgram(Parser.program());
        ArrayList<String> ErrorLog1 = BuildAST.getErrorLog();

        if (ErrorLog1.size() == 0){
            HashMap<String, SymbolTableEntry> SymbolTable = new HashMap<String, SymbolTableEntry>();
            BuildSymbolTable BuildSym = new BuildSymbolTable();
            SymbolTable = BuildSym.ReturnSymbolTable(node);
            GenerateJVM GJVM = new GenerateJVM();
            ArrayList<String> result = GJVM.getThings((ProgramNode) node, SymbolTable);
            ArrayList<String> ErrorLog2 = BuildSym.getErrorLog();

            if (ErrorLog2.size() == 0){
                try {
                    WriterClass W = new WriterClass("JVM.j");
                    W.WriteJVM(result); //gets initial code setup from the headersetup class
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                for (String S : ErrorLog2) {
                    System.out.print(S + "\n");
                }
            }
        }
        else {
            for (String S : ErrorLog1) {
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
