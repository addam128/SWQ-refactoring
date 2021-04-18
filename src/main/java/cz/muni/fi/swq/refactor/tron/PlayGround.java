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
	int centrex1 = 40;
	int centrey1 = 40;
	int centrex2 = 600;
	int centrey2 = 440;
	Direction currentDirection1 = Direction.RIGHT;
	Direction currentDirection2 = Direction.LEFT;
	int moveAmount = 5;
	ArrayList<Integer> pathx1 = new ArrayList();
	ArrayList<Integer> pathy1 = new ArrayList();
	ArrayList<Integer> pathx2 = new ArrayList();
	ArrayList<Integer> pathy2 = new ArrayList();

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
		for (int x = 0;x<pathx1.size();x++){
			if (((centrex1 == pathx1.get(x)) && (centrey1 == pathy1.get(x))) || ((centrex2 == pathx2.get(x)) && (centrey2 == pathy2.get(x))) || ((centrex1 == pathx2.get(x)) && (centrey1 == pathy2.get(x))) || ((centrex2 == pathx1.get(x)) && (centrey2 == pathy1.get(x)))){
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
			if (currentDirection1 != Direction.DOWN){
				currentDirection1 = Direction.UP;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentDirection1 != Direction.UP){
				currentDirection1 = Direction.DOWN;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (currentDirection1 != Direction.LEFT){
				currentDirection1 = Direction.RIGHT;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (currentDirection1 != Direction.RIGHT){
				currentDirection1 = Direction.LEFT;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W){
			if (currentDirection2 != Direction.DOWN){
				currentDirection2 = Direction.UP;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (currentDirection2 != Direction.UP){
				currentDirection2 = Direction.DOWN;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (currentDirection2 != Direction.LEFT){
				currentDirection2 = Direction.RIGHT;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			if (currentDirection2 != Direction.RIGHT){
				currentDirection2 = Direction.LEFT;
			}
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