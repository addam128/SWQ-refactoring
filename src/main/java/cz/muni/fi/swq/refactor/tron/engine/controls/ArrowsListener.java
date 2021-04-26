package cz.muni.fi.swq.refactor.tron.engine.controls;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Implementation of KeyListener that provides up-down-right-left arrows controls.
 *  This class wraps the Player implementation it controls.
 */
public class ArrowsListener implements KeyListener {

    private final PlayerTrait player;

    public ArrowsListener(PlayerTrait player) {
        this.player = player;
    }


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP){
            player.changeDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.changeDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.changeDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.changeDirection(Direction.LEFT);
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
