package com.therealmasel.sandyproccy;

import processing.core.PGraphics;

public class WordGameContextMenuItem extends GameContextMenuItem {

	private int width;
	private int height;
	
	public WordGameContextMenuItem(int itemId, int width, int height) {
		super(itemId);
		this.width = width;
		this.height = height;
	}
	private WordGameContextMenuItem(int itemId) {
		super(itemId);
	}

	@Override
	public void draw(PGraphics canvas) {
		canvas.fill(255);
		canvas.beginShape();
		canvas.vertex(0, 0, 0);
		canvas.vertex(0, width, 0);
		canvas.vertex(height, width, 0);
		canvas.vertex(height, 0, 0);
		canvas.endShape();	
	}

	@Override
	public void drawBuffer(PGraphics buffer) {
		buffer.fill(itemId, itemId, itemId);
		buffer.beginShape();
		buffer.vertex(0, 0, 0);
		buffer.vertex(0, width, 0);
		buffer.vertex(height, width, 0);
		buffer.vertex(height, 0, 0);
		buffer.endShape();
	}

	

}
