package com.therealmasel.sandyproccy;

import java.util.ArrayList;

import processing.core.PGraphics;

public class WordGameContextMenu extends GameContextMenu{
	
	//it`s bad cause we can`t construct the items here
	//we do it in the code external to the menu
	public WordGameContextMenu(ArrayList<GameContextMenuItem> gameMenuItems) {
		super(gameMenuItems);
	}

	public void itemsSpacer(int itemOrderId, PGraphics canvas) {
		canvas.translate(itemOrderId*20, itemOrderId*20, 0);
	}

}
