package me.drewhoener.testing.shapes;

import org.lwjgl.opengl.GL11;

public class ShapeSquare extends Shape {


	public ShapeSquare(float centerX, float centerY, double sideLength, float redColor, float greenColor, float blueColor) {
		super(centerX, centerY, sideLength, redColor, greenColor, blueColor);
	}

	@Override
	public void drawShape() {

		GL11.glPushMatrix();

			GL11.glColor3f(this.getRedColor(), this.getGreenColor(), this.getBlueColor());

			this.drawPoints();

		GL11.glPopMatrix();

	}

	public void drawPoints(){

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(this.getCenterX() - this.getSideLength() / 2, this.getCenterY() - this.getSideLength() / 2);
		GL11.glVertex2d(this.getCenterX() + this.getSideLength() / 2, this.getCenterY() - this.getSideLength() / 2);
		GL11.glVertex2d(this.getCenterX() + this.getSideLength() / 2, this.getCenterY() + this.getSideLength() / 2);
		GL11.glVertex2d(this.getCenterX() - this.getSideLength() / 2, this.getCenterY() + this.getSideLength() / 2);

		GL11.glEnd();

	}
}
