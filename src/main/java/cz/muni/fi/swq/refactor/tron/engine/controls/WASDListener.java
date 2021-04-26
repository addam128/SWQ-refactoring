package cz.muni.fi.swq.refactor.tron.engine.controls;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Implementation of KeyListener that provides w-s-a-d controls.
 *
 */
public class WASDListener implements KeyListener {

    private final PlayerTrait player;

    public WASDListener(PlayerTrait player) {
        this.player = player;
    }


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W){
            player.changeDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.changeDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            player.changeDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
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
