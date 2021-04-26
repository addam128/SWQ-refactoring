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

	public ScreenManagerDefault(){

		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = e.getDefaultScreenDevice();
	}
	
	public DisplayMode[] getCompatibleDisplayModes(){
		return graphicsDevice.getDisplayModes();
	}
	
	public DisplayMode findFirstCompatibleMode(){
		
		DisplayMode[] goodModes = graphicsDevice.getDisplayModes();
		for(int x = 0; x<modes.length;x++){
			for(int y = 0;y<goodModes.length;y++){
				if(displayModesMatch(modes[x],goodModes[y])){
					return modes[x];
				}
			}
		}
		return null;
	}
	
	public DisplayMode getCurrentDM(){
		return graphicsDevice.getDisplayMode();
	}
	
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
		if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){
			return false;
		}
		if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){
			return false;
		}
		if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()){
			return false;
		}
		return true;
	}
	
	public void setFullScreen(){
		DisplayMode dm = findFirstCompatibleMode();
		JFrame f = new JFrame();
		f.setUndecorated(true);
		f.setIgnoreRepaint(true);
		f.setResizable(false);
		graphicsDevice.setFullScreenWindow(f);
		
		if(dm != null && graphicsDevice.isDisplayChangeSupported()){
			try{
				graphicsDevice.setDisplayMode(dm);
			}catch(Exception ex){}
			f.createBufferStrategy(2);
		}
	}
	
	public Graphics2D getGraphics(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			BufferStrategy bs = w.getBufferStrategy();
			return (Graphics2D)bs.getDrawGraphics();
		}
		else{
			return null;
		}
	}
	
	public void update(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			BufferStrategy bs = w.getBufferStrategy();
			if(!bs.contentsLost()){
				bs.show();
			}
		}
	}
	
	public Window getFullScreenWindow(){
		return graphicsDevice.getFullScreenWindow();
	}
	
	public int getWidth(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			return w.getWidth();
		}else{
			return 0;
		}
	}
	
	public int getHeight(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			return w.getHeight();
		}else{
			return 0;
		}
	}
	
	public void restoreScreen(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		graphicsDevice.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibaleimage(int w, int h, int t){
			Window win = graphicsDevice.getFullScreenWindow();
			if(win != null){
				GraphicsConfiguration gc = win.getGraphicsConfiguration();
				return gc.createCompatibleImage(w,h,t);
			}else{
				return null;
			}
		
		}
	
}
