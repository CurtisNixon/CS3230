import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Curtis on 9/17/2016.
 */
public class FractionCalc {
    public static void main(String[] args) {
        //ask for input
        System.out.println("Enter a fraction expression:");
        //get input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //only do something if input was given
        if (input != null) {
            //the regex that find each digit and the middle operation and allows spaces and tabs between all characters
            String fractionPattern = "\\s*\\t*\\\\*t*(-?\\d+)\\s*\\t*\\\\*t*\\/\\s*\\t*\\\\*t*(-?\\d+)\\s*\\t*\\\\*t*([-+*/])\\s*\\t*\\\\*t*(-?\\d+)\\s*\\t*\\\\*t*\\/\\s*\\t*\\\\*t*(-?\\d+)\\s*\\t*\\\\*t*";
            //the matcher to the input we got
            Matcher f = Pattern.compile(fractionPattern).matcher(input);
            //the input is a match to the regex
            if (f.find()) {
                //store each group(digit or operation) in an array
                String[] groups = new String[f.groupCount()];
                for(int i = 0; i < f.groupCount() ;i++) {
                    groups[i]= f.group(i+1);
                }
                //build the fraction objects from the group of digits
                //Groups 0 and 1 are the left fraction
                Fraction left = new Fraction(Integer.parseInt(groups[0]),Integer.parseInt(groups[1]));
                //Groups 3 and 4 are the right fraction
                Fraction right = new Fraction(Integer.parseInt(groups[3]),Integer.parseInt(groups[4]));
                //group 2 is the operation

                //doesn't work with java version on work desktop
//                switch(groups[2]){
//                    case "+":
//                        System.out.println(left.add(right));
//                        break;
//                    case "-":
//                        System.out.println(left.sub(right));
//                        break;
//                    case "*":
//                        System.out.println(left.mult(right));
//                        break;
//                    case "/":
//                        System.out.println(left.div(right));
//                        break;
//                }
                //ugly workaround for older java version
                if(groups[2].equals("+")) {
                        System.out.println(left.add(right));
                }else if(groups[2].equals("-")) {
                        System.out.println(left.sub(right));
                }
                else if(groups[2].equals("*")) {
                        System.out.println(left.mult(right));
                }
                else if(groups[2].equals("/")){
                        System.out.println(left.div(right));
                }else{
                    System.out.println("Incorrect expression format.");
                }


            }
            //doesn't match expression pattern
            else{
                System.out.println("Incorrect expression format.");
            }
        }
    }
}
