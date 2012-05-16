package com.therealmasel.sandyproccy;

import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PGraphics;

public class GameMap {

	private GameMapField[][] gameMap;
	private int fieldsByWidth;
	private int fieldsByHeight;
	private int fieldWidth;
	private int fieldHeight;
	
	private GameMapObject[] gameMapObjects;
	
	public GameMap(
		int fieldsByWidth, 
		int fieldsByHeight, 
		int fieldWidth,
		int fieldHeight
	) {
		gameMap = new GameMapField[fieldsByWidth][fieldsByHeight];
		this.fieldsByWidth = fieldsByWidth;
		this.fieldsByHeight = fieldsByHeight;
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		
		for (int i = 0; i < fieldsByWidth; i++) {
			for (int j = 0; j < fieldsByHeight; j++) {
				gameMap[i][j] = new GameMapField(fieldWidth, fieldHeight, i*fieldsByWidth + j);
				PApplet.println(i*fieldsByWidth + j);
			}
		}
	}
	
	public void drawMap(PGraphics canvas) {
		
		for (int i = 0; i < fieldsByWidth; i++) {
			for (int j = 0; j < fieldsByHeight; j++) {
				canvas.pushMatrix();
				canvas.translate(i*fieldWidth,j*fieldHeight,0);
				gameMap[i][j].draw(canvas);
				canvas.popMatrix();
			}
		}
		if (gameMapObjects != null) {
			for (int k = 0; k < gameMapObjects.length - 1; k++) {
				gameMapObjects[k].drawObject(canvas);
			}	
		}
		
	}
	
	public void drawMapBuffer(PGraphics buffer) {
		for (int i = 0; i < fieldsByWidth; i++) {
			for (int j = 0; j < fieldsByHeight; j++) {
				buffer.pushMatrix();
				buffer.translate(i*fieldWidth,j*fieldHeight,0);
				//canvas.rotateY(PI/2);
				gameMap[i][j].drawBuffer(buffer);
				buffer.popMatrix();
			}
		}
	}

	public GameMapField findField(PGraphics buffer, int mouseX, int mouseY) {
		buffer.noStroke();
		this.drawMapBuffer(buffer);
		buffer.endDraw();
		int pick = buffer.get(mouseX, mouseY) ;
		int fieldWIndex = (pick % fieldsByWidth);
		int fieldHIndex = pick - fieldWIndex;
		PApplet.println("pick is" + pick);
		PApplet.println("Windex" + fieldWIndex);
		PApplet.println("Hindex" + fieldHIndex);
		/*
		if (fieldWIndex <= fieldsByWidth) && (fieldHIndex <= fieldsByHeight) { 
		return gameMap[fieldWIndex][fieldHIndex];
		} else {
			return null;
		}
		*/
		return null;
	}
	
}
