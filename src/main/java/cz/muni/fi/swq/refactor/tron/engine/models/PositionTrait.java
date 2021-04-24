package cz.muni.fi.swq.refactor.tron.engine.models;

public abstract class PositionTrait {

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

    protected Coordinate coords;

    protected final int maxX;
    protected final int maxY;

    public PositionTrait(
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

    public Coordinate change(int amount, Direction direction) {
        Coordinate oldCoords = coords;
        coords = computeNewCoords(amount, direction);
        return oldCoords;
    }

    protected abstract Coordinate computeNewCoords(int amount, Direction direction);
}
