
package com.poppy;

import com.pty4j.PtyProcess;
import com.pty4j.PtyProcessBuilder;

import java.io.OutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;


class PTY {
	
	InputStream is;
	OutputStream os;
	PtyProcess process;
	
	public PTY() throws IOException {
				
		String[] cmd = { "/bin/sh", "-l" };
		Map<String, String> env = new HashMap<>(System.getenv());
		if (!env.containsKey("TERM")) env.put("TERM", "xterm");
		process = new PtyProcessBuilder().setCommand(cmd).setEnvironment(env).start();

		os = process.getOutputStream();
		is = process.getInputStream();
	
	}
	
	public InputStream getIS(){
		return is;
	}
	
	public OutputStream getOS(){
		return os;
	}
	
}
