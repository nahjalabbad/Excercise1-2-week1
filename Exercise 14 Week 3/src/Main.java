import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> rentedVehicles = new ArrayList<>();
        Vehicle cars;
        Vehicle bike;
        Vehicle truck;
        Scanner inp=new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\tVehicle Rental System");

        int input;
       do{
            System.out.println("1.Rent a Car.\n2.Rent a Bike.\n3.Rent a Truck.\n4.View Rented Vehicles.\n5.Exit.");
            System.out.println("Enter your choice: ");
            input=inp.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter Car Model: ");
                    String model=inp.next();
                    model+=inp.nextLine();
                    System.out.println("Enter Rental Days: ");
                    int days=inp.nextInt();
                    cars=new Car(model,days);
                    rentedVehicles.add(cars);
                    System.out.println();
                    System.out.println();
                    cars.displayDetails();
                    break;

                case 2:
                    System.out.println("Enter Bike Brand: ");
                    String brand= inp.nextLine();
                    brand+=inp.nextLine();
                    System.out.println("Enter Rental Hours: ");
                    int hours=inp.nextInt();
                    bike=new Bike(brand,hours);
                    rentedVehicles.add(bike);
                    System.out.println();
                    System.out.println();
                    bike.displayDetails();
                    break;

                case 3:
                    System.out.println("Enter Truck Type: ");
                    String type= inp.nextLine();
                    type+=inp.nextLine();
                    System.out.println("Enter Rental Weeks: ");
                    int week=inp.nextInt();
                    truck=new Truck(type,week);
                    rentedVehicles.add(truck);
                    System.out.println();
                    System.out.println();
                    truck.displayDetails();
                    break;

                case 4:
                    System.out.println("------------ Rented Vehicles: ------------");
                    for (Vehicle rent:rentedVehicles){
                        rent.displayDetails();
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Thank you for using the Vehicle Rental System!  ");
                    break;

                default:
                    System.out.println("Please choose a number from the menu above!");
            }
        } while (input!=5);
    }
}