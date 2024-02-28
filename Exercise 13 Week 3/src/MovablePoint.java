public class MovablePoint implements Movable{
    private int x,y,xSpeed,ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
       int up= (y-=ySpeed);
        System.out.println("\nThe unit has moved "+up+" UP with speed of "+ySpeed);
    }

    @Override
    public void moveDown() {
        int down= (y+=ySpeed);
        System.out.println("\nThe unit has moved "+down+" Down with speed of "+ySpeed);
    }

    @Override
    public void moveLeft() {
        int left= (x-=xSpeed);
        System.out.println("\nThe unit has moved "+left+" to the left with speed of "+xSpeed);
    }

    @Override
    public void moveRight() {
        int right= (x+=xSpeed);
        System.out.println("\nThe unit has moved "+right+" to the right with speed of "+xSpeed);
    }

}
