package cz.muni.fi.swq.refactor.tron;

import cz.muni.fi.swq.refactor.tron.engine.models.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerTrait;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class PlayGround implements PlayGroundContract {

	int moveAmount = 5;

	private static final CollisionDetectorContract COLLISION_DETECTOR = new CollisionDetector();

	List<PlayerTrait> players;
	List<Color> colors;

	public PlayGround() {
		players = new ArrayList<>();
		colors = new ArrayList<>();
	}

	@Override
	public void addPlayer(PlayerTrait player, Color color) {
		colors.add(color);
		players.add(player);
	}


	@Override
	public void gameTick() {
		for (PlayerTrait player : players) {
			player.move(moveAmount);
		}

		if (COLLISION_DETECTOR.detect(players)) {
			System.exit(0);
		}
	}

	@Override
	public List<ColoredRectangle> getGraphicObjects() {
	    List<ColoredRectangle> result = new ArrayList<>();
		for (int i = 0; i < players.size(); i++){
			for (int r = 0; r < players.get(i).getPath().size(); r ++) {
                result.add(new ColoredRectangle(colors.get(i), players.get(i).getPath().get(r).getX(),
						players.get(i).getPath().get(r).getY(), 10, 10));
			}
		}
		return result;
	}

//	public void draw(Graphics2D g) {
//
//		for (Player player : players) {
//			player.move(moveAmount);
//		}
//
//		if (COLLISION_DETECTOR.detect(players)) {
//			System.exit(0);
//		}
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
//		for (int i = 0; i < players.size(); i++){
//			g.setColor(colors.get(i));
//			for (int r = 0; r < players.get(i).getPath().size(); r ++) {
//				g.fillRect(players.get(i).getPath().get(r).getX(), players.get(i).getPath().get(r).getY(), 10, 10);
//			}
//		}
//	}
}