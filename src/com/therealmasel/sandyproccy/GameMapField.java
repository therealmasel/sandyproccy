package com.therealmasel.sandyproccy;

import processing.core.PGraphics;

public class GameMapField {

	private int fieldWidth;
	
	private int fieldHeight;
	
	private int fieldId;
	
	public GameMapField(int fieldWidth, int fieldHeight, int fieldId) {
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.fieldId = fieldId;
	}
	
	public void drawBuffer(PGraphics buffer) {
		
	}
	
	public void draw(PGraphics canvas) {
		canvas.fill(fieldId);
		canvas.beginShape();
		canvas.vertex(0, 0, 0);
		canvas.vertex(0, fieldWidth, 0);
		canvas.vertex(fieldHeight, fieldWidth, 0);
		canvas.vertex(fieldHeight, 0, 0);
		canvas.endShape();
	}
	
	
}
