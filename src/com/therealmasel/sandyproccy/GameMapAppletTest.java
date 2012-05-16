package com.therealmasel.sandyproccy;

import processing.core.PApplet;
import processing.core.PGraphics;

public class GameMapAppletTest extends PApplet {

	//StageObject[] stageObjects;
	
	PGraphics buffer;
	
	private GameMap gameMap;
	
	public void setup() {
		size(300, 300, P3D);
		//colorMode(RGB, 200);
		//buffer type is P3D cause we want to use it for object picking
		buffer = createGraphics(300, 300, P3D);
		this.gameMap = new GameMap(10, 10, 17, 17);
	}
	
	public void mouseClicked() {
		
		
		buffer.beginDraw();
		//buffer.lights();

		
		buffer.camera(10, 10, 220.0f, 
		         70, 70, 0.0f, 
		         1.0f, 0.0f, 0.0f);
		buffer.background(-1);
		buffer.noStroke();
		buffer.rotateX(PI/6);
		  
			gameMap.drawMapBuffer(buffer);
			buffer.endDraw();
		//this.g.endDraw();
			int pick = buffer.get(mouseX, mouseY);
			int red = (int) red(pick);
			int green = (int) green(pick);
			int blue = (int) blue(pick);
			//int fieldWIndex = (pick / 10);
			//int fieldHIndex = pick - fieldWIndex;
			PApplet.println("red is" + red);
			PApplet.println("green is" + green);
			PApplet.println("blue is" + blue);
			PApplet.println("pick is" + pick);
			//PApplet.println("Windex" + fieldWIndex);
			//PApplet.println("Hindex" + fieldHIndex);
		
		//println(id);
		
	}
	
	public void draw() {
		  g.lights();
    	  g.camera(10, 10, 220.0f, 
		         70, 70, 0.0f, 
		         1.0f, 0.0f, 0.0f);
    	  /*
    	  float cameraY = (float) (height/2.0);
    	  float fov = mouseX/ (float)width * PI/2;
    	  float cameraZ = cameraY / tan((float) (fov / 2.0));
    	  float aspect = (float) width/(float)height;
    	  if (mousePressed) {
    	    aspect = (float) (aspect / 2.0);
    	  }
    	  perspective(fov, aspect, (float)(cameraZ/10.0), (float)(cameraZ*10.0));
    	  */
		  g.background(-1);
		  g.noStroke();
		  g.rotateX(PI/6);
		  gameMap.drawMap(this.g);
		  g.stroke(255);
		  g.line(-100, 0, 0, 100, 0, 0);
		  g.line(0, -100, 0, 0, 100, 0);
		  g.line(0, 0, -100, 0, 0, 100);
	}
	
	
	
	
}
