package com.atmecs.phptravel.constant;

import java.io.File;

public class FilePath {

	public final static String USER_HOME= System.getProperty("user.dir")+File.separator;
	public final static String RESOURCES_HOME= USER_HOME+"src"+File.separator+"test"+File.separator+"resources"+File.separator;
	public final static String LOCATOR_HOME= RESOURCES_HOME+"locators"+File.separator;
	public final static String LIB_HOME =USER_HOME+"libs"+File.separator;
	
	
	public final static String CONFIG_FILE = USER_HOME+"config.properties";
	public final static String CHROME_PATH= LIB_HOME+"chromedriver.exe";
	public final static String FIREFOX_PATH= LIB_HOME+"geckodriver.exe";
	
	public final static String FAILED_SCREENSHOT_FILE= USER_HOME+"FailedTestScreenShots"+File.separator;
	public final static String EXTENT_REPORT_FILE= USER_HOME+"test-output"+File.separator+"ExtentReport.html";
	public final static String EXTENT_CONFIG = USER_HOME+"extent-config.xml";
	public final static String LOG4J_FILE= RESOURCES_HOME+"log4j"+File.separator+"log4j.properties";
	public final static String XPATH_FILE= LOCATOR_HOME+"xpath.properties";
	public final static String TESTDATA_FILE= RESOURCES_HOME+"testdata"+File.separator+"dataread.xlsx";
	public final static String PEOPLEDATA_FILE= RESOURCES_HOME+"testdata"+File.separator+"Book1.xlsx";

	
	
}
