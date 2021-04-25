package cz.muni.fi.swq.refactor.tron.engine.presentation;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;

import java.awt.event.KeyListener;
import java.util.List;

/**
 * @author Andrej Tomci
 */
public interface DrawerContract {
    void draw(List<ColoredRectangle> objects);
    void restoreScreen();
    void addKeyListener(KeyListener listener);
    int getWidth();
    int getHeight();
}
