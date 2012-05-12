package com.therealmasel.sandyproccy;

import processing.core.PGraphics;

public abstract class StageObject {

	protected int id;
	
	public StageObject(int id) {
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public abstract void drawObject(PGraphics g);
	
	public abstract void drawBuffer(PGraphics g);


}
