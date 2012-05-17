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
		buffer.beginDraw();
		buffer.camera(
				30, 30, 220.0f, 
			    120, 120, 0.0f, 
			    1.0f, 0.0f, 0.0f
			);
			buffer.background(-1);
			buffer.noStroke();
			buffer.rotateX(PI/6);
			
		if (!showMenu) {
			
			gameMap.drawMapBuffer(buffer);
			buffer.endDraw();
			//this.g.endDraw();
			int pick = buffer.get(mouseX, mouseY);
				//we`re getting the field id
			int blue = (int) blue(pick);
			
			gameMap.setFieldSelected(blue);
				
			
			activeFieldItem = blue;				
			
		} else {
			
			buffer.translate(
				 gameMap.calculateMapItemX(fixedActiveFieldItem),
				 gameMap.calculateMapItemY(fixedActiveFieldItem),
			     10
			 );
			 contextMenu.drawBuffer(buffer);
		     buffer.endDraw();
		     int pick = buffer.get(mouseX, mouseY);
		     activeFieldItem = (int) blue(pick);
		   
		}

		
	}
	
	public void draw() {
		  g.lights();
    	  g.camera(30, 30, 220.0f, 
    			  120, 120, 0.0f, 
		         1.0f, 0.0f, 0.0f);
    	  
		  g.background(-1);
		  g.noStroke();
		  g.rotateX(PI/6);
		 
		  gameMap.drawMap(this.g);
		  if (showMenu) {
			  
			  
			  translate(
			      gameMap.calculateMapItemX(fixedActiveFieldItem),
			      gameMap.calculateMapItemY(fixedActiveFieldItem),
			      10
			  );
			  contextMenu.draw(g);
			  //popMatrix();
		  }
	
		
		  g.stroke(120, 120 ,0);
		 
	}
	
	
	
	
}
