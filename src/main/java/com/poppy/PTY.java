
package com.poppy;

import com.pty4j.PtyProcess;
import com.pty4j.PtyProcessBuilder;

import java.io.OutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.Scanner;


class PTY implements Runnable {
	
	public PTY(){
		run();
	}
	
	public void run(){
				
		String[] cmd = { "/bin/sh", "-l" };
		Map<String, String> env = new HashMap<>(System.getenv());
		if (!env.containsKey("TERM")) env.put("TERM", "xterm");
		PtyProcess process = new PtyProcessBuilder().setCommand(cmd).setEnvironment(env).start();

		OutputStream os = process.getOutputStream();
		InputStream is = process.getInputStream();
				
		String teste = "ls\n";
				
		os.write(teste.getBytes());
		os.flush();
				
		//byte[] buf = new byte[1024];
		//int n = is.read(buf);
		//System.out.print(new String(buf, 0, n));
				

		//int result = process.waitFor();
				
	}
	
}
