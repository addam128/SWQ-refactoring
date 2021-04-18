package cz.muni.fi.swq.refactor.tron;

import java.util.List;

public class Player {

    private Position position;
    private List<Position.Coordinate> path;

    Player(
            int startX,
            int startY,
            int maxX,
            int maxY ) {

        position = new Position(startX, startY, maxX, maxY);

    }

}
