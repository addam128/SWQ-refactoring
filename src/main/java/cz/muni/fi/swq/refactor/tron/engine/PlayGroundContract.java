package cz.muni.fi.swq.refactor.tron.engine;

import java.util.HashMap;
import java.awt.Color;
import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface PlayGroundContract {
    void gameTick();
    List<ColoredRectangle> getGraphicObjects();
    void addPlayer(PlayerTrait player, Color color);
}
