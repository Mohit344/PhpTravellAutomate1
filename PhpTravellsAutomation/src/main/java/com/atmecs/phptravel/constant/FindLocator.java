package com.atmecs.phptravel.constant;

import java.io.IOException;
import java.util.Properties;

import com.phptravell.util.ReadPropertiesFile;



public class FindLocator {

	
	static Properties phptravelsprop;

	public FindLocator() {
	try {
	phptravelsprop = ReadPropertiesFile.loadProperty("./src/test/resources/Locators/xpath.properties");
	} catch (IOException e) {
	e.getMessage();
	}
	}

	public  String getlocator(String key)
	{
	String value=phptravelsprop.getProperty(key);
	return value;

	}

	}