package me.drewhoener.testing.shapes;

import me.drewhoener.testing.Drawable;
import org.lwjgl.opengl.GL11;

public class OrbitalShape implements Drawable {

	private RotatingShape shape;
	private float centralX, centralY;

	public OrbitalShape(RotatingShape shape, float centralX, float centralY) {
		this.shape = shape;
		this.centralX = centralX;
		this.centralY = centralY;
	}

	public RotatingShape getRotatingShape(){

		return this.shape;

	}

	public Shape getShape(){

		return this.shape.getShape();

	}

	@Override
	public void drawShape() {

		GL11.glPushMatrix();

			GL11.glColor3f(this.getShape().getRedColor(), this.getShape().getGreenColor(), this.getShape().getBlueColor());

			GL11.glTranslatef(this.centralX, this.centralY, 0);
				GL11.glRotatef(this.shape.getRotation(), 0, 0, 1);
			GL11.glTranslatef(-this.centralX, -this.centralY, 0);

			this.drawPoints();

		GL11.glPopMatrix();

	}

	@Override
	public void drawPoints() {

		this.shape.drawPoints();

	}
}
