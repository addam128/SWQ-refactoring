package cz.muni.fi.swq.refactor.tron;

//import cz.muni.fi.swq.refactor.tron.engine.PositionTrait;

import java.util.List;

public class CollisionDetector {

    static boolean detect(List<Player> players) {

        return selfCollision(players) || crossCollision(players);
    }

    private static boolean selfCollision(List<Player> players) {

        for (Player player : players) {
            for (Position.Coordinate coord : player.getPath()) {

                if (player.getX() == coord.getX() && player.getY() == coord.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean crossCollision(List<Player> players) {

        for (Player playerOne: players) {
            for (Player playerTwo: players) {

                if (playerOne == playerTwo) { continue; } // reference comparison needed here

                for (Position.Coordinate coord: playerTwo.getPath()) {

                    if (playerOne.getX() == coord.getX() && playerOne.getY() == coord.getY()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
