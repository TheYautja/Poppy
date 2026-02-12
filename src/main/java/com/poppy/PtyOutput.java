
package com.poppy;


import java.io.OutputStream;
import java.lang.Exception;
import java.io.IOException;
import javafx.scene.input.KeyCode;
import java.awt.event.KeyEvent;


import javafx.concurrent.Task;
import javafx.scene.control.TextArea;


class PtyOutput extends Task<Void>{
	OutputStream os;
	TextArea terminal;
	private Filepaths fp = new Filepaths();
	
	
	public PtyOutput(OutputStream os, TextArea terminal) {
		this.os = os;
		this.terminal = terminal;
		displayPathOnEnter();
	}
	
	@Override
	protected Void call() throws Exception {
		write();
		return null;
	}
	
	
	private void write(){
		terminal.setOnKeyTyped(e -> {
			try{
				String input = e.getCharacter();
				os.write(input.getBytes());
				os.flush();
			}catch(IOException err){
				err.printStackTrace();
			}
		});
	}
	
	
	private void displayPathOnEnter(){
		terminal.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER){
				terminal.appendText(fp.getCurrentPath());
			}
		});
	}
	
}
