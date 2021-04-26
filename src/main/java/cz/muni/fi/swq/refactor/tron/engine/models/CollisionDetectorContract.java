package cz.muni.fi.swq.refactor.tron.engine.models;

import java.util.List;

/** Interface that defines methods necessary for collision detection.
 *
 */
public interface CollisionDetectorContract {

    boolean detect(List<PlayerContract> playerList);
}
