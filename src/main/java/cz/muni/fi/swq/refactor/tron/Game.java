package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.Direction;
import cz.muni.fi.swq.refactor.tron.engine.Engine;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;
import cz.muni.fi.swq.refactor.tron.engine.listeners.ArrowsListener;
import cz.muni.fi.swq.refactor.tron.engine.listeners.WASDListener;

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
        this.engine = new Engine(playground);

        PlayerTrait player1 = new Player(40,40, engine.getScreenWidth(), engine.getScreenHeight(), Direction.RIGHT);
        PlayerTrait player2 =  new Player(600, 440, engine.getScreenWidth(), engine.getScreenHeight(), Direction.LEFT);

        playground.addPlayer(player1, Color.green);
        playground.addPlayer(player2, Color.red);

        engine.addKeyListener(new ArrowsListener(player1));
        engine.addKeyListener(new WASDListener(player2));
    }

    private void run() {
        engine.run();
    }

}
