package com.poppy;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
		try {
			PTY pty = new PTY();
			PtyOutput out = new PtyOutput(pty.getOS());
			PtyInput in = new PtyInput(pty.getIS());
			
			new Thread(in).start();
			new Thread(out).start();
			
		} catch(IOException e){
			System.out.println("Hello poppy!");
		}
	
        
    }
}
