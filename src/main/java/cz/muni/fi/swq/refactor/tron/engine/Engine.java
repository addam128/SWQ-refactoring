package cz.muni.fi.swq.refactor.tron.engine;

import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;

/** Middleware class that connects model and presentation layers and takes care of game loop.
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

    public void run() {

        running = true;
        gameLoop();
        drawer.restoreScreen();
    }


    public void gameLoop() {

        while (running) {

            playground.gameTick();
            drawer.draw(playground.getGraphicObjects());

            try {
                Thread.sleep(20);
            } catch(Exception ignored){} // this is bad but we cant change functionality
        }
    }
}
