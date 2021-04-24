package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.engine.presentation.ScreenManagerContract;
import cz.muni.fi.swq.refactor.tron.engine.presentation.ScreenManagerDefault;
import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * @author Andrej Tomci
 */
public class Engine {

    private boolean running;
    private PlayGroundContract playground;
    protected ScreenManagerContract sm;

    public Engine(PlayGroundContract playground, ScreenManagerContract screenManager) {
        this.running = false;
        this.playground = playground;
        sm = screenManager;
        sm.setFullScreen();
        Window w = sm.getFullScreenWindow();
        w.setFont(new Font("Arial",Font.PLAIN,20));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
        running = true;
    }
    public void stop(){
        running = false;
    }

    public void run(){
        try{
            gameLoop();
        }finally{
            sm.restoreScreen();
        }
    }

    public void init(){
    }

    public void addKeyListener(KeyListener listener) {
        Window w = sm.getFullScreenWindow();
        w.addKeyListener(listener);
    }
    // TODO: Mouse, mouse motion listeners

    public int getScreenWidth() {
        return sm.getWidth();
    }

    public int getScreenHeight() {
        return sm.getHeight();
    }

    public void gameLoop(){
        long startTime = System.currentTimeMillis();
        long cumTime = startTime;

        while (running){
            long timePassed = System.currentTimeMillis()-cumTime;
            cumTime+= timePassed;
            update(timePassed);
            Graphics2D g = sm.getGraphics();
            playground.gameTick();
            draw(g);
            g.dispose();
            sm.update();

            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }

    public void update(long timePassed){}

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());

        for (ColoredRectangle rectangle: playground.getGraphicObjects()) {
           g.setColor(rectangle.getColor());
           g.fillRect(rectangle.getStartX(), rectangle.getStartY(), rectangle.getWidth(), rectangle.getHeight());
        }
    }
}
