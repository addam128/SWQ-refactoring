package cz.muni.fi.swq.refactor.tron;

public class Coordinate {

    private int x;
    private int y;

    private int maxX;
    private int maxY;

    public Coordinate(
            int startX,
            int startY,
            int maxX,
            int maxY ){

        x = startX;
        y = startY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        // TODO
    }
}
