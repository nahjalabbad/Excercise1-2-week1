public class Circle extends Shape {
    private double radius;


    public Circle(){
        radius=1.0;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return "A circle with radius "+getRadius()+"\nwith Area= "+getArea()+" and Perimeter= "+getPerimeter()+"\nwhich is a subclass of "+super.toString();
    }
}
