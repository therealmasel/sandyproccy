package com.therealmasel.sandyproccy;

import java.util.ArrayList;

import processing.core.PGraphics;

public abstract class GameContextMenu {
	
	public ArrayList<GameContextMenuItem> menuItems; 
	
	public GameContextMenu(ArrayList<GameContextMenuItem> gameMenuItems) {
		this.menuItems = gameMenuItems;
	}
	
	public abstract void itemsSpacer(int itemOrderId, PGraphics canvas); 
	
	public void draw(PGraphics canvas) {
		
		int itemOrderId = 1;
		for (GameContextMenuItem item : menuItems) {
			canvas.pushMatrix();
			itemsSpacer(itemOrderId, canvas);
			item.draw(canvas);
			canvas.popMatrix();
			itemOrderId ++;
		}
	}
	
	public void drawBuffer(PGraphics buffer) {
		int itemOrderId = 1;
		for (GameContextMenuItem item : menuItems) {
			buffer.pushMatrix();
			itemsSpacer(itemOrderId, buffer);
			item.drawBuffer(buffer);
			itemOrderId ++;
			buffer.popMatrix();
		}
	}

}
