package com.therealmasel.sandyproccy;

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
			}
		}
	}
	
	public void drawMap(PGraphics canvas) {
		
		for (int i = 0; i < fieldsByWidth; i++) {
			for (int j = 0; j < fieldsByHeight; j++) {
				canvas.pushMatrix();
				canvas.translate(i*fieldWidth,j*fieldHeight,0);
				//canvas.rotateY(PI/2);
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
				gameMap[i][j].draw(buffer); 
			}
		}
	}
	
}
