package cz.muni.fi.swq.refactor.tron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PlayGround extends Core implements KeyListener, MouseListener,
		MouseMotionListener {
	
	int moveAmount = 5;

	Player playerOne;
	Player playerTwo;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		playerOne = new Player(40,40, sm.getWidth(), sm.getHeight(), Direction.RIGHT);
		playerTwo = new Player(600, 440, sm.getWidth(), sm.getHeight(), Direction.LEFT);
	}

	public static void main(String[] args) {
		new PlayGround().run();
	}

	public void draw(Graphics2D g) {
		playerOne.move(moveAmount);
		playerTwo.move(moveAmount);
		for (int x = 0;x<playerOne.getPath().size();x++){
			if (((playerOne.getX() == playerOne.getPath().get(x).getX()) && (playerOne.getY() == playerOne.getPath().get(x).getY())) ||
					((playerTwo.getX() == playerTwo.getPath().get(x).getX()) && (playerTwo.getY() == playerTwo.getPath().get(x).getY())) ||
					((playerOne.getX() == playerTwo.getPath().get(x).getX()) && (playerOne.getY() == playerTwo.getPath().get(x).getY())) ||
					((playerTwo.getX() == playerOne.getPath().get(x).getX()) && (playerTwo.getY() == playerOne.getPath().get(x).getY()))) {
				System.exit(0);
			}
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
		for (int x = 0;x<playerOne.getPath().size();x++){
			g.setColor(Color.green);
			g.fillRect(playerOne.getPath().get(x).getX(), playerOne.getPath().get(x).getY(), 10, 10);
			g.setColor(Color.red);
			g.fillRect(playerTwo.getPath().get(x).getX(), playerTwo.getPath().get(x).getY(), 10, 10);
		}
	}

	// DOWN 2
	// UP 0
	// RIGHT 1
	// LEFT 3

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			playerOne.changeDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			playerOne.changeDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerOne.changeDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerOne.changeDirection(Direction.LEFT);
		}
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