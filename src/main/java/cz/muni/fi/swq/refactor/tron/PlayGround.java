package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.Direction;
import cz.muni.fi.swq.refactor.tron.engine.listeners.ArrowsListener;
import cz.muni.fi.swq.refactor.tron.engine.listeners.WASDListener;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;


public class PlayGround extends Core {

	int moveAmount = 5;

	private static final CollisionDetectorContract COLLISION_DETECTOR = new CollisionDetector();

	List<Player> players;
	List<Color> colors;

	public void init() {
		super.init();

		players = new ArrayList<>();
		colors = new ArrayList<>();


		colors.add(Color.green);
		colors.add(Color.red);
		players.add(new Player(40,40, sm.getWidth(), sm.getHeight(), Direction.RIGHT));
		players.add(new Player(600, 440, sm.getWidth(), sm.getHeight(), Direction.LEFT));

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(new ArrowsListener(players.get(0)));
		w.addKeyListener(new WASDListener(players.get(1)));
//		w.addMouseListener(this);
//		w.addMouseMotionListener(this);

	}

	public static void main(String[] args) {
		new PlayGround().run();
	}

	public void draw(Graphics2D g) {

		for (Player player : players) {
			player.move(moveAmount);
		}

		if (COLLISION_DETECTOR.detect(players)) {
			System.exit(0);
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
		for (int i = 0; i < players.size(); i++){
			g.setColor(colors.get(i));
			for (int r = 0; r < players.get(i).getPath().size(); r ++) {
				g.fillRect(players.get(i).getPath().get(r).getX(), players.get(i).getPath().get(r).getY(), 10, 10);
			}
		}
	}
}