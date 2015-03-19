package me.drewhoener.testing;

import me.drewhoener.testing.shapes.OrbitalShape;
import me.drewhoener.testing.shapes.RotatingShape;
import me.drewhoener.testing.shapes.ShapeHexagon;
import me.drewhoener.testing.shapes.ShapeSquare;
import me.drewhoener.testing.shapes.ShapeTriangle;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultipleRotations {

	public List<Drawable> shapeList = new ArrayList<>();
	RenderTimer renderTimer = new RenderTimer();

	public void start(){

		//First init the shapes
		this.initShapes();

		//Then Sort
		Collections.sort(this.shapeList, new Comparator<Drawable>() {
			@Override
			public int compare(Drawable o1, Drawable o2) {

				if(o1.getShape().getSideLength() > o2.getShape().getSideLength())
					return -1;
				if(o1.getShape().getSideLength() == o2.getShape().getSideLength())
					return 0;
				else
					if(o1.getShape() instanceof ShapeHexagon && o2.getShape().getSideLength() - o1.getShape().getSideLength() <= 40)
						return -1;
					else
						return 1;

			}
		});

		try{

			Display.setDisplayMode(new DisplayMode(1000, 800));
			Display.create();


		}catch(LWJGLException e){

			e.printStackTrace();
			System.exit(1);

		}

		this.setupCoordinates();
		this.renderTimer.getDelta();
		this.renderTimer.elapsedFPS = this.renderTimer.getTime();

		while(!Display.isCloseRequested()){

			this.updateRotations(this.renderTimer.getDelta());

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

			for(Drawable shape : this.shapeList)
					shape.drawShape();



			Display.update();
			Display.sync(60);

		}

		Display.destroy();
		System.exit(0);

	}

	public void updateRotations(int delta){

		for(Drawable shape : this.shapeList)
			if(shape instanceof RotatingShape)
				((RotatingShape) shape).updateRotation(delta);
			else if(shape instanceof OrbitalShape)
				((OrbitalShape) shape).getRotatingShape().updateRotation(delta);

		this.renderTimer.updateFrameCount();

	}

	public void setupCoordinates(){

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1000, 0, 800, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);


	}

	public void initShapes(){

		this.shapeList.add(new RotatingShape(new ShapeSquare(500, 400, 200, (float)Math.random(), (float)Math.random(), (float)Math.random()), .1F));
		this.shapeList.add(new RotatingShape(new ShapeTriangle(500, 400, 50, (float)Math.random(), (float)Math.random(), (float)Math.random()), .3F));
		this.shapeList.add(new RotatingShape(new ShapeTriangle(500, 400, 200, (float)Math.random(), (float)Math.random(), (float)Math.random()), -.2F));
		this.shapeList.add(new RotatingShape(new ShapeTriangle(500, 400, 150, (float)Math.random(), (float)Math.random(), (float)Math.random()), .03F));
		this.shapeList.add(new RotatingShape(new ShapeHexagon(500, 400, 160, (float)Math.random(), (float)Math.random(), (float)Math.random()), -.15F));
		this.shapeList.add(new RotatingShape(new ShapeSquare(500, 400, 320, (float)Math.random(), (float)Math.random(), (float)Math.random()), -.039F));

		this.shapeList.add(new OrbitalShape(new RotatingShape(new ShapeSquare(250, 200, 50, (float)Math.random(), (float)Math.random(), (float)Math.random()), .07F), 500, 400));
		this.shapeList.add(new OrbitalShape(new RotatingShape(new ShapeHexagon(200, 200, 20, (float)Math.random(), (float)Math.random(), (float)Math.random()), -.17F), 500, 400));


	}

	public static void main(String[] args) {


		MultipleRotations multipleRotations = new MultipleRotations();

		multipleRotations.start();

	}

}
