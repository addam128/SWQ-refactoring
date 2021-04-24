package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.PlayerTrait;

import java.util.List;

public class CollisionDetector implements CollisionDetectorContract {

    public boolean detect(List<PlayerTrait> players) {

        return selfCollision(players) || crossCollision(players);
    }

    private static boolean selfCollision(List<PlayerTrait> players) {

        for (PlayerTrait player : players) {
            for (Position.Coordinate coord : player.getPath()) {

                if (player.getX() == coord.getX() && player.getY() == coord.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean crossCollision(List<PlayerTrait> players) {

        for (PlayerTrait playerOne: players) {
            for (PlayerTrait playerTwo: players) {

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
