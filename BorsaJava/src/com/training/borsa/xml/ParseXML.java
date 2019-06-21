package com.training.borsa.xml;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.training.borsa.newfeatures.Person;

public class ParseXML {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("osman");
		person.setSurname("yay");
		person.setBoltest(true);

		try {
			File file = new File("test.xml");
			JAXBContext jaxb = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = jaxb.createMarshaller();
			FileOutputStream fileOutputStream =  new FileOutputStream(file);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(person, fileOutputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
