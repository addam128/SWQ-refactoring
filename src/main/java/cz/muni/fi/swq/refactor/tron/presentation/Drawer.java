package cz.muni.fi.swq.refactor.tron.presentation;

import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
import cz.muni.fi.swq.refactor.tron.engine.presentation.ScreenManagerContract;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Implementation of DrawerContract for Tron.
 */
public class Drawer implements DrawerContract {

    private final ScreenManagerContract screenManager;

    public Drawer(ScreenManagerContract screenManager) {

        this.screenManager = screenManager;
        screenManager.setFullScreen();

        setupWindow();
    }

    private void setupWindow() {

        Window window = screenManager.getFullScreenWindow();
        window.setFont(new Font("Arial",Font.PLAIN,20));
        window.setBackground(Color.WHITE);
        window.setForeground(Color.RED);
        window.setCursor(window.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
    }

    @Override
    public void draw(List<ColoredRectangle> objects) {

        Graphics2D graphics = screenManager.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        for (ColoredRectangle rectangle: objects) {
            graphics.setColor(rectangle.getColor());
            graphics.fillRect(rectangle.getStartX(), rectangle.getStartY(), rectangle.getWidth(), rectangle.getHeight());
        }

        graphics.dispose();
        screenManager.update();
    }

    @Override
    public void restoreScreen() {
        screenManager.restoreScreen();
    }

    @Override
    public void addKeyListener(KeyListener listener) {

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(listener);
    }

    @Override
    public void addMouseListener(MouseListener listener) {

        Window window = screenManager.getFullScreenWindow();
        window.addMouseListener(listener);
    }

    @Override
    public void addMouseWheelListener(MouseWheelListener listener) {

        Window window = screenManager.getFullScreenWindow();
        window.addMouseWheelListener(listener);
    }

    @Override
    public int getScreenWidth() {
        return screenManager.getWidth();
    }

    @Override
    public int getScreenHeight() {
        return screenManager.getHeight();
    }
}
