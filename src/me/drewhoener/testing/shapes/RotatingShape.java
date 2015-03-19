package me.drewhoener.testing.shapes;

import me.drewhoener.testing.Drawable;
import org.lwjgl.opengl.GL11;

public class RotatingShape implements Drawable {

	private Shape shape;
	private float rotation, rotationConstant;
	public boolean shouldRotate = true;

	public RotatingShape(Shape shape, float rotationConstant){

		this.shape = shape;
		this.rotation = 0;
		this.rotationConstant = rotationConstant;

	}

	public Shape getShape(){

		return this.shape.getShape();

	}

	public float getRotation() {
		return rotation;
	}

	public boolean shouldRotate() {
		return shouldRotate;
	}

	public float getRotationConstant() {
		return rotationConstant;
	}

	public void updateRotation(int delta){

		if(this.shouldRotate)
			this.rotation += this.rotationConstant * delta;

	}

	public void drawShape(){

		GL11.glPushMatrix();

			GL11.glColor3f(this.shape.getRedColor(), this.shape.getGreenColor(), this.shape.getBlueColor());

			GL11.glTranslatef(this.shape.getCenterX(), this.shape.getCenterY(), 0);
			GL11.glRotatef(this.getRotation(), 0, 0, 1);
			GL11.glTranslatef(-this.shape.getCenterX(), -this.shape.getCenterY(), 0);

			this.shape.drawPoints();

		GL11.glPopMatrix();

	}

	public void drawPoints(){

		this.shape.drawPoints();

	}
}
