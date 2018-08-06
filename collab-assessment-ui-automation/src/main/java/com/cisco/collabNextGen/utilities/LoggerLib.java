package com.cisco.collabNextGen.utilities;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cisco.collabNextGen.common.Constants;
public class LoggerLib {
public static String logLevel=Constants.LOGLEVEL;
public static String logFileName=Constants.LOGFILENAME;
	
	public static Logger writeLog(String className){
		Logger log = Logger.getLogger(className);
		Properties properties = new Properties();
		properties.put("log4j.rootLogger", logLevel+", Console,File");
		properties.put("log4j.appender.Console", "org.apache.log4j.ConsoleAppender");
		properties.put("log4j.appender.Console.layout", "org.apache.log4j.PatternLayout");
		properties.put("log4j.appender.Console.layout.ConversionPattern", "[%-5p] - %m%n");
		
	    properties.put("log4j.appender.File", "org.apache.log4j.FileAppender");
		properties.put("log4j.appender.File.file","logs/"+logFileName+".log");
		properties.put("log4j.appender.File.layout", "org.apache.log4j.PatternLayout");
		properties.put("log4j.appender.File.layout.ConversionPattern", "%-4r [%d] [%-5p] [%c %x] - %m%n");
		
		PropertyConfigurator.configure(properties);
		return log;
		
	}
	
	
}