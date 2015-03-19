package me.drewhoener.testing.shapes;

import me.drewhoener.testing.Drawable;

public abstract class Shape implements Drawable {

	private float centerX, centerY, redColor, greenColor, blueColor;
	private double sideLength;

	public Shape(float centerX, float centerY, double sideLength, float redColor, float greenColor, float blueColor){

		this.centerX = centerX;
		this.centerY = centerY;
		this.sideLength = sideLength;
		this.redColor = redColor;
		this.greenColor = greenColor;
		this.blueColor = blueColor;

	}

	public float getCenterX() {
		return centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public float getRedColor() {
		return redColor;
	}

	public float getGreenColor() {
		return greenColor;
	}

	public float getBlueColor() {
		return blueColor;
	}

	public double getSideLength() {
		return sideLength;
	}

	public double getHyp(double a, double b){

		return Math.sqrt((a * a) + (b * b));

	}

	public double getDist(double a, double a1, double b, double b1){

		return Math.sqrt(Math.pow((a1 - a), 2) + Math.pow((b1 - b), 2));

	}

	public Shape getShape(){

		return this;

	}

	@Override
	public abstract void drawShape();

	@Override
	public abstract void drawPoints();
}
