public class Main {
    public static void main(String[] args) {


        Movie mov1=new Movie("Barbie",35,"Greta Gerwig");
        Book book1=new Book("Me Before You",30,"Jojo Moyes");
        System.out.println("\t\t\t\t\t\t\t-------Product Exercise-------");
        System.out.println(mov1);
        System.out.println();
        System.out.println(book1);
        System.out.println();




        MovablePoint move=new MovablePoint(4,9,15,10);
        System.out.println("\t\t\t\t\t\t\t-------Movable Exercise-------");
        move.moveUp();
        move.moveRight();
        move.moveDown();
        move.moveLeft();
    }
}