package com.therealmasel.sandyproccy;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;

public class GameMapAppletTest extends PApplet {

	//StageObject[] stageObjects;
	private WordGameContextMenu contextMenu;
	private PGraphics buffer;
	boolean showMenu;
	
	private GameMap gameMap;
	
	public void setup() {
		//menuItemsConstruction
		ArrayList<GameContextMenuItem> gameMenuItems = new
		ArrayList<GameContextMenuItem>();
		WordGameContextMenuItem item = new WordGameContextMenuItem(2, 10, 10);
		gameMenuItems.add(item);
		WordGameContextMenuItem item2 = new WordGameContextMenuItem(3, 10, 10);
		gameMenuItems.add(item2);
		contextMenu = new WordGameContextMenu(gameMenuItems);
		showMenu = false;
		size(300, 300, OPENGL);
		//colorMode(RGB, 200);
		//buffer type is P3D cause we want to use it for object picking
		buffer = createGraphics(300, 300, P3D);
		this.gameMap = new GameMap(15, 15, 17, 17);
	}
	public void mousePressed() {
		showMenu = !showMenu;
		
		/*buffer.beginDraw();
		buffer.camera(
			30, 30, 220.0f, 
			120, 120, 0.0f, 
		    1.0f, 0.0f, 0.0f
		);
		buffer.background(-1);
		buffer.noStroke();
		buffer.rotateX(PI/6);
		gameMap.drawMapBuffer(buffer);
		buffer.endDraw();
		
		int pick = buffer.get(mouseX, mouseY);
		
		int blue = (int) blue(pick);
		gameMap.setFieldSelected(blue);*/
		  
		
		
	}
	
	public void mouseMoved() {
		
		buffer.beginDraw();
		//buffer.lights();

		buffer.camera(
			30, 30, 220.0f, 
		    120, 120, 0.0f, 
		    1.0f, 0.0f, 0.0f
		);
		buffer.background(-1);
		buffer.noStroke();
		buffer.rotateX(PI/6);
		
		gameMap.drawMapBuffer(buffer);
		buffer.endDraw();
		//this.g.endDraw();
		int pick = buffer.get(mouseX, mouseY);
			//we`re getting the field id
		int blue = (int) blue(pick);
			//GameMapField field = gameMap.getField(blue);
			//gameMap.clearFieldSelection();
		gameMap.setFieldSelected(blue);
			
			/*int fieldWIndex = (blue / 20);
			int fieldHIndex = blue- fieldWIndex * 20 ;*/
						
		PApplet.println("blue is" + blue);
			//PApplet.println("pick is" + pick);
			//PApplet.println("Windex" + fieldWIndex);
			//PApplet.println("Hindex" + fieldHIndex);
		
		//println(id);
		
	}
	
	public void draw() {
		  g.lights();
    	  g.camera(30, 30, 220.0f, 
    			  120, 120, 0.0f, 
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
		  if (showMenu) {
			  
			  float x = modelX(130, 130, 0);
			  float y = modelY(130, 130, 0);
			  float z = modelZ(130, 130, 0);
			  println(x);
			  println(y);
			  println(z);
			  pushMatrix();
			  translate(x, y, z);
			  g.rotateX(PI/9);
			  contextMenu.draw(g);
			  popMatrix();
		  }
		  /*
		  float x = modelX(30, 30, 0);
		  float y = modelY(30, 30, 0);
		  float z = modelZ(30, 30, 0);
		  println(x);
		  println(y);
		  println(z);
		  */
		  //pushMatrix();
		  //translate(x, y, z);
		  //rotateX(PI/6);
		  //contextMenu.draw(g);
		  //popMatrix();
		  //g.fill(120, 120, 0);
		  g.stroke(120, 120 ,0);
		  //g.line(-100, 0, 0, 100, 0, 0);
		  //g.line(0, -100, 0, 0, 100, 0);
		  //g.line(0, 0, -100, 0, 0, 100);
	}
	
	
	
	
}
