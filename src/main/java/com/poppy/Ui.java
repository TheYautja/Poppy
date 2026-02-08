
package com.poppy;

import java.lang.Exception;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Ui extends Application implements Runnable {
	
	private Stage stage;
	
	public void run(){
		try{
			start(stage);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		Text test = new Text("ui test");
		
		HBox parent = new HBox();
		
		parent.getChildren().addAll(test);
		
		Scene scene = new Scene(parent, 100, 100, Color.LIGHTGRAY);
		stage.setTitle("Poppy");
		stage.setScene(scene);
		stage.show();
		
	}
	
}
