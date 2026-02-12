
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
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import java.awt.event.KeyEvent;



public class Ui extends Application {
	
	Filepaths fp = new Filepaths();
	private Stage stage;
	private String helloMessage = new String("Welcome to poppy!\n");
	private TextArea terminal = new TextArea(helloMessage);
	private double wWidth = 800;
	private double wHeight = 600;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		
		PTY pty = new PTY();
		
		terminal.setStyle("-fx-control-inner-background: black; -fx-font-family: monospace; -fx-highlight-fill: white; -fx-highlight-text-fill: black; -fx-text-fill: white;");
		terminal.setWrapText(true);
		terminal.setEditable(false);
		terminal.setPrefWidth(wWidth);
		insertPathOnEmptyLine();
		
		PtyInput inStream = new PtyInput(pty.getIS(), terminal);
		PtyOutput outStream = new PtyOutput(pty.getOS(), terminal);
		
		new Thread(inStream, "pty-input").start();
		new Thread(outStream, "pty-output").start();
		
		HBox parent = new HBox();
		
		parent.getChildren().addAll(terminal);
		
		Scene scene = new Scene(parent, wWidth, wHeight, Color.BLACK);
		stage.setTitle("Poppy");
		stage.setScene(scene);	
		stage.getIcons().add(new Image("images/minePoppy.png"));
		stage.setResizable(false);
		stage.show();
		
	}
	
	
	private void insertPathOnEmptyLine(){
		if(terminal.getCaretPosition() <= 1){
			terminal.appendText(fp.getCurrentPath());
		}
	}
	
}
