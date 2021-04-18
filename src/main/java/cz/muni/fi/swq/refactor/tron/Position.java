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

    Coordinate change(int amount, Direction direction) {
        Coordinate oldCoords = coords;
        coords = computeNewCoords(amount, direction);
        return oldCoords;
    }

    private Coordinate computeNewCoords(int amount, Direction direction) {

        int newX = coords.getX();
        int newY = coords.getY();

        switch (direction) {
            case UP:
                newY = (newY < maxY) ? newY + amount : 0;
                break;
            case DOWN:
                newY = (newY > 0) ? newY - amount : maxY;
                break;
            case LEFT:
                newX = (newX > 0) ? newX - amount : maxX;
                break;
            case RIGHT:
                newX = (newX < maxX) ? newX + amount : 0;
                break;
        }
        return new Coordinate(newX, newY);
    }
}
