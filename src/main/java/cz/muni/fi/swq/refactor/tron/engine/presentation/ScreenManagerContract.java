package cz.muni.fi.swq.refactor.tron.engine.presentation;

import java.awt.*;

/** Interface that defines necessary methods for screen management classes
 *
 */
public interface ScreenManagerContract {
    void setFullScreen();
    Window getFullScreenWindow();
    void restoreScreen();
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void update();
}
