package com.training.borsa.xml;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.borsa.newfeatures.Person;

@WebService(targetNamespace = "http://osman.com")
public class MyWebService {
	
	public Person getPerson(@WebParam(name = "isim") String name) {
		Person person = new Person();
		person.setName("osman");
		person.setSurname("yay");
		person.setBoltest(true);
		return person;
	}
}
