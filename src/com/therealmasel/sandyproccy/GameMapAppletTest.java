package com.therealmasel.sandyproccy;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;

public class GameMapAppletTest extends PApplet {

	//StageObject[] stageObjects;
	private WordGameContextMenu contextMenu;
	private PGraphics buffer;
	boolean showMenu;
	int activeFieldItem;
	int fixedActiveFieldItem;
	
	private GameMap gameMap;
	
	public void setup() {
		//menuItemsConstruction
		ArrayList<GameContextMenuItem> gameMenuItems = new
		ArrayList<GameContextMenuItem>();
		WordGameContextMenuItem item = new WordGameContextMenuItem(1, 40, 40);
		gameMenuItems.add(item);
		WordGameContextMenuItem item2 = new WordGameContextMenuItem(2, 40, 40);
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
		if (showMenu) {
			println("activeFieldItem" + activeFieldItem);
			if (activeFieldItem == 1) {
				println("yes" + activeFieldItem);
		    	 showMenu = false;
		     }	
		} else {
			showMenu = true;
			fixedActiveFieldItem = activeFieldItem;
		}
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
		buffer.camera(
				30, 30, 220.0f, 
			    120, 120, 0.0f, 
			    1.0f, 0.0f, 0.0f
			);
			buffer.background(-1);
			buffer.noStroke();
			buffer.rotateX(PI/6);
			
		if (!showMenu) {
			buffer.beginDraw();
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
			activeFieldItem = blue;				
			//PApplet.println("blue is" + blue);
				//PApplet.println("pick is" + pick);
				//PApplet.println("Windex" + fieldWIndex);
				//PApplet.println("Hindex" + fieldHIndex);
			
			//println(id);			
		} else {
			buffer.beginDraw();
			translate(
				  gameMap.calculateMapItemX(fixedActiveFieldItem),
				  gameMap.calculateMapItemY(fixedActiveFieldItem),
				  10
				  );
			 contextMenu.drawBuffer(buffer);
		     buffer.endDraw();
		     int pick = buffer.get(mouseX, mouseY);
		     activeFieldItem = (int) blue(pick);
		     //println("fixedActiveFieldItem: " + fixedActiveFieldItem);
		     //println("menuItem: " + activeMenuItem);
		}

		
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
		  //g.pushMatrix();
		  gameMap.drawMap(this.g);
		  //g.popMatrix();
		  if (showMenu) {
			  
			  /*float x = modelX(130, 130, 0);
			  float y = modelY(130, 130, 0);
			  float z = modelZ(130, 130, 0);
			  println(x);
			  println(y);
			  println(z);
			  pushMatrix();
			  translate(x, y, z);
			  g.rotateX(PI/9);*/
			  
			  
			  translate(
			      gameMap.calculateMapItemX(fixedActiveFieldItem),
			      gameMap.calculateMapItemY(fixedActiveFieldItem),
			      10
			  );
			  contextMenu.draw(g);
			  //popMatrix();
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
