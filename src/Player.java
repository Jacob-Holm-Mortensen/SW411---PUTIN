import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jonas on 02-05-2016.
 */
//Class representing a player
public class Player {
    String Name = "";
    ArrayList<Piece> PieceList = new ArrayList<Piece>();
    ArrayList<String> PlayerList = new ArrayList<String>();

    public void Win(){
        System.out.print(Name + " Won");
        Scanner in = new Scanner(System.in);
        in.next();
        System.exit(0);
    }
}
