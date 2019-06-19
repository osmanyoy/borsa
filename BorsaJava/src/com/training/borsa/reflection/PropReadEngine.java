package com.training.borsa.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropReadEngine<T> {
	
	public T readProp(Class<T> tClass) {
		PropFile annotation = tClass.getAnnotation(PropFile.class);
		if (annotation == null) {
			throw new IllegalStateException();
		}
		
		String fileName = annotation.fileName();
		try(InputStream inputStream = new FileInputStream(new File(fileName))) {
			Properties properties = new Properties();
			properties.load(inputStream);
			
			T newInstance = tClass.newInstance();
			
			Field[] fields = tClass.getDeclaredFields();
			for (Field field : fields) {
				Prop propAnno = field.getAnnotation(Prop.class);
				if (propAnno == null) {
					continue;
				}
				String name = propAnno.name();
				String property = properties.getProperty(name);
				if (property != null) {
					field.setAccessible(true);
					Class<?> type = field.getType();
					switch (type.getName()) {
					case "java.lang.String":
						field.set(newInstance, property);
						break;
					case "int":
						field.setInt(newInstance, Integer.parseInt(property));
						break;
					default:
						break;
					}
				}
			}
			return newInstance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
