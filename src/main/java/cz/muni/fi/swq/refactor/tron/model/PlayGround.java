package cz.muni.fi.swq.refactor.tron.model;

import cz.muni.fi.swq.refactor.tron.engine.models.CollisionDetectorContract;
import cz.muni.fi.swq.refactor.tron.engine.models.ColoredRectangle;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayGroundContract;
import cz.muni.fi.swq.refactor.tron.engine.models.PlayerContract;
import cz.muni.fi.swq.refactor.tron.model.CollisionDetector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class PlayGround implements PlayGroundContract {

	private static final int MOVE_AMOUNT = 5;

	private static final CollisionDetectorContract COLLISION_DETECTOR = new CollisionDetector();

	List<PlayerContract> players;
	List<Color> colors;

	public PlayGround() {

		players = new ArrayList<>();
		colors = new ArrayList<>();
	}

	@Override
	public void addPlayer(PlayerContract player, Color color) {

		colors.add(color);
		players.add(player);
	}


	@Override
	public void gameTick() {

		for (PlayerContract player : players) {
			player.move(MOVE_AMOUNT);
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
}