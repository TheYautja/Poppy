
package com.poppy;

import java.io.InputStream;
import java.io.IOException;

class PtyInput implements Runnable {
	
	InputStream is;
	
	public PtyInput(InputStream is){
		this.is = is;
	}
	
	public void run(){

		try {
			System.out.println("This is the reader :O");
		}catch(IOException e){
			System.out.println("\u001B[34m" + "Pty Input stream error :(" + "\u001B[0m");
			e.printStackTrace();
		}

	}
	
}
