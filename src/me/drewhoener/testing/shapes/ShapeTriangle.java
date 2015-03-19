package me.drewhoener.testing.shapes;

import org.lwjgl.opengl.GL11;

public class ShapeTriangle extends Shape {

	private double centerSide;

	public ShapeTriangle(float centerX, float centerY, double sideLength, float redColor, float greenColor, float blueColor) {
		super(centerX, centerY, sideLength, redColor, greenColor, blueColor);

		this.centerSide = ((this.getSideLength() / 2) * (Math.tan((Math.PI) / 6)));
	}


	@Override
	public void drawShape() {

		GL11.glPushMatrix();

			GL11.glColor3f(this.getRedColor(), this.getGreenColor(), this.getBlueColor());


		GL11.glPopMatrix();
		
	}

	public void drawPoints(){

		GL11.glBegin(GL11.GL_TRIANGLES);

			GL11.glVertex2d(this.getCenterX(), this.getCenterY() + this.getHyp(this.getSideLength() / 2, this.centerSide));
			GL11.glVertex2d(this.getCenterX() - this.getSideLength() / 2, this.getCenterY() - this.centerSide);
			GL11.glVertex2d(this.getCenterX() + this.getSideLength() / 2, this.getCenterY() - this.centerSide);

		GL11.glEnd();

	}
}
