import java.util.ArrayList;

/**
 * Created by Jonas on 02-05-2016.
 */
//A class for containing the game board.
public class BoardClass {

    Integer Height;
    Integer Width;
    ArrayList<ArrayList> SpecialTiles;
    ArrayList IllegalTiles;
    ArrayList<Player> PLayerList;

    public BoardClass(){
        this.Height = 1;
        this.Width = 1;

        SpecialTiles = new ArrayList<ArrayList>();
        IllegalTiles = new ArrayList();
        SpecialTiles.add(IllegalTiles);
    }
    public BoardClass(Integer InHeight, Integer InWidth){
        if (InHeight < 1){this.Height = 1;}
        else{this.Height = InHeight;}
        if (InWidth < 1){this.Width = 1;}
        else{this.Width = InWidth;}

        SpecialTiles = new ArrayList<ArrayList>();
        IllegalTiles = new ArrayList();
        SpecialTiles.add(IllegalTiles);
    }

    public ArrayList<Piece> Tiles(Coordinate X){
        ArrayList<Piece> P = new ArrayList<Piece>();
        for (Player PL : PLayerList) {
            for (Piece PI : PL.PieceList) {
                if (PI.Coord.equals(X)){
                    P.add(PI);
                }
            }
        }
        return P;
    }

    //Getters and Setters
    public void setPlayerList(ArrayList<Player> PL){
        PLayerList = PL;
    }
    public Integer getHeight() {
        return Height;
    }
    public void setHeight(Integer height) {
        Height = height;
    }
    public Integer getWidth() {
        return Width;
    }
    public void setWidth(Integer width) {
        Width = width;
    }

}
