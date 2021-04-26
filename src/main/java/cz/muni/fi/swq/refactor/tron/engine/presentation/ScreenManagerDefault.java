package cz.muni.fi.swq.refactor.tron.engine.presentation;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

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

		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = e.getDefaultScreenDevice();
	}
	
	public DisplayMode[] getCompatibleDisplayModes(){
		return graphicsDevice.getDisplayModes();
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
	
	public DisplayMode getCurrentDM(){
		return graphicsDevice.getDisplayMode();
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

		DisplayMode dm = findFirstCompatibleMode();

		graphicsDevice.setFullScreenWindow(createFrame());
		
		if(dm != null && graphicsDevice.isDisplayChangeSupported()) {

			try {
				graphicsDevice.setDisplayMode(dm);
			} catch(Exception ignored) {

			}
			f.createBufferStrategy(2);
		}
	}
	
	public Graphics2D getGraphics() {

		Window w = graphicsDevice.getFullScreenWindow();

		if (w != null) {
			BufferStrategy bs = w.getBufferStrategy();
			return (Graphics2D)bs.getDrawGraphics();
		}
		return null;
	}
	
	public void update() {

		Window w = graphicsDevice.getFullScreenWindow();
		if (w != null) {
			BufferStrategy bs = w.getBufferStrategy();
			if (!bs.contentsLost()) {
				bs.show();
			}
		}
	}
	
	public Window getFullScreenWindow() {

		return graphicsDevice.getFullScreenWindow();
	}
	
	public int getWidth() {

		Window w = graphicsDevice.getFullScreenWindow();
		if (w != null) {
			return w.getWidth();
		}
		return 0;
	}
	
	public int getHeight() {

		Window w = graphicsDevice.getFullScreenWindow();

		if (w != null) {
			return w.getHeight();
		}
		return 0;
	}
	
	public void restoreScreen() {

		Window w = graphicsDevice.getFullScreenWindow();
		if (w != null) {
			w.dispose();
		}
		graphicsDevice.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibaleimage(int w, int h, int t) {

			Window win = graphicsDevice.getFullScreenWindow();

			if (win != null) {
				GraphicsConfiguration gc = win.getGraphicsConfiguration();
				return gc.createCompatibleImage(w,h,t);
			}
			return null;
		
		}
	
}
