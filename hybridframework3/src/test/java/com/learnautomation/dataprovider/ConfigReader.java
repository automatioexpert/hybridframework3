package com.learnautomation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties pro;
	
	public ConfigReader()
	{
		pro=new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/project.properties")));
		}  catch (IOException e) 
		{
			System.out.println("Exception while reading file "+e.getMessage());
		}
	}
	
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}
	
	
	
}
