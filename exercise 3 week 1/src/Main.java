import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);

    // EXERCISE (LOOP)


/*        1.Write a program that prints the numbers from 1 to 100 such that:
        If the number is a multiple of 3, you need to print "Fizz" instead of that
        number.
        for (int i = 1; i <=100 ; i++) {
            if(i%3==0&&i%5==0){
                System.out.println("FizzBuzz");
                continue;
            }
            if(i%3==0){
                System.out.println("Fizz");
                continue;
            }
            if(i%5==0){
                System.out.println("Buzz");
                continue;
            }

            System.out.println(i);
        }*/

//        ----------------------------------------------------------------

/*        2.Write a Java program to reverse a string.
        Test Data: Input a string: The quick brown fox Expected Output: Reverse
        string: xof nworb kciuq ehT

        System.out.println("Input a string: ");
        String word=inp.nextLine();
        String rev="";


        for (int i=word.length()-1;i>=0;i--)
        {
            rev+=word.charAt(i);
        }
        System.out.println("Reversed String: "+ rev);*/

//        ----------------------------------------------------------------


/*        3.Write a program to find the factorial value of any number entered
        through the keyboard.

        System.out.println("Enter a number ");
        int num =inp.nextInt();
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            factorial *= i;
        }
        System.out.println("Factorial of \""+ num+"\": "+ factorial);*/

//        ----------------------------------------------------------------

/*        4.Two numbers are entered through the keyboard. Write a program to find
        the value of one number raised to the power of another. (Do not use Java
        built-in method)

        System.out.println("Enter two numbers the base and the exponent: ");

        int num1 = inp.nextInt(), num2 = inp.nextInt();

        long res = 1;

        while (num2 != 0) {
            res *= num1;
            --num2;
        }

        System.out.println("The Answer is= " + res);*/

//        ----------------------------------------------------------------

/*        5.Write a program that reads a set of integers, and then prints the sum of
        the even and odd integers.
        System.out.print("Enter a set of integers: ");
        int set = inp.nextInt();

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < set; i++) {
            System.out.print("Enter an integer: ");
            int num = inp.nextInt();

            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }

        System.out.println("Sum of even integers: " + sumEven);
        System.out.println("Sum of odd integers: " + sumOdd);*/


//        ----------------------------------------------------------------

/*        6.Write a program that prompts the user to input a positive integer. It
        should then output a message indicating whether the number is a prime
        number.
        boolean prime = true;

        System.out.print("Enter a positive integer: ");
        int num = inp.nextInt();

        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                prime = false;
                break;
            }
        }
        if(prime && num > 1) {
            System.out.println("The number "+num +" is a prime number");
        }
        else {
            System.out.println("The number "+num+" is not a prime number");
        }*/


//        ----------------------------------------------------------------

/*        7.Use a for loop to print headings for four weeks (Weeks 1 - 4). Then use
        another for loop to print the days (Days 1 -7) for each week.

        for (int i = 1; i <= 4; i++) {
            System.out.println("Week "+i);
            System.out.println("");
            for (int j = 1; j <=7 ; j++) {
                System.out.println("Day "+j);
                System.out.println("");
            }

        }*/

//        ----------------------------------------------------------------

/*        8.Write a program thats check if the word is a palindrome or not. hint: A
        string is said to be a palindrome if it is the same if we start reading it from
        left to right or right to left.

        System.out.println("Enter a word");
        String word=inp.nextLine();
        String rev="";


        for (int i=word.length()-1;i>=0;i--)
        {
            rev+=word.charAt(i);

        }
        if (word.matches(rev)){
            System.out.println("The word \""+word+"\" is a palindrome");
        }
        else {
            System.out.println("The word \"" +word+ "\" is NOT a palindrome");
        }*/

    }
    }


