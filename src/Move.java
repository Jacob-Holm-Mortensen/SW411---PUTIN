/**
 * Created by jacobholm on 13/05/2016.
 */
public class Move {
    int Hmin = 0;
    int Hmax = 0;

    int Vmin = 0;
    int Vmax = 0;

    public Move(Double hmin, Double hmax, Double vmin, Double vmax){
        Hmin = hmin.intValue();
        Hmax = hmax.intValue();
        Vmin = vmin.intValue();
        Vmax = vmax.intValue();
    }

    public Move(Double rmin, Double rmax){
        Hmin = rmin.intValue();
        Hmax = rmax.intValue();
        Vmin = rmin.intValue();
        Vmax = rmax.intValue();
    }
}
