package com.training.borsa.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropRead {
	public static void main(String[] args) {
		PropReadEngine<PropObject1> engine1 = new PropReadEngine<>();
		PropObject1 readProp = engine1.readProp(PropObject1.class);
		System.out.println(readProp);
		
		PropReadEngine<PropObject2> engine2 = new PropReadEngine<>();
		PropObject2 readProp2 = engine2.readProp(PropObject2.class);
		System.out.println(readProp2);
		
		
		
		try(InputStream inputStream = new FileInputStream(new File("myprop.properties"))) {
			Properties properties = new Properties();
			properties.load(inputStream);
			
			PropObject1 object1 = new PropObject1();
			object1.setName(properties.getProperty("server.name"));
			object1.setIp(properties.getProperty("server.ip"));
			object1.setPort(Integer.parseInt(properties.getProperty("server.port")));
		    
//			if (Logger.isDebugEnabled())
//			logger.debug("jhdshsd" + object1);
			
			System.out.println(object1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(InputStream inputStream = new FileInputStream(new File("myprop2.properties"))) {
			Properties properties = new Properties();
			properties.load(inputStream);
			
			PropObject2 object1 = new PropObject2();
			object1.setTest(properties.getProperty("server.test"));
			object1.setMest(properties.getProperty("server.mest"));
			object1.setCest(Integer.parseInt(properties.getProperty("server.cest")));
		    
//			if (Logger.isDebugEnabled())
//			logger.debug("jhdshsd" + object1);
			
			System.out.println(object1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
