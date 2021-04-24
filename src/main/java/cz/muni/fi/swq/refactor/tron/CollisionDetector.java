package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerContract;

import java.util.List;

public class CollisionDetector implements CollisionDetectorContract {

    public boolean detect(List<PlayerContract> players) {

        return selfCollision(players) || crossCollision(players);
    }

    private static boolean selfCollision(List<PlayerContract> players) {

        for (PlayerContract player : players) {
            for (Position.Coordinate coord : player.getPath()) {

                if (player.getX() == coord.getX() && player.getY() == coord.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean crossCollision(List<PlayerContract> players) {

        for (PlayerContract playerOne: players) {
            for (PlayerContract playerTwo: players) {

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
