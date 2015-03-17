package me.drewhoener.testing;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class PrimaryTest {

	public static void main(String[] args) {

		try{

			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("This is a title");

			Display.create();

		}catch(LWJGLException e){

			System.err.println("Display was not correctly created!");
			e.printStackTrace();
			System.exit(1);

		}

		while(!Display.isCloseRequested()){

			Display.update();
			Display.sync(60);

		}

		Display.destroy();
		System.exit(0);

	}

}
