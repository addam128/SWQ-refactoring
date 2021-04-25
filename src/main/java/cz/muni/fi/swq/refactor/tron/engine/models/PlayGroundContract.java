package cz.muni.fi.swq.refactor.tron.engine.models;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.Color;
import java.util.List;

/** Interface that defines what methods should playground classes implement
 *
 */
public interface PlayGroundContract {
    void gameTick();
    List<ColoredRectangle> getGraphicObjects();
    void addPlayer(PlayerContract player, Color color);
}
