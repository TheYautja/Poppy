
package com.poppy;

import java.io.OutputStream;
import java.io.IOException;

class PtyOutput implements Runnable {
	
	OutputStream os;
	
	public PtyOutput(OutputStream os) {
		this.os = os;
	}
	
	public void run(){
		try {
			while(!Thread.currentThread().isInterrupted()){
				String test = "ls\n";
				os.write(test.getBytes());
				os.flush();
				System.out.println("and this is the writer :D");
			}
		
		} catch(IOException e){
			System.out.println("\u001B[34m" + "Pty Output stream error :(" + "\u001B[0m");
			e.printStackTrace();
		}

	}
	
}
