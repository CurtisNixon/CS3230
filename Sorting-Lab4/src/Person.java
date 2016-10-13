/**
 * Created by cnixon on 10/10/16.
 */
public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String phoneNumber;

    public Person(int num, String n, String s, String c, String st, String p){
        this.id = num;
        this.name = n;
        this.street = s;
        this.city = c;
        this.state = st;
        this.phoneNumber = p;
    }

    public Person(String n){
        this.id = 0;
        this.name = n;
        this.street = null;
        this.city = null;
        this.state = null;
        this.phoneNumber = null;
    }

    public Person(int n){
        this.id = n;
        this.name = null;
        this.street = null;
        this.city = null;
        this.state = null;
        this.phoneNumber = null;
    }

    public String toString(){
        return id + " " + name + " " + street + " " + city + " " + state + " " + phoneNumber;
    }

    public int getId(){
        return id;
    }

    @Override
    public int compareTo(Person person){
        String otherName = person.name;
        return name.compareTo(otherName);
    }

}
