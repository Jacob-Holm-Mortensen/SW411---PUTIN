import java.util.ArrayList;

/**
 * Created by Søren on 29-04-2016.
 */
/*The SuperClass for Pieces*/

public class Piece {
    Coordinate Coord = new Coordinate();
    ArrayList<Move> MoveList = new ArrayList<Move>();

    public Boolean MoveTo(Coordinate input){
        return false;
    }
    public Boolean PlaceAt(Coordinate Input){
        return false;
    }
    public Boolean CanMoveTo(Coordinate Input){
        return true;
    }
}
