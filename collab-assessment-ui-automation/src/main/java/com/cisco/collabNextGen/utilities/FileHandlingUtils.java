package com.cisco.collabNextGen.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * This is a common file handing class where all types of file handling reusable methods are there.
 * @author ggouda
 *
 */
public class FileHandlingUtils {
	
	/**
	 * This method is for converting file to string. This has input as location
	 * and this returns file content as String
	 * @param fileLocation		String-File Location as an input
	 * @return					String-File content as String output
	 * @throws IOException		Throws IOException as file handling operation is performed 
	 */
	@SuppressWarnings("deprecation")
	public String convertFileToString(String fileLocation) throws IOException{
		
		//File file = new File(fileLocation);
		return FileUtils.readFileToString(new File(fileLocation));
		
	}

}
