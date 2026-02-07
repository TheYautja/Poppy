
package com.poppy;

import java.io.InputStream;
import java.io.IOException;

class PtyInput implements Runnable {
	
	InputStream is;
	
	public PtyInput(InputStream is){
		this.is = is;
	}
	
	public void run(){
		
		byte[] buffer = new byte[4096];
		
		try {
			
			while(!Thread.currentThread().isInterrupted()){
				
				int n = is.read(buffer);
				if(n == -1)break;
				
				String res = new String(buffer, 0, n);
				System.out.print(res);
				
			}
	
		}catch(IOException e){
			System.out.println("\u001B[34m" + "Pty Input stream error :(" + "\u001B[0m");
			e.printStackTrace();
		}

	}
	
}
