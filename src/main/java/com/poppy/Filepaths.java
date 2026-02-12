
package com.poppy;


import java.io.File;


class Filepaths {
	
	String currentPath = "/home/";
	
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
