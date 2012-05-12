package com.therealmasel.sandyproccy;
import java.util.ArrayList;
import java.util.List;



public class ScenesController {

	volatile int currentSceneIndex = 0;
	
	List<Scene> scenes = new ArrayList<Scene>();
	
	SceneObject emptyScene = null;
	
	SceneObject activeSceneObject;
	
	
	public ScenesController(){
		emptyScene = new SceneObject(){
			public void doDraw(){
			}
		};
		activeSceneObject = emptyScene; 
	}
	
	public void draw() {
		activeSceneObject.doDraw();
	}
	
	
	
	
	public void addScene(Scene scene){
		scenes.add(scene);
	}

	public void playScene(int sceneNumber){
		Scene scene = scenes.get(sceneNumber);
		if (scene != null) {
			scene.setupScene();
			processScene(scene);
		}
	}
	
	
	public void nextScene() {
		if (currentSceneIndex < scenes.size()-1) {
			currentSceneIndex++;
			Scene scene = scenes.get(currentSceneIndex);
			scene.setupScene();
			processScene(scene);	
		} else {
			//do it accurately!
			//may be I should add loopback mode?
			//after the last scene there should be the first? 
		}
		
	}
	
	private void processBeforeScene(final Scene scene) {
		SceneObject so = new SceneObject(){
			public void doDraw(){
				scene.beforeScene();
			}
		};
		activeSceneObject = so;
	}
		

	private void processScene(final Scene scene) {
		SceneObject so = new SceneObject(){
			public void doDraw(){
				scene.drawScene();
			}
		};
		activeSceneObject = so;
	}




	public void previousScene() {
		
		if (currentSceneIndex > 0) {
			currentSceneIndex--;
			Scene scene = scenes.get(currentSceneIndex);
			scene.setupScene();
			processScene(scene);	
		} else {
			//we try to think what to do
			//some kind of exception or something?
			//how would it be in the javascript?
		}
		
	}
	
	private interface SceneObject {
		
		void doDraw();

	}
}
