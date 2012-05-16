package com.therealmasel.sandyproccy; 

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.opengl.*;

public class DrawCylinderApplet extends PApplet {

	StageObject[] stageObjects;
	
	PGraphics buffer;
	
	public void setup(){
		size(250,250,OPENGL);
		buffer = createGraphics(250, 250, P3D);	
		StageObject cylinder = new StageCylinder(0);
		stageObjects = new StageObject[2];
		stageObjects[0] = cylinder;
		StageObject box = new StageBox(1);
		stageObjects[1] = box;
	}

	
	
	public void drawObjects(PGraphics g) {
		  g.lights();
		  g.background(0);
		  //g.noStroke();
		  stageObjects[0].drawObject(g);
		  stageObjects[1].drawObject(g);
		  //g.stroke(255);
		  g.line(-100, 0, 0, 100, 0, 0);
		  g.line(0, -100, 0, 0, 100, 0);
		  g.line(0, 0, -100, 0, 0, 100);
		  
	}
	
	public void draw() {
		  
		  

		  camera(mouseX, 0, 220.0f, 
		         0.0f, 0.0f, 0.0f, 
		         1.0f, 0.0f, 0.0f);
		  g.background(0);
		  g.noStroke();
		  drawObjects(this.g);
		  g.stroke(255);
		  g.line(-100, 0, 0, 100, 0, 0);
		  g.line(0, -100, 0, 0, 100, 0);
		  g.line(0, 0, -100, 0, 0, 100);
		  //println(frameRate);
	}
	
	public void mouseClicked() {
		buffer.beginDraw();
		buffer.background(getColor(-1));
		buffer.camera(mouseX, 0, 220.0f,
		         0.0f, 0.0f, 0.0f,
		         1.0f, 0.0f, 0.0f);
		buffer.noStroke();
		drawBuffer(buffer);
		buffer.endDraw();
		int pick = buffer.get(mouseX, mouseY);
		int id = getId(pick);
		println(id);
		
	}
	
	private void drawBuffer(PGraphics buffer2) {
		//g.lights();
		  g.background(0);
		  g.noStroke();
		  stageObjects[0].drawBuffer(g);
		  stageObjects[1].drawBuffer(g);
		  g.stroke(255);
		  g.line(-100, 0, 0, 100, 0, 0);
		  g.line(0, -100, 0, 0, 100, 0);
		  g.line(0, 0, -100, 0, 0, 100);
		  
		
	}



	public int getColor(int id) {
		  return id - 2;
		}
		 
		int getId(int c) {
		  return c + 2;
	}
	
	public class StageBox extends StageObject {

		public StageBox(int id) {
			super(id);
		}

		@Override
		public void drawObject(PGraphics g) {
			g.box(10);
		}
	
		@Override
		public void drawBuffer(PGraphics g) {
			
				int idColor = getColor(id);
				buffer.fill(idColor);
				drawObject(buffer);
			
		}
	}
	
	public class StageCylinder extends StageObject {

		public StageCylinder(int id) {
			super(id);
			// TODO Auto-generated constructor stub
		}

		public void drawCylinder(PGraphics g, int sides, float r1, float r2, float h)
		{
		    float angle = 360 / sides;
		    float halfHeight = h / 2;

		    g.beginShape();
		    for (int i = 0; i < sides; i++) {
			    float x = cos( radians( i * angle ) ) * r1;
		        float y = sin( radians( i * angle ) ) * r1;
		        g.vertex( x, y, -halfHeight);
		    }
		    g.endShape();		    

		    g.beginShape();
		    for (int i = 0; i < sides; i++) {
		        float x = cos( radians( i * angle ) ) * r2;
		        float y = sin( radians( i * angle ) ) * r2;
		        g.vertex( x, y, halfHeight);
		    }
		    g.endShape();
		    
		    for (int i = 0; i < sides + 1; i++) {
		    	g.beginShape();
		        float x1 = cos( radians( i * angle ) ) * r1;
		        float y1 = sin( radians( i * angle ) ) * r1;
		        float x2 = cos( radians( i * angle ) ) * r2;
		        float y2 = sin( radians(i * angle ) ) * r2;
		        float x3 = cos( radians( (i+1) * angle ) ) * r1;
		        float y3 = sin( radians( (i+1) * angle ) ) * r1;
		        float x4 = cos( radians( (i+1) * angle ) ) * r2;
		        float y4 = sin( radians( (i+1) * angle ) ) * r2;
		        g.vertex( x1, y1, -halfHeight);
		        g.vertex( x2, y2, halfHeight);
		        g.vertex( x4, y4, halfHeight);
		        g.vertex( x3, y3, -halfHeight);
		        g.endShape();
		    }
		    
		}
		@Override
		public void drawObject(PGraphics g) {
			
			  g.pushMatrix();
			  g.translate(20,10,10);
			  g.rotateY(PI/2);
			  drawCylinder(g, 7, 7, 11, 30);
			  g.popMatrix();
			
		}

		@Override
		public void drawBuffer(PGraphics g) {
			
				int idColor = getColor(id);
				buffer.fill(idColor);
				drawObject(buffer);
			
		}
		
	}
	
	//what data do we need to draw a cylinder?
	//vector of cylinder direction?
	public void drawCylinder(float centerX, float centerY, float CenterZ,
			float centerX1, float centerX2, float centerX3, float radius){
		
		
	}
}
