package me.drewhoener.testing.shapes;

import org.lwjgl.opengl.GL11;

public class ShapeHexagon extends Shape {

	private double triSide;
	private double triHeight;
	private double halfLength;

	public ShapeHexagon(float centerX, float centerY, double sideLength, float redColor, float greenColor, float blueColor) {
		super(centerX, centerY, sideLength, redColor, greenColor, blueColor);

		this.halfLength = this.getSideLength() / 2;

		this.triSide = (this.halfLength / Math.cos((Math.PI) / 3));
		this.triHeight = (this.halfLength * Math.tan((Math.PI) / 3));
	}


	@Override
	public void drawShape() {

		GL11.glPushMatrix();

			GL11.glColor3f(this.getRedColor(), this.getGreenColor(), this.getBlueColor());

			this.drawPoints();

		GL11.glPopMatrix();

	}

	public void drawPoints(){

		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() - this.triSide, this.getCenterY());
		GL11.glVertex2d(this.getCenterX() - this.halfLength, this.getCenterY() + this.triHeight);

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() - this.halfLength, this.getCenterY() + this.triHeight);
		GL11.glVertex2d(this.getCenterX() + this.halfLength, this.getCenterY() + this.triHeight);

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() + this.halfLength, this.getCenterY() + this.triHeight);
		GL11.glVertex2d(this.getCenterX() + this.triSide, this.getCenterY());

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() + this.triSide, this.getCenterY());
		GL11.glVertex2d(this.getCenterX() + this.halfLength, this.getCenterY() - this.triHeight);

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() + this.halfLength, this.getCenterY() - this.triHeight);
		GL11.glVertex2d(this.getCenterX() - this.halfLength, this.getCenterY() - this.triHeight);

		GL11.glVertex2d(this.getCenterX(), this.getCenterY());
		GL11.glVertex2d(this.getCenterX() - this.triSide, this.getCenterY());
		GL11.glVertex2d(this.getCenterX() - this.halfLength, this.getCenterY() - this.triHeight);

		GL11.glEnd();

	}
}
