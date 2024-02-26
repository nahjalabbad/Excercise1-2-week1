import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        //Account Class
        Account acc1 = new Account("101","Nahj",5000);
        Account acc2 =new Account("102","Noun",7560);
        Account acc3 =new Account("103","Mansour",9850);

        System.out.println("\t\t\t\t\t----Displaying The Accounts:----");
        System.out.println(acc1+"\n");
        System.out.println(acc2+"\n");
        System.out.println(acc3+"\n");

        System.out.println("\nDebit to Account 1\nDepositing 650 SAR");
        acc1.debit(650);
        System.out.println("Account 1 new balance is: "+acc1.getBalance());

        System.out.println("\nCredit from Account 3\nWithdrawing 1850 SAR");
        acc3.credit(1850);
        System.out.println("Account 3 new balance is: "+acc3.getBalance());


        System.out.println("\nHello, "+acc2.getName()+" you are going to transfer to "+acc1.getName());
        System.out.println("Enter the amount of money you want to transfer: ");
        int amount= input.nextInt();
        acc2.transferTo(acc1,amount);
        System.out.println("\nAccount 3 new balance is: "+acc2.getBalance());
        System.out.println("Account 1 new balance is: "+acc1.getBalance());


    //Employee Class

        Employee emp1=new Employee(101,"Nahj",9520);
        Employee emp2=new Employee(102,"Noun",3548);
        Employee emp3=new Employee(103,"Mansour",6580);

        System.out.println("\t\t\t\t\t\n----Displaying Employees List:----");
        System.out.println(emp1+"\n");
        System.out.println(emp2+"\n");
        System.out.println(emp3+"\n");

        System.out.println("\nYou are going to raise the employee "+emp1.getName()+"\nEnter the amount of Raise: ");
        int amo= input.nextInt();
        emp1.raisedSalary(amo);
        System.out.println("Employee Salary after raising: "+emp1.getSalary());

        System.out.println("\nEmployees annual salary is: ");
        System.out.println(emp1.getName()+" annual salary is: "+emp1.getAnnualSalary());
        System.out.println(emp2.getName()+" annual salary is: "+emp2.getAnnualSalary());
        System.out.println(emp3.getName()+" annual salary is: "+emp3.getAnnualSalary());





    }
}