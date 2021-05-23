package nasa.rover.element.engine;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int[] point) {
        this.x = point[0];
        this.y = point[1];
    }

    public Point(String pointX, String pointY) {
        this.x = Integer.valueOf(pointX);
        this.y = Integer.valueOf(pointY);
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

    public void addOneToX() {
        this.x++;
    }

    public void removeOneToX() {
        this.x--;
    }

    public void addOneToY() {
        this.y++;
    }

    public void removeOntToY() {
        this.y--;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

}
