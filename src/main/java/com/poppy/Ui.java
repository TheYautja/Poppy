
package com.poppy;

import java.lang.Exception;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.concurrent.Task;
import java.io.IOException;


public class Ui extends Application {
	
	private Stage stage;
	private String helloMessage = new String("Welcome to poppy!");
	
	@Override
	public void start(Stage stage) throws Exception {
		
		PTY pty = new PTY();
		
		TextArea terminal = new TextArea(helloMessage);
		terminal.setStyle("-fx-control-inner-background: black; -fx-font-family: monospace; -fx-highlight-fill: gray; -fx-highlight-text-fill: black; -fx-text-fill: white;");
		terminal.setWrapText(true);
		terminal.setEditable(true);
		
		PtyInput inStream = new PtyInput(pty.getIS(), terminal);
		PtyOutput outStream = new PtyOutput(pty.getOS());
		
		terminal.setOnKeyTyped(e -> {
			try{
				pty.getOS().write(e.getCharacter().getBytes());
				pty.getOS().flush();
			}catch(IOException err){
				err.printStackTrace();
			}
		});
		
		new Thread(inStream, "pty-input").start();
		new Thread(outStream, "pty-output").start();
		
		HBox parent = new HBox();
		
		parent.getChildren().addAll(terminal);
		
		Scene scene = new Scene(parent, 400, 400, Color.BLACK);
		stage.setTitle("Poppy");
		stage.setScene(scene);
		stage.show();
		
	}
	
}
