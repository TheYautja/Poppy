
package com.poppy;

import java.lang.Exception;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.concurrent.Task;


public class Ui extends Application {
	
	private Stage stage;

	
	@Override
	public void start(Stage stage) throws Exception {
		
		PTY pty = new PTY();
		
		PtyInput inStream = new PtyInput(pty.getIS());
		PtyOutput outStream = new PtyOutput(pty.getOS());
		
		new Thread(inStream, "pty-input").start();
		new Thread(outStream, "pty-output").start();
		
		Text test = new Text("hello poppy!");
		test.setFill(Color.WHITE);
		
		HBox parent = new HBox();
		
		parent.getChildren().addAll(test);
		
		Scene scene = new Scene(parent, 400, 400, Color.BLACK);
		stage.setTitle("Poppy");
		stage.setScene(scene);
		stage.show();
		
	}
	
}
