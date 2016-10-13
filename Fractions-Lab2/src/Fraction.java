/**
 * Created by Curtis on 9/17/2016.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    //constructors
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;

    }

    public Fraction(int numerator, int denominator){
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;

    }

    //class methods
    public Fraction add(Fraction right){
        //find left numerator
        int leftNumerator = this.numerator * right.denominator;
        //find right numerator
        int rightNumerator = right.numerator * this.denominator;
        //add them for the new numerator
        int newNumerator = leftNumerator + rightNumerator;
        //multiply denominators for the new denominator
        int newDenominator = this.denominator * right.denominator;
        //return new fraction object, constructor will reduce it if needed
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction sub(Fraction right){
        //find left numerator
        int leftNumerator = this.numerator * right.denominator;
        //find right numerator
        int rightNumerator = right.numerator * this.denominator;
        //subtract them for the new numerator
        int newNumerator = leftNumerator - rightNumerator;
        //multiply denominators for the new denominator
        int newDenominator = this.denominator * right.denominator;
        //return new fraction object, constructor will reduce it if needed
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction mult(Fraction right){
        //multiply numerators and denominators straight across
        //find new numerator
        int newNumerator = this.numerator * right.numerator;
        //find new denominator
        int newDenominator = this.denominator * right.denominator;
        //return new fraction object.
        return new Fraction(newNumerator, newDenominator);

    }

    public Fraction div(Fraction right){
        //cross multiply and flip the result
        int newDenominator = this.denominator * right.numerator;
        int newNumerator = this.numerator * right.denominator;
        return new Fraction(newNumerator, newDenominator);

    }

    @Override
    public String toString(){
        String fractionString;
        String negativeSign = "";
        if(this.numerator < 0 || this.denominator < 0){
            if(this.numerator < 0 && this.denominator < 0){
                negativeSign = "";
            }else {
                negativeSign = "-";
            }
        }


        fractionString = negativeSign + Math.abs(this.numerator) + "/" + Math.abs(this.denominator);
        return fractionString;
    }

    @Override
    public boolean equals(Object other){
        //check if the objects are equal
        if(this == other){
            return true;
        }
        //check for null
        if(other == null){
            return false;
        }
        //compare classes
        if(this.getClass() != other.getClass()){
            return false;
        }
        //check subclasses
        if(!(other instanceof Fraction)){
            return false;
        }
        //cast to same class
        Fraction castedOther = (Fraction) other;
        //return toString on both objects(since it eliminates unnecessary negatives) to test for equality
        return this.toString().equals(castedOther.toString());
    }

    private int gcd(int u, int v){
        u = (u < 0) ? -u : u; // make u non-negative
        v = (v < 0) ? -v : v; // make v non-negative
        while (u > 0)
        {
            if (u < v)
            {
                int t = u; // swap u and v
                u = v;
                v = t;
            }
            u -= v;
        }
        return v; // the GCD of u and v
    }


    //main for testing
    public static void main(String[] args){
        Fraction fraction1 = new Fraction(3,1);
        Fraction fraction2 = new Fraction(2,2);
        Fraction fraction3 = new Fraction(-1,3);
        Fraction fraction4 = new Fraction(4,-2);
        Fraction fraction5 = new Fraction(-1,-2);
        Fraction fraction6 = new Fraction(2,4);
        //fraction construction tests and tostring
        System.out.println("fraction1: " + fraction1.toString());
        System.out.println("fraction2: " + fraction2.toString());
        System.out.println("fraction3: " + fraction3.toString());
        System.out.println("fraction4: " + fraction4.toString());
        System.out.println("fraction5: " + fraction5.toString());
        System.out.println("fraction6: " + fraction6.toString());
        //add tests
//        System.out.println("fraction1 + fraction2: " + fraction1.add(fraction2));
//        System.out.println("fraction1 + fraction1: " + fraction1.add(fraction1));
//        System.out.println("fraction1 + fraction3: " + fraction1.add(fraction3));
//        System.out.println("fraction2 + fraction4: " + fraction2.add(fraction4));
//        System.out.println("fraction3 + fraction5: " + fraction3.add(fraction5));
        //sub tests
//        System.out.println("fraction1 - fraction2: " + fraction1.sub(fraction2));
//        System.out.println("fraction1 - fraction1: " + fraction1.sub(fraction1));
//        System.out.println("fraction1 - fraction3: " + fraction1.sub(fraction3));
//        System.out.println("fraction2 - fraction4: " + fraction2.sub(fraction4));
//        System.out.println("fraction3 - fraction5: " + fraction3.sub(fraction5));
        //mult  tests
//        System.out.println("fraction1 * fraction2: " + fraction1.mult(fraction2));
//        System.out.println("fraction1 * fraction1: " + fraction1.mult(fraction1));
//        System.out.println("fraction1 * fraction3: " + fraction1.mult(fraction3));
//        System.out.println("fraction2 * fraction4: " + fraction2.mult(fraction4));
//        System.out.println("fraction3 * fraction5: " + fraction3.mult(fraction5));
        //div  tests
//        System.out.println("fraction1 / fraction2: " + fraction1.div(fraction2));
//        System.out.println("fraction1 / fraction1: " + fraction1.div(fraction1));
//        System.out.println("fraction1 / fraction3: " + fraction1.div(fraction3));
//        System.out.println("fraction2 / fraction4: " + fraction2.div(fraction4));
//        System.out.println("fraction3 / fraction5: " + fraction3.div(fraction5));

        //equals tests
//        System.out.println("fraction1 == fraction2: " + fraction1.equals(fraction2));
//        System.out.println("fraction1 == fraction1: " + fraction1.equals(fraction1));
//        System.out.println("fraction1 == fraction3: " + fraction1.equals(fraction3));
//        System.out.println("fraction2 == fraction4: " + fraction2.equals(fraction4));
//        System.out.println("fraction3 == fraction5: " + fraction3.equals(fraction5));
//        System.out.println("fraction6 == fraction5: " + fraction6.equals(fraction5));
    }
}
