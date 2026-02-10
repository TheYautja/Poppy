
package com.poppy;

import java.io.OutputStream;
import java.lang.Exception;
import javafx.concurrent.Task;

class PtyOutput extends Task<OutputStream>{
	
	OutputStream os;
	
	public PtyOutput(OutputStream os) {
		this.os = os;
	}
	
	@Override
	protected OutputStream call() throws Exception {
		while(!Thread.currentThread().isInterrupted()){
			String test = "echo Out thread\n";
			os.write(test.getBytes());
			os.flush();
			System.out.println("\u001B[34m" + "Pty Output stream error :(" + "\u001B[0m");
		}
		return os;
	}
}
