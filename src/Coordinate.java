/**
 * Created by Jonas on 02-05-2016.
 */
//Simple class for the storage of coordinates
public class Coordinate {
    Integer x;
    Integer y;

    public Coordinate() {
    }
    public Coordinate(Double InX, Double InY){
        this.x = InX.intValue();
        this.y = InY.intValue();
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Coordinate && ((Coordinate) other).x == x && ((Coordinate) other).y == y){
            return true;
        }
        return false;
    }
}
