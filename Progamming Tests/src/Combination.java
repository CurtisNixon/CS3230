/**
 * Created by Curtis on 10/19/2016.
 */
public class Combination extends Lock {
    private int first;
    private int second;
    private int third;

    public Combination(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object otherobject) {
        if (!super.equals(otherobject))
            return false;
        Combination other = (Combination) otherobject;
        return (first == other.first && second == other.second && third == other.third);

    }
}
