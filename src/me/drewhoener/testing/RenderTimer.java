package me.drewhoener.testing;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class RenderTimer {

	public long elapsedFPS;
	private int curFPS;
	private long lastFrame;

	public long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public int getDelta(){

		long time = this.getTime();
		int delta = (int) (time - this.lastFrame);
		this.lastFrame = time;

		return delta;
	}

	public void updateFrameCount(){

		if(this.getTime() - this.elapsedFPS > 1000){
			Display.setTitle(" " + this.curFPS + " FPS");
			curFPS = 0;
			this.elapsedFPS += 1000;
		}

		curFPS++;
	}

	public int getCurFPS(){

		this.updateFrameCount();

		return this.curFPS;
	}

}
