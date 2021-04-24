package cz.muni.fi.swq.refactor.tron.engine.models;

import cz.muni.fi.swq.refactor.tron.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerTrait implements PlayerContract {

    protected final PositionTrait position;
    protected Direction direction;
    protected final List<PositionTrait.Coordinate> path;

    protected PlayerTrait(PositionTrait position, Direction direction) {

        this.position = position;
        this.direction = direction;
        path = new ArrayList<>();
    }

    public void move(int amount) {
        path.add(position.change(amount, direction));
    }

    public abstract void changeDirection(Direction newDirection);

    public List<PositionTrait.Coordinate> getPath() {
        return path;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

}
