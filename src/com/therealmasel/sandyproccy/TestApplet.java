package com.therealmasel.sandyproccy;

import processing.core.PApplet;


public class TestApplet extends PApplet{

	ScenesController sceneController = new ScenesController();
	
	public void draw(){
		sceneController.draw();
	}
	
	
	
	public void setup(){
		size(200,200,OPENGL);
		Scene myScene1 = new MyScene1();
		Scene myScene2 = new MyScene2();
		sceneController.addScene(myScene1);
		sceneController.addScene(myScene2);
		sceneController.nextScene();
	}
	
	public void mousePressed() {
		sceneController.nextScene();
	}
	
	public void keyPressed() {
		sceneController.previousScene();
	}
	
	public class MyScene1 extends Scene {
		
		public void beforeScene(){
			background(0);
			fill(0);
		}
		
		public void afterScene(){
			
		}
		
		public void drawScene(){
			fill(153);
			rect(30, 20, 55, 55);
		}
		
		public void setupScene(){
			background(0);
			fill(0);
		}
	}
	
	public class MyScene2 extends Scene {
		
		public void beforeScene(){
			background(0);
			fill(0);
		}
		
		public void afterScene(){
			background(0);
			fill(0);
		}

		public void drawScene(){
			fill(110, 120, 100);
			rect(72, 82, 52, 51);
		}
		
		public void setupScene(){
			background(0);
			fill(0);
		}
	}
}
