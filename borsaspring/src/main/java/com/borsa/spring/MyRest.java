package com.borsa.spring; 

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRest {

	@GetMapping("/hello/{isim}")
	public String hello(@PathVariable("isim") final String name, 
			@RequestParam("soyisim") final String surname) {
		return "Hello Spring " + name + " " + surname;
	}
	
	@Autowired
	private CustomerDao custDao;
	
	@GetMapping("/cust/write")
	public String writeCustomer() {
		Customer customer = new Customer();
		customer.setName("Osman" + new Random().nextInt());
		customer.setSurname("Yay" + new Random().nextInt());
		custDao.persist(customer);
		return "OK";
		
	}

}
