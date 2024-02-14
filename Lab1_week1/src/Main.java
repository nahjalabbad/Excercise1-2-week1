import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);

        //Lab 1
        /*1. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of
two numbers , takes two numbers as input

        System.out.println("Enter First number: ");
        int num1= inp.nextInt();
        System.out.println("Enter Second number: ");
        int num2= inp.nextInt();

        System.out.println("Addition: "+num1+" + "+ num2 +" = "+(num1+num2));
        System.out.println("Subtract: "+num1+" - "+ num2 +" = "+(num1-num2));
        System.out.println("Multiply: "+num1+" × "+ num2 +" = "+(num1*num2));
        System.out.println("Division: "+num1+" / "+ num2 +" = "+(num1/num2));
        System.out.println("Reminder: "+num1+" mod "+ num2 +" = "+(num1%num2));

         */

/*        2. Write a Java program that takes a number as input and prints its multiplication table up to 10.
        Test Data:

        System.out.println("Enter a number: ");
        int num= inp.nextInt();
        System.out.println("The multiplication Table is: ");
        for (int i = 1; i <=10 ; i++) {
            System.out.println(num +" × "+i+" = "+ (num*i));
        }

 */


/*        3. Write a Java program to print the area and perimeter of a circle.

        System.out.println("Enter the radius: ");
        double r= inp.nextDouble();
        double PI=Math.PI;
        double perimeter= 2*PI*r;
        double area=PI*(r*r);
        System.out.println("Perimeter is= "+ perimeter);
        System.out.println("Area is= "+area);

 */


/*        4. Java program to find out the average of a set of integers
        System.out.print("Enter a set of integers: ");
        int set = inp.nextInt();

        double sum = 0;
        double avg = 0;

        for (int i = 0; i < set; i++) {
            System.out.print("Enter an integer: ");
            int num = inp.nextInt();
            sum=sum+num;
            avg=sum/set;
        }
        System.out.println("The average is: "+ avg);

 */

/*        5. Write a Java program that accepts three integers as input, adds the first two integers
        together, and then determines whether the sum is equal to the third integer.


        System.out.print("Enter the first number: ");
        int num1 = inp.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = inp.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = inp.nextInt();

        int sum= num1+num2;
        boolean equal;

        if (sum==num3){
            equal=true;
            System.out.println("The result is: "+equal);
        }
        else {
            equal=false;
            System.out.println("The result is: "+equal);
        }

 */

/*        6. Write a Java program to reverse a word.

        System.out.println("Input a word: ");
        String word=inp.nextLine();
        String rev="";


        for (int i=word.length()-1;i>=0;i--)
        {
            rev+=word.charAt(i);
        }
        System.out.println("Reversed word: "+ rev);


        System.out.println("Enter a number: ");
        int num= inp.nextInt();

        if (num%2==0){
            System.out.println("The number is Even");
        }
        else{
            System.out.println("The number is Odd");
        }

 */


/*        8 - Java program to convert the temperature in Centigrade to Fahrenheit

        System.out.println("Enter temperature in Centigrade (°C):  ");
        int cel= inp.nextInt();

        double fah=(cel*1.8)+32;

        System.out.println("Temperature in Fahrenheit is: "+fah+" °F");

 */

/*        9.Write a Java program that takes a string and a number from the user,then prints the
        character in the given index.

        System.out.println("Enter a String:  ");
        String word=inp.nextLine();

        System.out.println("Enter a number:  ");
        int num= inp.nextInt();

        if (num >= 0 && num < word.length()) {
            char cha = word.charAt(num);
            System.out.println("The letter is: "+ cha);}
        else
            System.out.println("Please enter a valid number");

 */

/*        10. Write a Java program to print the area and perimeter of a rectangle.

        System.out.println("Enter the width:  ");
        double width= inp.nextDouble();

        System.out.println("Enter the height:  ");
        double height= inp.nextDouble();

        double area=width*height;
        double per=2*(width+height);
        System.out.println("Area is "+width+" × "+height+" = "+area);
        System.out.println("Perimeter is 2 × ("+width+" + "+height+") = "+per);

 */

