package com.poppy;

import java.io.IOException;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
		try {
			
			PTY pty = new PTY();
			PtyOutput out = new PtyOutput(pty.getOS());
			PtyInput in = new PtyInput(pty.getIS());
			
			Ui ui = new Ui();
			Application.launch(Ui.class, args);
			
			new Thread(in).start();
			new Thread(out).start();
			//new Thread(ui).start();
			
		} catch(IOException e){
			System.out.println("Hello poppy!");
		}
	
        
    }
}
