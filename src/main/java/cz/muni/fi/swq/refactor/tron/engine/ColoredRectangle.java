package cz.muni.fi.swq.refactor.tron.engine;

import java.awt.Color;

/**
 * @author Andrej Tomci
 */
public class ColoredRectangle {
    private final Color color;
    private final int startX;
    private final int startY;
    private final int width;
    private final int height;

    public ColoredRectangle(Color color, int startX, int startY, int width, int height) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
