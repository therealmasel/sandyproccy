package com.therealmasel.sandyproccy;

import java.util.ArrayList;

import processing.core.PGraphics;

public class WordGameContextMenu extends GameContextMenu{

	public WordGameContextMenu(ArrayList<GameContextMenuItem> gameMenuItems) {
		super(gameMenuItems);
	}

	public void itemsSpacer(int itemOrderId, PGraphics canvas) {
		//canvas.translate(itemOrderId);
		canvas.popMatrix();
	}

}
