import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



//                                              Exercise 5 ARRAY




/*        1.Write a Java program to test if the first and the last element of an array of
        integers are same. The length of the array must be greater than or equal to 2

        int[] numbers={50,-20,0,30,40,60,10};
        boolean equal=false;
        if (numbers.length>=2 && numbers[0]==numbers[numbers.length-1]){
            equal=true;
            System.out.println(equal);
        }
        else
            System.out.println(equal);

 */

//-------------------------------------------------------------------------------------------------------------


/*        2.Write a Java program to find the numbers greater than the average of the
        numbers of a given array.

        double sum=0,avg=0;
        int [] number={1,4,17,7,25,3,100};
        ArrayList<Integer> newnum=new ArrayList<Integer>();
        for (int num: number) {
            sum=sum+num;
            }

        avg=sum /number.length;

        for (int n = 0; n < number.length; n++) {
            if (avg<number[n]){
                newnum.add(number[n]);
            }

        }

        System.out.println("The average of the said array is: "+ avg);
        System.out.println("The numbers in the said array that are greater than the average are: "+newnum);

 */


//-------------------------------------------------------------------------------------------------------------


/*        3.Write a Java program to get the larger value between first and last
        element of an array of integers.

        int[] numbers={20,30,40,90};
        int larger=0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[0]<numbers[numbers.length-1]){
                larger=numbers[i];
            }
        }
        System.out.println("Larger value between first and last element: "+larger);

 */

//-------------------------------------------------------------------------------------------------------------


/*        4.Write a Java program to swap the first and last elements of an array and
        create a new array.
        ArrayList<Integer> orgArray=new ArrayList<Integer>();
        ArrayList<Integer> newArray=new ArrayList<Integer>();
        orgArray.add(20);
        orgArray.add(30);
        orgArray.add(40);

        newArray.add(0, orgArray.get(2));
        newArray.add(1,orgArray.get(1));
        newArray.add(2,orgArray.get(0));
        System.out.println("New array after swapping the first and last elements: "+newArray);

 */

//-------------------------------------------------------------------------------------------------------------


/*        5. Write a program that places the odd elements of an array before the
        even elements.
        int[] numbers={2,3,40,1,5,9,4,10,7};
        int i = 0;
        int temp=0;

        for (int j = i; j < numbers.length; j++) {
            if (numbers[j] % 2 != 0) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
            }
        }

        System.out.println("New Array: " + Arrays.toString(numbers));

 */

//-------------------------------------------------------------------------------------------------------------


/*        6. Write a program that test the equality of two arrays. [2,3,6,6,4] [2,3,6,6,4]

        ArrayList arr1=new ArrayList<>();
        ArrayList arr2=new ArrayList<>();
        boolean equal = true;

        arr1.add(2);
        arr1.add(3);
        arr1.add(6);
        arr1.add(6);
        arr1.add(4);

        arr2.add(2);
        arr2.add(3);
        arr2.add(6);
        arr2.add(6);
        arr2.add(4);


        if (arr1.size() == arr2.size()) {

            for (int i = 0; i < arr1.size(); i++) {
                if (arr1.get(i) != arr2.get(i) ) {
                    equal = false;
                }
            }
        }
        else {
            equal= false;
        }

        if (equal) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }

 */







    }

                }
