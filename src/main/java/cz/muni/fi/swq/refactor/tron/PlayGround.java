package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.Direction;

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


public class PlayGround extends Core implements KeyListener, MouseListener,
		MouseMotionListener {

	int moveAmount = 5;

	private static final CollisionDetectorContract COLLISION_DETECTOR = new CollisionDetector();

	List<Player> players;
	List<Color> colors;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		players = new ArrayList<>();
		colors = new ArrayList<>();

		players.add(new Player(40,40, sm.getWidth(), sm.getHeight(), Direction.RIGHT));
		players.add(new Player(600, 440, sm.getWidth(), sm.getHeight(), Direction.LEFT));

		colors.add(Color.green);
		colors.add(Color.red);
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

	// DOWN 2
	// UP 0
	// RIGHT 1
	// LEFT 3

	public void keyPressed(KeyEvent e) {
		if (players.size() < 1) { return ;}
		Player playerOne = players.get(0);
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			playerOne.changeDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			playerOne.changeDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerOne.changeDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerOne.changeDirection(Direction.LEFT);
		}
		if (players.size() < 2) {return;}
		Player playerTwo = players.get(1);
		if (e.getKeyCode() == KeyEvent.VK_W){
			playerTwo.changeDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			playerTwo.changeDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			playerTwo.changeDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			playerTwo.changeDirection(Direction.LEFT);
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}