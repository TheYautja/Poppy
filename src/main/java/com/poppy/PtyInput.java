
package com.poppy;

import java.io.InputStream;
import java.lang.Exception;
import java.io.IOException;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;
import javafx.application.Platform;

class PtyInput extends Task<Void> {
	
	InputStream is;
	TextArea terminal;
	
	public PtyInput(InputStream is, TextArea terminal){
		this.is = is;
		this.terminal = terminal;
	}
	
	
	@Override
	protected Void call() throws Exception {
		
		byte[] buffer = new byte[4096];
		
		try {
			
			while(!isCancelled()){
				
				int n = is.read(buffer);
				if(n == -1)break;
				String res = new String(buffer, 0, n);
				
				Platform.runLater(() -> terminal.appendText(res));
				
			}
		}catch(IOException e){
			System.out.println("\u001B[34m" + "Pty Input stream IOException :(" + "\u001B[0m");
			e.printStackTrace();
		}
		return null;
	}
}
