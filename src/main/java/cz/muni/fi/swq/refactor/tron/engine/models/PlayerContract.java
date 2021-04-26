package cz.muni.fi.swq.refactor.tron.engine.models;

import java.util.List;

/** Interface that defines what methods should implement classes representing Player.
 * You might be interested in the PlayerTrait class, as it is useful for most games.
 *
 */
public interface PlayerContract {


    void move(int amount);


    void changeDirection(Direction newDirection);

    /*
     * Get the actual position
     */
    int getX();

    int getY();


    /*
     * Report the path the player has taken so far.
     */
    List<PositionTrait.Coordinate> getPath();
}
