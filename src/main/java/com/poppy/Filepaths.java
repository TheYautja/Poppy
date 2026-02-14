
package com.poppy;


class Filepaths {
	
	String currentPath = "/";
	
	public Filepaths(){
		getUserDir();
	}
	
	private void getUserDir(){
		currentPath = System.getProperty("user.dir");
	}
	
	public String getCurrentPath(){
		return currentPath;
	}
	
}
