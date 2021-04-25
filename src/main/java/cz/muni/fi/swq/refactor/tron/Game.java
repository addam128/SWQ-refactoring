package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.Engine;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;
import cz.muni.fi.swq.refactor.tron.engine.listeners.ArrowsListener;
import cz.muni.fi.swq.refactor.tron.engine.listeners.WASDListener;
import cz.muni.fi.swq.refactor.tron.engine.presentation.DrawerContract;
import cz.muni.fi.swq.refactor.tron.engine.presentation.ScreenManagerDefault;

import java.awt.*;

/**
 * @author Andrej Tomci
 */
public class Game {
    private PlayGroundContract playground;
    private Engine engine;

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.run();
    }

    private void init() {
        this.playground = new PlayGround();
        DrawerContract drawer = new Drawer(new ScreenManagerDefault());
        this.engine = new Engine(playground, drawer);

        PlayerTrait player1 = new Player(40,40, drawer.getScreenWidth(), drawer.getScreenHeight(), Direction.RIGHT);
        PlayerTrait player2 =  new Player(600, 440, drawer.getScreenWidth(), drawer.getScreenHeight(), Direction.LEFT);

        playground.addPlayer(player1, Color.green);
        playground.addPlayer(player2, Color.red);

        drawer.addKeyListener(new ArrowsListener(player1));
        drawer.addKeyListener(new WASDListener(player2));
    }

    private void run() {
        engine.run();
    }

}
