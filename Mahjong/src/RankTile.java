import java.util.Objects;

/**
 * Created by Curtis on 9/28/2016.
 */
public class RankTile extends Tile {
    protected int rank;
    public RankTile(int rank){
        this.rank = rank;
    }
    public boolean matches(Tile other) {
        if (!super.matches(other) )
            return false;
        RankTile otherObj = (RankTile) other;
        return this.rank == otherObj.rank;
    }

}
