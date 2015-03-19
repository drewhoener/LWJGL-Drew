package me.drewhoener.testing;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class PrimaryTest {

	public static void main(String[] args) {

		try{

			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Title Goes Here:");

			Display.create();

			setupCanvas();



		}catch(LWJGLException e){

			System.err.println("Display was not correctly created!");
			e.printStackTrace();
			System.exit(1);

		}

		while(!Display.isCloseRequested()){

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			submitTriangles();
			Display.update();
			Display.sync(60);

		}

		Display.destroy();
		System.exit(0);

	}

	public static void setupCanvas(){

		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 640, 0, 480, 0, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

	}

	public static void submitTriangles(){

		GL11.glBegin(GL11.GL_TRIANGLES);
		glVertex2f(10, 10);
		glVertex2f(30, 10);
		glVertex2f(10, 30);
		GL11.glEnd();

	}

}
