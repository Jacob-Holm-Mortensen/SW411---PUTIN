/**
 * Created by Søren on 29-04-2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WriterClass {
    //setup FileWriter
    public File outputFile;
    public FileWriter writer;
    ArrayList<String> strings=new ArrayList<String>();
    ArrayList<ArrayList<String>> code;
    HeaderSetup headerSetup;

    public WriterClass(String S)throws IOException{
        headerSetup = new HeaderSetup();
        outputFile = new File("Output\\" + S + ".java");
        outputFile.createNewFile();
        writer = new FileWriter(outputFile);
    }

    public void WriteJVM(ArrayList<String> JVM)throws IOException{
        for (String s : JVM) {
            writer.write(s + "\n");
        }
        writer.flush();
        writer.close();
    }

    public void WriteThis(ArrayList<ArrayList<String>> r, String S)throws IOException{
        code = r;
        ArrayList<String> result = headerSetup.BuildHeader(S);
        for (String s:result) {
            writer.write(s + "\n");
        }

        for (String s : code.get(1)) {
            writer.write("\t" + s + "\n");
        }

        writer.write("\n\tpublic void begin(){\n");

        for (String s : code.get(0)) {
            writer.write("\t\t" + s + "\n");
        }

        writer.write("\t\tPrintBoard();\n");
        writer.write("\t\twhile (WinCondition()){\n");
        writer.write("\t\t\tTurnDistribution();\n");
        writer.write("\t\t\tArrayList<Integer> I = new ArrayList<Integer>();\n");
        writer.write("\t\t\tfor (Player PL : PlayerList) {\n");
        writer.write("\t\t\t\tfor (Piece PI : PL.PieceList) {\n");
        writer.write("\t\t\t\t\tif (PI.Coord.equals(new Coordinate(0.0, 0.0))){\n");
        writer.write("\t\t\t\t\t\tI.add(PL.PieceList.indexOf(PI));\n");
        writer.write("\t\t\t\t\t}\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tfor (int i = 0; i < I.size(); i++) {\n");
        writer.write("\t\t\t\t\tPL.PieceList.remove(I.get(i) - i);\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tI = new ArrayList<Integer>();\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t}\n");
        writer.write("\t}\n\n");

        writer.write("\t// Pieces, Rules and Methods\n");

        writer.write("\tpublic void Tie(){\n");
        writer.write("\t\tSystem.out.print(\"Nobody won it is a tie!\");\n");
        writer.write("\t\tScanner in = new Scanner(System.in);\n");
        writer.write("\t\tin.next();\n");
        writer.write("\t\tSystem.exit(0);\n");
        writer.write("\t}\n\n");

        writer.write("\tpublic void PrintBoard(){\n");
        writer.write("\t\tSystem.out.print(\"\\n\");\n");
        writer.write("\t\tfor (int i = 1; i <= Board.Width; i++){\n");
        writer.write("\t\t\tif (i == 1){\n");
        writer.write("\t\t\t\tSystem.out.print(\" \" + (i - 1) + \" \");\n");
        writer.write("\t\t\t\tfor (int k = 1; k <= Board.Height; k++){\n");
        writer.write("\t\t\t\t\tSystem.out.print(\" \" + k + \" \");\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tSystem.out.print(\" X \\n\");\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t\tSystem.out.print(\" \" + i + \" \");\n");
        writer.write("\t\t\tfor (int j = 1; j <= Board.Height; j++){\n");
        writer.write("\t\t\t\tBoolean is = false;\n");
        writer.write("\t\t\t\tfor (Player PL : PlayerList) {\n");
        writer.write("\t\t\t\t\tfor (Piece PI : PL.PieceList) {\n");
        writer.write("\t\t\t\t\t\tif (PI.Coord.equals(new Coordinate((double) j, (double) i))){\n");
        writer.write("\t\t\t\t\t\t\tis = true;\n");
        writer.write("\t\t\t\t\t\t}\n");
        writer.write("\t\t\t\t\t}\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tif (is){\n");
        writer.write("\t\t\t\t\tSystem.out.print(\"[X]\");\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\telse {\n");
        writer.write("\t\t\t\t\tSystem.out.print(\"[ ]\");\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t\tif (i == Board.Width){\n");
        writer.write("\t\t\t\tSystem.out.print(\"\\n Y \");\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t\tSystem.out.print(\"\\n\");\n");
        writer.write("\t\t}\n");
        writer.write("\t\tSystem.out.print(\"\\n\");\n");
        writer.write("\t}\n\n");

        writer.write("\tstatic String Input(String type){\n");
        writer.write("\t\tString result = \"\";\n");
        writer.write("\t\tScanner in = new Scanner(System.in);\n");
        writer.write("\t\ttry{\n");
        writer.write("\t\t\tswitch (type){\n");
        writer.write("\t\t\t\tcase \"Number\" : System.out.print(\"Please write a number -> \"); result = Double.toString(in.nextDouble()); break;\n");
        writer.write("\t\t\t\tcase \"Text\" : System.out.print(\"Please write a string ->\"); result = in.nextLine(); break;\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t}\n");
        writer.write("\t\tcatch (InputMismatchException e){\n");
        writer.write("\t\t\tSystem.out.print(\"Wrong input, please input a \" + type);\n");
        writer.write("\t\t}\n");
        writer.write("\t\treturn result;\n");
        writer.write("\t}\n\n");

        writer.write("\tpublic Boolean Contains(ArrayList<Piece> PL, Piece PT){\n");
        writer.write("\t\tfor (Piece P : PL) {\n");
        writer.write("\t\t\tif (P.getClass().equals(PT.getClass())){\n");
        writer.write("\t\t\t\treturn true;\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t}\n");
        writer.write("\t\treturn false;\n");
        writer.write("\t}\n\n");

        writer.write("\tpublic Boolean PieceCheckOne(Coordinate input){\n");
        writer.write("\t\tif (input.x > Board.Width || input.y > Board.Height){\n");
        writer.write("\t\t\treturn false;\n");
        writer.write("\t\t}\n");
        writer.write("\t\tif (input.x < 1 || input.y < 1){\n");
        writer.write("\t\t\treturn false;\n");
        writer.write("\t\t}\n");
        writer.write("\t\tif (IllegalTiles.contains(input)){\n");
        writer.write("\t\t\treturn false;\n");
        writer.write("\t\t}\n");
        writer.write("\t\treturn true;\n");
        writer.write("\t}\n\n");
        writer.write("\tpublic Boolean PieceCheckTwo(Coordinate input, Coordinate Coord, ArrayList<Move> MoveList){\n");
        writer.write("\t\tint DiffX = Math.abs(Coord.x - input.x);\n");
        writer.write("\t\tint DiffY = Math.abs(Coord.y - input.y);\n");
        writer.write("\t\tBoolean returnValue = false;\n");
        writer.write("\t\tfor (Move M : MoveList) {\n");
        writer.write("\t\t\tif (!returnValue){\n");
        writer.write("\t\t\t\treturnValue = true;\n");
        writer.write("\t\t\t\tif (DiffX < M.Hmin){\n");
        writer.write("\t\t\t\t\treturnValue = false;\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tif (DiffX > M.Hmax){\n");
        writer.write("\t\t\t\t\treturnValue = false;\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tif (DiffY < M.Vmin){\n");
        writer.write("\t\t\t\t\treturnValue = false;\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t\tif (DiffY > M.Vmax){\n");
        writer.write("\t\t\t\t\treturnValue = false;\n");
        writer.write("\t\t\t\t}\n");
        writer.write("\t\t\t}\n");
        writer.write("\t\t}\n");
        writer.write("\t\tif (returnValue){\n");
        writer.write("\t\t\treturn true;\n");
        writer.write("\t\t}\n");
        writer.write("\t\telse {\n");
        writer.write("\t\t\treturn false;\n");
        writer.write("\t\t}\n");
        writer.write("\t}\n\n");

        for (int i = 2; i < code.size(); i++){
            for (String s : code.get(i)) {
                writer.write("\t" + s + "\n");
            }
            writer.write("\n");
        }

        writer.write("}");
        writer.flush();
        writer.close();
    }
}
