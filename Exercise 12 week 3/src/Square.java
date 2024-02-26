public class Square extends Rectangle
{

    public Square()
    {
        double side = 1.0;
    }

    public Square(double side)
    {
        super(side, side);
        side =side;
    }

    public Square(String color, boolean filled, double side)
    {
        super(color, filled,side, side);
        side =side;
    }

    public double getSide()
    {
        return super.getWidth();
    }

    public void setSide(double side)
    {
        super.setLength(side);
        super.setWidth(side);
    }

    public double getArea()
    {
        return getSide()*getSide();
    }

    public double getPerimeter()
    {
        return 4*getSide();
    }


    public String toString()
    {
        return "A Square with side = " + getSide() +"\nwhich is a subclass of " + super.toString();
    }
}