package cz.muni.fi.swq.refactor.tron.engine.presentation;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.util.List;

/** Interface that defines necessary methods for classes taking care
 *  of handling game screen and drawing objects
 *
 */
public interface DrawerContract {

    /*
     * Handle drawing the reported game state.
     */
    void draw(List<ColoredRectangle> objects);

    void restoreScreen();

    void addKeyListener(KeyListener listener);

    void addMouseListener(MouseListener listener);

    void addMouseWheelListener(MouseWheelListener listener);

    int getScreenWidth();

    int getScreenHeight();
}
