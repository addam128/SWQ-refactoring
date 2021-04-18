package cz.muni.fi.swq.refactor.tron;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Position position;
    private Direction direction;
    private final List<Position.Coordinate> path;

    Player(
            int startX,
            int startY,
            int maxX,
            int maxY,
            Direction direction) {

        position = new Position(startX, startY, maxX, maxY);
        this.direction = direction;
        path = new ArrayList<>();
    }

    Position.Coordinate move(int amount) {
        return position.move(amount, direction);
    }

    void changeDirection(Direction newDirection) {

        if (direction == Direction.UP && newDirection == Direction.DOWN ||
                newDirection == Direction.UP && direction == Direction.DOWN) {
            return;
        }
        if (direction == Direction.LEFT && newDirection == Direction.RIGHT ||
                newDirection == Direction.LEFT && direction == Direction.RIGHT) {
            return;
        }

        direction = newDirection;
    }

    List<Position.Coordinate> getPath() {
        return path;
    }

}
