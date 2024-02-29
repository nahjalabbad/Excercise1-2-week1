public class Bike implements Vehicle{
    private String brand;
    private int hours;

    public Bike(String brand, int hours) {
        this.brand = brand;
        this.hours = hours;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateRentalCost() {
        return hours*10;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike Model: "+getBrand());
        System.out.println("Hourly Rental Rate: 10$");
        System.out.println("Rental Cost: "+calculateRentalCost()+"$");
        System.out.println();
    }
}
