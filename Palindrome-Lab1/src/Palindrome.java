import java.util.Scanner;

/**
 * Created by Curtis on 9/3/2016.
 */
public class Palindrome {

    public static void main(String[] args){

        if (args.length > 0){
            //parse command line input
            String inputString = "";
            //concatenate args into a string
            for(int i = 0; i < args.length; i++){
                inputString += args[i];
            }
            //replace spaces
            inputString = inputString.replace(" ", "");
            //check string and output results
            System.out.println(isPalindrome(inputString));

        }else{
            //ask for input
            System.out.println("Enter a potential palindrome:");
            //get input
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //replace spaces
            input = input.replace(" ", "");
            //check string and output results
            System.out.println(isPalindrome(input));
        }

    }

    public static String isPalindrome(String string){
        int rightHandCounter = string.length() - 1;
        for(int i = 0; i < string.length(); i++){
             if(string.charAt(i) == (string.charAt(rightHandCounter))){
                 rightHandCounter--;
             } else{
                 return "Is not a Palindrome!";
             }
        }
        return "Is a Palindrome!";
    }
}
