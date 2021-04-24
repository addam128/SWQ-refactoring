package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.Direction;
import cz.muni.fi.swq.refactor.tron.engine.PlayerTrait;

public class Player extends PlayerTrait {
    Player( int startX,
            int startY,
            int maxX,
            int maxY,
            Direction direction) {

        super(new Position(startX, startY, maxX, maxY), direction);
    }

    protected void changeDirection(Direction newDirection) {

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
}
