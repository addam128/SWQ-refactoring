package cz.muni.fi.swq.refactor.tron.engine.models;

import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface CollisionDetectorContract {
    boolean detect(List<PlayerContract> playerList);
}
