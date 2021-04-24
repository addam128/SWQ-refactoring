package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.Player;

import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface CollisionDetectorContract {
    boolean detect(List<Player> playerList);
}
