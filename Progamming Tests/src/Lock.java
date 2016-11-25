/**
 * Created by Curtis on 10/19/2016.
 */
public class Lock {
    @Override
    public boolean equals(Object otherobject){
        if(this == otherobject)
            return true;
        if(otherobject == null)
            return false;
        if(getClass() != otherobject.getClass())
            return false;
        if(otherobject instanceof Lock)
            return true;
        else
            return false;


    }
}