/*        11. Write a Java program to compare two numbers.

        System.out.println("Enter first number: ");
        int num1= inp.nextInt();
        System.out.println("Enter Second number: ");
        int num2= inp.nextInt();

        if (num1 == num2)
            System.out.println( num1+" = "+ num2);
        if (num1 != num2)
            System.out.println(num1+" != "+num2);
        if (num1 < num2)
            System.out.println( num1+ " < "+num2);
        if (num1 > num2)
            System.out.println( num1+" > "+ num2);
        if (num1 <= num2)
            System.out.println( num1+ " <= "+num2);
        if (num1 >= num2)
            System.out.println(num1+" >= "+  num2);

 */

/*        12. Write a Java program to convert seconds to hours, minutes and seconds.

        System.out.println("Input seconds: ");
        int sec=inp.nextInt();
        int min=(sec%3600)/60;
        int hours=sec/3600;
        int seconds=sec%60;
        System.out.println(hours+":"+min+":"+seconds);

 */

/*        13. Write a Java program that accepts four integers from the user and prints equal if all
        four are equal, and not equal otherwise.

        System.out.print("Enter the first number: ");
        int num1 = inp.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = inp.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = inp.nextInt();
        System.out.print("Enter the fourth number: ");
        int num4 = inp.nextInt();

        if (num1==num2&&num2==num3&&num1==num4){
            System.out.println("Numbers are Equal!");
        }
        else
        System.out.println("Numbers are not Equal!");

 */

/*        14. Write a Java program that reads an integer and check whether it is negative, zero, or
        positive.

        System.out.println("Input a number");
        int num= inp.nextInt();

        if (num>0){
            System.out.println("Number is positive");
        }
        else if (num<0){
            System.out.println("Number is negative");
        }
        else {
            System.out.println("Number is zero");
        }

 */
/*        15.Write a program to enter the numbers till the user wants and at the end it should
        display the count of positive, negative and zeros entered
        
        int pos = 0;
        int neg = 0;
        int zero=0;
        int num=0;

        do {
            System.out.print("Enter an integer or enter -1 to quit: ");
            num = inp.nextInt();
             if (num>0){
                pos++;
            }
            else if (num<0){
                neg++;
            }
            else zero++;
        }while(num!=-1);

        System.out.println(pos+ " Positives.");
        System.out.println(zero+ " Zero.");
        System.out.println(neg+ " Negatives.");

 */
 

/*        16 - Write a program that prompts the user to input an integer and then outputs the
        number with the digits reversed.

        System.out.println("Enter a number: ");
        int num= inp.nextInt();
        int rev=0;

        while (num!=0){
            int rem=num%10;
            rev=(rev*10)+rem;
            num=num/10;
        }
        System.out.println("The reversed number is: "+rev);

 */

/*        17 - Write a program to enter the numbers till the user wants and at the end the program
        should display the largest and smallest numbers entered.
        int smallest=0,largest=0;

        System.out.print("Enter an integer or enter -1 to quit: ");
        int num = inp.nextInt();
        do {
            System.out.print("Enter an integer or enter -1 to quit: ");
             num = inp.nextInt();
            if (num>largest){
                largest=num;
            }
            else if (num<smallest){
                smallest=num;
            }
            else System.out.println("Please enter a valid number");
        }while(num!=-1);

        System.out.println("The largest number is: "+ largest);
        System.out.println("The Smallest number is: "+ smallest);

 */

/*        18 - Determine and print the number of times the character ‘a’ appears in the input
        entered by the user.

        int num=0;
        System.out.println("Enter a string: ");
        String word= inp.nextLine();

        for (int i=word.length()-1;i>=0;i--) {
            if (word.charAt(i)=='a'){
                num++;
            }
        }

        System.out.println("The number of (a) is: "+num);

 */























    }
}
