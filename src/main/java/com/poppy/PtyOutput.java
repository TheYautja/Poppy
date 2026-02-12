
package com.poppy;


import java.io.OutputStream;
import java.lang.Exception;
import java.io.IOException;



import javafx.concurrent.Task;
import javafx.scene.control.TextArea;


class PtyOutput extends Task<Void>{
	OutputStream os;
	TextArea terminal;
	
	
	public PtyOutput(OutputStream os, TextArea terminal) {
		this.os = os;
		this.terminal = terminal;
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
	
	
	
	
}
