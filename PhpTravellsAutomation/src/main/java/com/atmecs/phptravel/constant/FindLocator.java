package com.atmecs.phptravel.constant;

import java.io.IOException;
import java.util.Properties;

import com.phptravell.util.ReadPropertiesFile;


/**
 * Find locator class
 * @author Mohit.Jaiswal
 *
 */
public class FindLocator {


	static Properties phptravelsprop;

	public FindLocator() {
		try {
			phptravelsprop = ReadPropertiesFile.loadProperty(FileConstant.findlocator);// all the xpath to locate element .
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
