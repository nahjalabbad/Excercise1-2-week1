import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);


        // EXERCISE (JAVA BASICS)

/*        1. Develop a program that takes the weight (in kilograms) and height (in meters) as
      input and calculates the BMI, then prints it.
        System.out.println("Enter your Weight in KG:");
        int weight=inp.nextInt();

        System.out.println("Enter your Height in meters:");
        double height=inp.nextDouble();
        double BMI= weight/(height*height);
        System.out.println("BMI ="+ BMI);*/



/*      2. Write a program that takes the obtained marks and total marks as input and
calculates the percentage, then prints it.
        System.out.println("Enter your obtained marks:");
        double obtained=inp.nextDouble();

        System.out.println("Enter your obtained marks:");
        double total=inp.nextDouble();

        double per = (obtained / total) * 100;

        System.out.println("Percentage = "+ per + " %");*/



/* 3. Create a program that takes an amount in one currency and an exchange rate as
input, then converts and prints the amount in another currency.
        System.out.println("Enter amount in one currency:");
        double curr=inp.nextDouble();

        System.out.println("Enter Exchange rate:");
        double exch=inp.nextDouble();

        double newcurr = (curr * exch);

        System.out.println("Enter the name of the second currency:");
        String name=inp.next();

        System.out.println("Amount in "+ name + " =" +newcurr );*/



/*4. Create a program that takes a string as input, calculates its length, and then reverses
the string using the StringBuilder class, finally printing both the length and reversed
string.
        System.out.print("Enter a Sentence: ");
        String input = inp.nextLine();

        int length = input.length();

        StringBuilder reversed = new StringBuilder(input).reverse();

        System.out.println("Length of the string: " + length+ " And Reversed string: " + reversed);*/



/* 5. Develop a program that takes a sentence as input and extracts a substring from it,
then prints the extracted substring.
        System.out.print("Enter a Sentence: ");
        String sentence = inp.nextLine();

        System.out.print("Enter the Start Index: ");
        int startIn = inp.nextInt();

        System.out.print("Enter the End Index: ");
        int endIn = inp.nextInt();

        String extracted = sentence.substring(startIn, endIn );
        System.out.println("Extracted substring: \"" + extracted + "\"");*/



/*        6. Write a program that takes a sentence and a keyword as input, then check if the
        keyword is present in the sentence and prints the result.

        System.out.print("Enter a Sentence: ");
        String sentence = inp.nextLine();

        System.out.print("Enter the Keyword: ");
        String keyword = inp.nextLine();

        boolean kwm = sentence.contains(keyword);
        System.out.println("Keyword \""+keyword+"\" is present in the sentence.");*/


/*7. Develop a program that takes a sentence and a word to replace as input, then
replace all occurrences of the word with another word and prints the modified
sentence.

        System.out.print("Enter a Sentence: ");
        String sentence = inp.nextLine();

        System.out.print("Enter the Word to replace: ");
        String replace = inp.nextLine();

        System.out.print("Enter the Replacment word: ");
        String replacment = inp.nextLine();

        System.out.println("\""+ sentence.replace(replace, replacment)+"\"");*/


/*        8. Write a program that takes two strings as input and check if they are equal, ignoring
        the case, then prints whether they are equal or not.

        System.out.print("Enter the first string: ");
        String string1 = inp.nextLine();

        System.out.print("Enter the second string: ");
        String string2 = inp.nextLine();

        boolean areEqual = string1.equalsIgnoreCase(string2);

        if (areEqual) {
            System.out.println("Strings are equal (ignoring case).");
        } else {
            System.out.println("Strings are not equal.");} */


        // EXCERCISE (CONDITIONAL)

/*        1.Write a program that checks the role of the user

        System.out.print("Enter the user role (admin/superuser/user): ");
        String userRole = inp.nextLine().toLowerCase();

        if (userRole.equals("admin")) {
            System.out.println("Welcome Admin");
        } else if (userRole.equals("superuser")) {
            System.out.println("Welcome Superuser");
        } else if (userRole.equals("user")) {
            System.out.println("Welcome User");
        } else {
            System.out.println("Invalid Input! Please enter either admin, superuser, or user.");
        }*/

/*        2.Take three numbers from the user and print the greatest number.

        System.out.print("Enter the first number: ");
         int num1 = inp.nextInt();

        System.out.print("Enter the seconed number: ");
        int num2 = inp.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = inp.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println("All three numbers are equal.");}
        else if (num1 >= num2 && num1 >=num3){
            System.out.println("The Greatest: " + num1);}
        else if (num2 >= num1 && num2 >= num3){
                System.out.println("The Greatest: " + num2);}
            else {
                System.out.println("The Greatest: " + num3);}*/


/*        3.Write a Java program that generates an integer between 1 and 7 and
        displays the name of the weekday.

        System.out.print("Enter a number from 1 to 7: ");
        int num = inp.nextInt();

        switch (num){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Please enter a valid number from 1 to 7");
        }*/
/*
4. Write a program that takes a numeric score as input and prints the
corresponding letter grade using the following grading scale:
A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: 0-59

        System.out.print("Enter your numeric score: ");
        int score = inp.nextInt();
        int scoreRange = (int) (score / 10);

        char letterGrade;

        switch (scoreRange) {
            case 9:
                letterGrade = 'A';
                break;
            case 8:
                letterGrade = 'B';
                break;
            case 7:
                letterGrade = 'C';
                break;
            case 6:
                letterGrade = 'D';
                break;
            default:
                letterGrade = 'F';
                break;
        }

        System.out.println("Numeric Score: " + score);
        System.out.println("Letter Grade: " + letterGrade);*/

/*        5. Write a Java program that takes a person's age as input and
        categorizes them into one of three age categories: "Child,"
        "Teenager," or "Adult" using an if statement.

        System.out.print("Enter your age: ");
        int age = inp.nextInt();

        if (age < 13) {
            System.out.println("You are a Child.");
        } else if (age >= 13 && age <= 19) {
            System.out.println("You are a Teenager.");
        } else {
            System.out.println("You are an Adult.");
        }*/

    }
}
