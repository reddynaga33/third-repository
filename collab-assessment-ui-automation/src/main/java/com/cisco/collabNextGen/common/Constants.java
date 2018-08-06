package com.cisco.collabNextGen.common;

import org.apache.log4j.Logger;


import com.cisco.collabNextGen.utilities.LoggerLib;

/**
 * This Interface is used to set the constants globally which will be project specific
 * 
 * @author Giri
 *
 */
public abstract class Constants {

	public static final String PROJECTPATH = System.getProperty("user.dir");
	public static final String TESTRESOURCES=PROJECTPATH + "/src/test/resources/";
	public static final String BROWSERDRIVERFOLDERLOCATION=PROJECTPATH + "/src/main/resources/browserdrivers/";
	public static final String LOGLEVEL="INFO";
	public static final String LOGFILENAME= "UIAutomation";
	public static final String URL="http://ec2-13-250-99-212.ap-southeast-1.compute.amazonaws.com/hpptb.com/";
	public	final static Logger log = LoggerLib.writeLog(BaseTestSuite.class.getName());	
	
}

	
	
	

