import java.util.Comparator;

/**
 * Created by cnixon on 10/10/16.
 */
public class CompareInt implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        int first = p1.getId();
        int second = p2.getId();
        return first - second;
    }
}
