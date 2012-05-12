package com.therealmasel.sandyproccy; 

import processing.core.PApplet;

public class DrawCylinderApplet extends PApplet {

	public void setup(){
		size(250,250,OPENGL);
		
	}

	public void draw() {
		  lights();
		  background(0);
		  
		  // Change height of the camera with mouseY
		  camera(30.0f, mouseY, 220.0f, // eyeX, eyeY, eyeZ
		         0.0f, 0.0f, 0.0f, // centerX, centerY, centerZ
		         0.0f, 1.0f, 0.0f); // upX, upY, upZ
		  
		  noStroke();
		  pushMatrix();
		  translate(10,10,10);
		  rotateY(PI/2);
		  drawCylinder(7, 7, 11, 30);
		  popMatrix();
		  box(10);
		  stroke(255);
		  line(-100, 0, 0, 100, 0, 0);
		  line(0, -100, 0, 0, 100, 0);
		  line(0, 0, -100, 0, 0, 100);
	}
	
	void drawCylinder( int sides, float r1, float r2, float h)
	{
	    float angle = 360 / sides;
	    float halfHeight = h / 2;
	    // top
	    beginShape();
	    for (int i = 0; i < sides; i++) {
	        float x = cos( radians( i * angle ) ) * r1;
	        float y = sin( radians( i * angle ) ) * r1;
	        vertex( x, y, -halfHeight);
	    }
	    endShape(CLOSE);
	    // bottom
	    beginShape();
	    for (int i = 0; i < sides; i++) {
	        float x = cos( radians( i * angle ) ) * r2;
	        float y = sin( radians( i * angle ) ) * r2;
	        vertex( x, y, halfHeight);
	    }
	    endShape(CLOSE);
	    // draw body
	    beginShape(TRIANGLE_STRIP);
	    for (int i = 0; i < sides + 1; i++) {
	        float x1 = cos( radians( i * angle ) ) * r1;
	        float y1 = sin( radians( i * angle ) ) * r1;
	        float x2 = cos( radians( i * angle ) ) * r2;
	        float y2 = sin( radians( i * angle ) ) * r2;
	        vertex( x1, y1, -halfHeight);
	        vertex( x2, y2, halfHeight);
	    }
	    endShape(CLOSE);
	}
	
	//what data do we need to draw a cylinder?
	//vector of cylinder direction
	public void drawCylinder(float centerX, float centerY, float CenterZ,
			float centerX1, float centerX2, float centerX3, float radius){
		
		
	}
}
