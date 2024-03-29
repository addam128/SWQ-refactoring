package cz.muni.fi.swq.refactor.tron.engine.models;

import java.util.ArrayList;
import java.util.List;

/** Abstract class partially implementing PlayerContract interface,
 *  you can extend this class to create your own Player representation.
 *
 * If you need more specific behaviour implement the PlayerContract Interface.
 */
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

    /*
     * Here implement reaction to direction change events
     */
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
