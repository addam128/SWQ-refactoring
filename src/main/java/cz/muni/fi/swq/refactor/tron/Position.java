package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.models.PositionTrait;

/**
 * @author Andrej Tomci
 */
public class Position extends PositionTrait {
    public Position(int startX, int startY, int maxX, int maxY) {
        super(startX, startY, maxX, maxY);
    }

    protected Coordinate computeNewCoords(int amount, Direction direction) {
        int newX = coords.getX();
        int newY = coords.getY();

        switch (direction) {
            case UP:
                newY = (newY > 0) ? newY - amount : maxY;
                break;
            case DOWN:
                newY = (newY < maxY) ? newY + amount : 0;
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
