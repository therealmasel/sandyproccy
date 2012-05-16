package com.therealmasel.sandyproccy;

import processing.core.PGraphics;

public class GameMapField {

	private int fieldWidth;
	
	private int fieldHeight;
	
	private int fieldId;
	
	private boolean selected;
	
	public GameMapField(int fieldWidth, int fieldHeight, int fieldId) {
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.fieldId = fieldId;
		this.selected = false;
	}
	
	public void drawBuffer(PGraphics buffer) {
		buffer.fill(0,0,fieldId);
		buffer.beginShape();
		buffer.vertex(0, 0, 0);
		buffer.vertex(0, fieldWidth, 0);
		buffer.vertex(fieldHeight, fieldWidth, 0);
		buffer.vertex(fieldHeight, 0, 0);
		buffer.endShape();
	}
	
	public void draw(PGraphics canvas) {
		if (!selected) {
			canvas.fill(0,0,fieldId);
		} else {
			canvas.fill(255,0,fieldId);
		}
		canvas.beginShape();
		canvas.vertex(0, 0, 0);
		canvas.vertex(0, fieldWidth, 0);
		canvas.vertex(fieldHeight, fieldWidth, 0);
		canvas.vertex(fieldHeight, 0, 0);
		canvas.endShape();	
	}

	public void setSelected(boolean selectedFlag) {
		selected = selectedFlag;
	}
	
	
}
