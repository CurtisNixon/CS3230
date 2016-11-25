/**
 * Created by Curtis on 10/19/2016.
 */
public class PT1 {
    public static void main(String[] args){
        Lock l1 = new Lock();
        Lock l2 = new Lock();
        System.out.println(l1.equals(l2));
        Combination c1 = new Combination(1,2,3);
        Combination c2 = new Combination(1,2,3);
        Combination c3 = new Combination(1,2,4);
        Lock l4 = new Combination(1,2,4);
        System.out.println("Combinations and locks");
        System.out.println(l1.equals(l2));
        System.out.println(c1.equals(c3));
        System.out.println(l1.equals(l4));
        System.out.println(c3.equals(l4));

        Password p1 = new Password("john");
        Password p2 = new Password("john");
        Password p3 = new Password("bob");
        Lock l5 = new Password("bob");
        System.out.println("Passwords");
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(l5.equals(p3));

        Double d1 = new Double(1234,"john");
        Double d2 = new Double(1234,"john");
        Double d3 = new Double(1234,"bob");
        Double d4 = new Double(4321,"john");
        Lock l6 = new Double(1234,"bob");
        System.out.println("Pins");
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
        System.out.println(d1.equals(d4));
        System.out.println(l6.equals(d3));
        System.out.println(p1.equals(d1));
    }
}
