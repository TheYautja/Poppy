
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;



public class Ui extends Application {
	
	private Stage stage;
	private String helloMessage = new String("Welcome to poppy!\n");
	private TextArea terminal = new TextArea(helloMessage);
	private double wWidth = 800;
	private double wHeight = 600;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		PTY pty = new PTY();
		Filepaths fp = new Filepaths();
		
		terminal.setStyle("-fx-control-inner-background: black; -fx-font-family: monospace; -fx-highlight-fill: white; -fx-highlight-text-fill: black; -fx-text-fill: white;");
		terminal.setWrapText(true);
		terminal.setEditable(false);
		terminal.setPrefWidth(wWidth);
		terminal.appendText("Running from: " + fp.getCurrentPath() + "\n" + "\n");
		
		PtyInput inStream = new PtyInput(pty.getIS(), terminal);
		PtyOutput outStream = new PtyOutput(pty.getOS(), terminal);
		
		new Thread(inStream, "pty-input").start();
		new Thread(outStream, "pty-output").start();
		
		terminal.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER){
				terminal.appendText("\n--Ran from: " + fp.getCurrentPath());
			}
		});
		
		HBox parent = new HBox();
		
		parent.getChildren().addAll(terminal);
		
		Scene scene = new Scene(parent, wWidth, wHeight, Color.BLACK);
		stage.setTitle("Poppy");
		stage.setScene(scene);	
		stage.getIcons().add(new Image("images/minePoppy.png"));
		stage.setResizable(false);
		stage.show();
		
	}

}
