package cz.muni.fi.swq.refactor.tron.engine.models;

import cz.muni.fi.swq.refactor.tron.Position;

import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface PlayerContract {
    void move(int amount);
    abstract void changeDirection(Direction newDirection);
    int getX();
    int getY();
}
