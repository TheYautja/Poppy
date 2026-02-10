
package com.poppy;

import java.io.OutputStream;
import java.lang.Exception;
import javafx.concurrent.Task;

class PtyOutput extends Task<Void>{
	
	OutputStream os;
	
	public PtyOutput(OutputStream os) {
		this.os = os;
	}
	
	@Override
	protected Void call() throws Exception {

		return null;
	}
	
	
	
}
