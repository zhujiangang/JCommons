package org.jcommons.file;

import java.io.File;
import java.io.IOException;

public class BigFile {

	private File file;
	
	public BigFile(){
		
	}
	
	public BigFile(File file){
		this.file = file;
	}
	
	public void readByLine(){
		
	}
	
	public boolean copy(){
		return false;
	}
	
	public boolean create(){
		try {
			return file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
