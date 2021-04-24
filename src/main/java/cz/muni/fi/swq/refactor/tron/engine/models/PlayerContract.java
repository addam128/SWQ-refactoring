package cz.muni.fi.swq.refactor.tron.engine.models;

import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface PlayerContract {
    void move(int amount);
    void changeDirection(Direction newDirection);
    int getX();
    int getY();
    List<PositionTrait.Coordinate> getPath();
}
