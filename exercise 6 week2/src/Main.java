import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp =new Scanner(System.in);


//                  Exercise (Methods)

        /* 1 - Write a Java method to find the smallest number among three numbers.

        System.out.println("Input the first number: ");
        int num1= inp.nextInt();
        System.out.println("Input the Second number: ");
        int num2= inp.nextInt();
        System.out.println("Input the third number: ");
        int num3= inp.nextInt();

        compare(num1,num2,num3);

         */

/*        2 - Write a Java method that check if the entered number is
        negative or positive or zero.
        System.out.println("Enter a number: ");
        int num= inp.nextInt();
        npz(num);

 */

/*        3 - Write a Java method to check whether a string is a valid password.
        Password rules:
        A password must have at least ten characters.
        A password consists of only letters and digits.
        A password must contain at least two digits.

        System.out.println("1. A password must have at least eight characters.");
        System.out.println("2. A password consists of only letters and digits.");
        System.out.println("3. A password must contain at least two digits");
        System.out.println("Input a password (You are agreeing to the above Terms and Conditions.): ");
        String pass= inp.nextLine();


        if (check(pass)) {
            System.out.println("Password is valid: " + pass);
        } else {
            System.out.println("Password is not valid: " + pass);
        }

 */




    }


public static void compare(int num1, int num2, int num3){

        if (num1<num2&&num1<num3){
            System.out.println("The smallest value is: "+num1);
        }
        else if (num2<num1&&num2<num3){
            System.out.println("The smallest value is: "+num2);
        }
        else System.out.println("The smallest value is: "+num3);
}

public static void npz(int num){
        if (num>0){
            System.out.printf("The number \""+num+"\" is positive");
        }
        else if (num<0){
            System.out.printf("The number \""+num+"\" is negative");
        }
        else  System.out.printf("The number \""+num+"\" is zero");
}


    public static boolean check(String pass) {
        int chCount = 0;
        int numCount = 0;

        if (pass.length()<8) {
            return false;
        }

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            char checkChar = Character.toLowerCase(ch);
            if (checkChar >= 'a' && checkChar <= 'z'){
                chCount++;
            }
            else if (ch >= '0' && ch <= '9'){
                numCount++;
            }
            else {
                return false;
            }
        }
        return (chCount >= 2 && numCount >= 2);
    }


}


