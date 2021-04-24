package cz.muni.fi.swq.refactor.tron.engine.presentation;

import java.awt.*;

/**
 * @author Andrej Tomci
 */
public interface ScreenManagerContract {
    void setFullScreen(DisplayMode dm);
    Window getFullScreenWindow();
    void restoreScreen();
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void update();
}
