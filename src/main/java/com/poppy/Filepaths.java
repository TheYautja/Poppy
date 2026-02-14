
package com.poppy;


class Filepaths {
	
	String currentPath;
	
	public Filepaths(){

	}
	
	public String getUserDir(){
		this.currentPath = System.getProperty("user.dir");
		return this.currentPath;
	}

}
