package cz.muni.fi.swq.refactor.tron.engine.presentation;

import java.awt.Graphics2D;
import java.awt.Window;

/** Interface that defines necessary methods
 *  for screen management classes
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
