package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.Drawer;
import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
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
    private DrawerContract drawer;

    public Engine(PlayGroundContract playground, DrawerContract drawer) {
        this.running = false;
        this.playground = playground;
        this.drawer = drawer;
        running = true;
    }
    public void stop(){
        running = false;
    }

    public void run(){
        try{
            gameLoop();
        }finally{
            drawer.restoreScreen();
        }
    }

    public void init(){
    }

    // TODO: Mouse, mouse motion listeners

    public void gameLoop(){
        long startTime = System.currentTimeMillis();
        long cumTime = startTime;

        while (running){
            long timePassed = System.currentTimeMillis()-cumTime;
            cumTime+= timePassed;
            update(timePassed);
            playground.gameTick();
            drawer.draw(playground.getGraphicObjects());

            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }

    public void update(long timePassed){}
}
