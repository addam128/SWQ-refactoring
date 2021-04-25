package cz.muni.fi.swq.refactor.tron.model;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * @author Andrej Tomci
 */
public class MouseListener implements java.awt.event.MouseListener, java.awt.event.MouseWheelListener  {
    private final PlayerTrait player;

    public MouseListener(PlayerTrait player) {
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if ((e.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) == InputEvent.BUTTON3_DOWN_MASK) {
            player.changeDirection(Direction.RIGHT);
        }
        if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK) {
            player.changeDirection(Direction.LEFT);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            player.changeDirection(Direction.UP);
        } else {
            player.changeDirection(Direction.DOWN);
        }
    }
}
