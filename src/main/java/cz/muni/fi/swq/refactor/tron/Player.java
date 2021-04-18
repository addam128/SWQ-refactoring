package cz.muni.fi.swq.refactor.tron;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Position position;
    private Direction direction;
    private List<Position.Coordinate> path;

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

}
