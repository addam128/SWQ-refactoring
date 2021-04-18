package cz.muni.fi.swq.refactor.tron;

public class Position {

    public static class Coordinate {

        private final int x;
        private final int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Coordinate(int startX, int startY) {
            x = startX;
            y = startY;
        }
    }

    private Coordinate coords;

    private int maxX;
    private int maxY;

    public Position(
            int startX,
            int startY,
            int maxX,
            int maxY ){

        coords = new Coordinate(startX, startY);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getX() {
        return coords.getX();
    }

    public int getY() {
        return coords.getY();
    }

    Coordinate move(int amount, Direction direction) {
        // TODO : set new coords return old
        Coordinate oldCoords = coords;
        coords = new Coordinate(0, 0); // moved x,y
        return oldCoords; //dummy
    }
}
