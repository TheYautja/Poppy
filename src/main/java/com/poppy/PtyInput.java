
package com.poppy;

import java.io.InputStream;
import java.lang.Exception;
import java.io.IOException;
import javafx.concurrent.Task;

class PtyInput extends Task<InputStream> {
	
	InputStream is;
	
	public PtyInput(InputStream is){
		this.is = is;
	}
	
	
	@Override
	protected InputStream call() throws Exception {
		
		byte[] buffer = new byte[4096];
		try {
			
			while(!Thread.currentThread().isInterrupted()){
				
				int n = is.read(buffer);
				if(n == -1)break;
				String res = new String(buffer, 0, n);
				System.out.print(res);
			}
			return is;
		}catch(IOException e){
			System.out.println("\u001B[34m" + "Pty Input stream error :(" + "\u001B[0m");
			e.printStackTrace();
			return is;
		}
	}
}
