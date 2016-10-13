/**
 * Created by Curtis on 9/28/2016.
 */
public class Tile {
    public boolean matches(Tile other){
        return this.getClass() == other.getClass();
    }
}
