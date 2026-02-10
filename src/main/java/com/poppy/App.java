package com.poppy;

import java.io.IOException;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
			
			Ui ui = new Ui();
			Application.launch(Ui.class, args);

			System.out.println("Hello poppy!");

        
    }
}
