package com.therealmasel.sandyproccy;

import processing.core.PGraphics;

public abstract class GameContextMenuItem {

	protected int itemId;
	
	public GameContextMenuItem(int itemId) {
		this.itemId = itemId;
	}
	
	public int getId () {
		return itemId;
	}
	
	public abstract void draw(PGraphics canvas);
	
	
	public abstract void drawBuffer(PGraphics buffer);
}
