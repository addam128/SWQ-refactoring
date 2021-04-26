package cz.muni.fi.swq.refactor.tron.engine.models;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.Color;
import java.util.List;

/** Interface that defines what methods should playground classes implement
 *
 */
public interface PlayGroundContract {
    /*
     * Does one iteration og the game cycle
     */
    void gameTick();

    /*
     * Reports all the rectangles that has to be drawn with their colors.
     * Handling of these rectangles should be then implemented in the DrawerContract implementation.
     */
    List<ColoredRectangle> getGraphicObjects();


    void addPlayer(PlayerContract player, Color color);
}
