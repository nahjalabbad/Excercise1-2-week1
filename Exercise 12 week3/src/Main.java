public class Main {
    public static void main(String[] args) {

        //Testing Circle Class
        System.out.println("\t\t\t\t\t---Testing Circle Class---");
        Circle c1=new Circle("Red",true,5.0);
        System.out.println(c1+"\n");
        Circle c2=new Circle("Purple",false,1);
        System.out.println(c2+"\n");

        //Testing Setters for Circle class
        c1.setRadius(9);
        System.out.println("Setting new Radius for circle 1 \n"+c1+"\n");
        c2.setColor("Yellow");
        System.out.println("Setting new Color for circle 2 \n"+c2+"\n");



        //Testing Rectangle Class
        System.out.println("\t\t\t\t\t---Testing Rectangle Class---");
        Rectangle r1=new Rectangle("Blue",true,13,8);
        System.out.println(r1+"\n");
        Rectangle r2=new Rectangle("Cyan",false,4,6);
        System.out.println(r2+"\n");


        //Testing Setters for Rectangle class
        r2.setLength(25);
        r2.setWidth(15);
        System.out.println("Setting new width, length for Rectangle 2 \n"+r2+"\n");
        r1.setFilled(false);
        System.out.println("Setting false for Rectangle 1 \n"+r1+"\n");


        //Testing Square Class
        System.out.println("\t\t\t\t\t---Testing Square Class---");
        Square s1=new Square("black",true,5);
        System.out.println(s1+"\n");
        Square s2=new Square("Brown",false,9);
        System.out.println(s2+"\n");

        //Testing Setters for Square class
        s2.setSide(2);
        System.out.println("Setting new width, length for Square 2 \n"+s2+"\n");
        s1.setColor("White");
        System.out.println("Setting new color for Square 1 \n"+s1+"\n");

    }
}