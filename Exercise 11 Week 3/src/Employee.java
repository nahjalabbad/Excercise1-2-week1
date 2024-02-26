public class Employee {

    private int id;
    private String  name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    public int getAnnualSalary(){
        return this.salary*12;
    }
    public  double raisedSalary( double percent){
        double oldSalary=this.salary*(percent/100);
        double newSalary=this.salary+oldSalary;
        this.salary= (int) newSalary;
        return this.salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}