package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;

/** Middleware class that combines model and presentation layers and takes care of game loop.
 *
 */
public class Engine {

    private boolean running;
    private final PlayGroundContract playground;
    private final DrawerContract drawer;

    public Engine(PlayGroundContract playground, DrawerContract drawer) {

        this.running = false;
        this.playground = playground;
        this.drawer = drawer;
    }

    public void stop(){
        running = false;
    }

    public void run() {

        try {
            running = true;
            gameLoop();
        } finally {
            drawer.restoreScreen();
        }
    }

    public void init(){
        running = true;
    }


    public void gameLoop() {

        long cumTime = System.currentTimeMillis();

        while (running) {
            cumTime = System.currentTimeMillis();
            playground.gameTick();
            drawer.draw(playground.getGraphicObjects());

            try {
                Thread.sleep(20);
            } catch(Exception ignored){} // this is bad but we cant change functionality
        }
    }

    public void update(long timePassed){}
}
