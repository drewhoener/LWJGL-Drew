package me.drewhoener.testing;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class QuadRotation {

	public RenderTimer timer = new RenderTimer();

	public int quadX = 400, quadY = 300;
	public float rotation = 0;
	private double halfLength = 50;
	private double centerSide = (50 * (Math.tan((Math.PI) / 6)));

	public double getHyp(double a, double b){

		return Math.sqrt((a * a) + (b * b));

	}

	public static void main(String[] args) {

		QuadRotation quadRotation = new QuadRotation();

		quadRotation.start();

	}

	public double getDist(double a, double a1, double b, double b1){

		return Math.sqrt(Math.pow((a1 - a), 2) + Math.pow((b1 - b), 2));

	}

	public void start(){

		try{

			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();

		}catch(LWJGLException e){

			e.printStackTrace();
			System.exit(1);

		}

		System.out.println(getDist(this.quadX, this.quadX - this.halfLength, this.quadY + this.getHyp(this.halfLength, this.centerSide), this.quadY - this.centerSide));

		this.setupCoordinates();
		this.timer.getDelta();
		this.timer.elapsedFPS = this.timer.getTime();

		while(!Display.isCloseRequested()){

			this.updateQuad(this.timer.getDelta());
			this.drawQuads();

			Display.update();
			Display.sync(60);
		}

		Display.destroy();
		System.exit(0);


	}

	public void updateQuad(int delta){

		this.rotation += 0.15f * delta;
		this.timer.updateFrameCount();

	}

	public void drawQuads(){

		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		GL11.glColor3f(.5F, .5F, 1.0F);

		GL11.glPushMatrix();

			GL11.glTranslatef(this.quadX, this.quadY, 0);//Moves The origin to the center of the square
			GL11.glRotatef(this.rotation, 0, 0, 1);
			GL11.glTranslatef(-this.quadX, -this.quadY, 0);//Puts the origin back at the origin for someone else to use

			GL11.glBegin(GL11.GL_POINTS);

				GL11.glVertex2i(400, 300);

			GL11.glEnd();

			GL11.glBegin(GL11.GL_TRIANGLES);

			GL11.glVertex2d(this.quadX, this.quadY + this.getHyp(this.halfLength, this.centerSide));
			GL11.glVertex2d(this.quadX - this.halfLength, this.quadY - this.centerSide);
			GL11.glVertex2d(this.quadX + this.halfLength, this.quadY - this.centerSide);

			GL11.glEnd();

		GL11.glPopMatrix();



	}

	public void setupCoordinates(){

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

	}

}
