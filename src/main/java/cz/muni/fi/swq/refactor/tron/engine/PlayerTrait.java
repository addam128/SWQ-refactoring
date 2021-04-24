package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerTrait {

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

    protected abstract void changeDirection(Direction newDirection);

    public List<Position.Coordinate> getPath() {
        return path;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

}
