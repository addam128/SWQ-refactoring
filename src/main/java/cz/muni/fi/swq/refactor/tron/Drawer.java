package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
import cz.muni.fi.swq.refactor.tron.engine.presentation.ScreenManagerContract;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Andrej Tomci
 */
public class Drawer implements DrawerContract {
    private ScreenManagerContract screenManager;

    public Drawer(ScreenManagerContract screenManager) {
        this.screenManager = screenManager;
        screenManager.setFullScreen();
        Window w = screenManager.getFullScreenWindow();
        w.setFont(new Font("Arial",Font.PLAIN,20));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
    }

    @Override
    public void draw(List<ColoredRectangle> objects) {
        Graphics2D g = screenManager.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        for (ColoredRectangle rectangle: objects) {
            g.setColor(rectangle.getColor());
            g.fillRect(rectangle.getStartX(), rectangle.getStartY(), rectangle.getWidth(), rectangle.getHeight());
        }
        g.dispose();
        screenManager.update();
    }

    @Override
    public void restoreScreen() {
        screenManager.restoreScreen();
    }

    @Override
    public void addKeyListener(KeyListener listener) {
        Window w = screenManager.getFullScreenWindow();
        w.addKeyListener(listener);
    }

    @Override
    public int getWidth() {
        return screenManager.getWidth();
    }

    @Override
    public int getHeight() {
        return screenManager.getHeight();
    }
}
