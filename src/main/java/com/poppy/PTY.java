

class PTY {
	
	public PTY(){
		initPTY();
	}
	
	public void initPTY(){
		
		String[] cmd = { "/bin/sh", "-l" };
		Map<String, String> env = new HashMap<>(System.getenv());
		if (!env.containsKey("TERM")) env.put("TERM", "xterm");
		PtyProcess process = new PtyProcessBuilder().setCommand(cmd).setEnvironment(env).start();

		OutputStream os = process.getOutputStream();
		InputStream is = process.getInputStream();

		int result = process.waitFor();
		
	}
	

	
}
