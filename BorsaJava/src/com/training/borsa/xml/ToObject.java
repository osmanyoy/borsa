package com.training.borsa.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.training.borsa.newfeatures.Person;

public class ToObject {
	public static void main(String[] args) {
		try {
			File file = new File("test.xml");
			JAXBContext jaxb = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			FileInputStream fileOutputStream = new FileInputStream(file);
			Person person = (Person)unmarshaller.unmarshal(fileOutputStream);
			System.out.println(person);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
