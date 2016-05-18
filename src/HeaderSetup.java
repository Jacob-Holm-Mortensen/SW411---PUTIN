import java.util.ArrayList;
import java.util.List;

/*Offers functionality to build a Java file header*/
public class HeaderSetup {

    //Builds, then returns, a header. One line per string in the list.
    ArrayList<String> BuildHeader(String S)
    {
        ArrayList<String> Header = new ArrayList<String>();
        Header.add("import java.util.ArrayList;");
        Header.add("import java.util.Scanner;");
        Header.add("import java.util.InputMismatchException;");
        Header.add("");
        Header.add("public class " + S + "{");
        Header.add("\tpublic static void main(String[] args){");
        Header.add("\t\tProgram S = new Program();");
        Header.add("\t\tS.begin();");
        Header.add("\t}");
        Header.add("}\n");
        Header.add("class Program{");
        Header.add("\tBoardClass Board = new BoardClass();");
        Header.add("\tArrayList<Player> PlayerList = new ArrayList<Player>();");

        //Prints out the header file to stdio
        System.out.println("The following has been written:");
        for (String item : Header) {
            System.out.println("* " + item);
        }

        return Header;
    }
}