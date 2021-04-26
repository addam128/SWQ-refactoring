package cz.muni.fi.swq.refactor.tron.engine.presentation;


import javax.swing.JFrame;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.image.BufferStrategy;

/** Class that takes care of screen management.
 * You can directly use this class, or extend if needed.
 *
 * For unique screen managers, you should implement your own
 * based on ScreenManagerContract.
 */
public class ScreenManagerDefault implements ScreenManagerContract {

	private static final DisplayMode[] modes =
			{
					//new DisplayMode(1920,1080,32,0),
					new DisplayMode(1680,1050,32,0),
					//new DisplayMode(1280,1024,32,0),
					new DisplayMode(800,600,32,0),
					new DisplayMode(800,600,24,0),
					new DisplayMode(800,600,16,0),
					new DisplayMode(640,480,32,0),
					new DisplayMode(640,480,24,0),
					new DisplayMode(640,480,16,0),
			};
	private final GraphicsDevice graphicsDevice;

	public ScreenManagerDefault() {

		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = environment.getDefaultScreenDevice();
	}

	public DisplayMode findFirstCompatibleMode() {
		
		DisplayMode[] goodModes = graphicsDevice.getDisplayModes();
		for (DisplayMode mode : modes) {
			for (DisplayMode goodMode : goodModes) {
				if (displayModesMatch(mode, goodMode)) {
					return mode;
				}
			}
		}
		return null;
	}

	public boolean displayModesMatch(DisplayMode modeOne, DisplayMode modeTwo) {

		if (modeOne.getWidth() != modeTwo.getWidth() || modeOne.getHeight() != modeTwo.getHeight()) {
			return false;
		}

		if (modeOne.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
				modeTwo.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
				modeOne.getBitDepth() != modeTwo.getBitDepth()) {
			return false;
		}

		return modeOne.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN ||
				modeTwo.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN ||
				modeOne.getRefreshRate() == modeTwo.getRefreshRate();
	}

	private JFrame createFrame() {

		JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIgnoreRepaint(true);
		frame.setResizable(false);

		return frame;
	}
	
	public void setFullScreen() {

		DisplayMode displayMode = findFirstCompatibleMode();
		JFrame frame = createFrame();
		graphicsDevice.setFullScreenWindow(frame);
		
		if(displayMode != null && graphicsDevice.isDisplayChangeSupported()) {

			try {
				graphicsDevice.setDisplayMode(displayMode);
			} catch(Exception ignored) {

			}
			frame.createBufferStrategy(2);
		}
	}
	
	public Graphics2D getGraphics() {

		Window window = graphicsDevice.getFullScreenWindow();

		if (window != null) {
			BufferStrategy bufferStrat = window.getBufferStrategy();
			return (Graphics2D)bufferStrat.getDrawGraphics();
		}
		return null;
	}
	
	public void update() {

		Window window = graphicsDevice.getFullScreenWindow();
		if (window != null) {
			BufferStrategy bufferStrat = window.getBufferStrategy();
			if (!bufferStrat.contentsLost()) {
				bufferStrat.show();
			}
		}
	}
	
	public Window getFullScreenWindow() {

		return graphicsDevice.getFullScreenWindow();
	}
	
	public int getWidth() {

		Window window = graphicsDevice.getFullScreenWindow();
		if (window != null) {
			return window.getWidth();
		}
		return 0;
	}
	
	public int getHeight() {

		Window window = graphicsDevice.getFullScreenWindow();

		if (window != null) {
			return window.getHeight();
		}
		return 0;
	}
	
	public void restoreScreen() {

		Window window = graphicsDevice.getFullScreenWindow();
		if (window != null) {
			window.dispose();
		}
		graphicsDevice.setFullScreenWindow(null);
	}

}
