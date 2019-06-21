package com.borsa.spring; 

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.borsa.spring.aop.MyAnnoTest;

@RestController
public class MyRest {
	
	@Autowired
	private MyStudentDao msd;

	@GetMapping("/cust/write2")
	public String writeCustomer2() {
		Customer customer = new Customer();
		customer.setName("Osman" + new Random().nextInt());
		customer.setSurname("Yay" + new Random().nextInt());
		msd.save(customer);
		return "OK";
		
	}

	@GetMapping("/hello/{isim}")
	@MyAnnoTest(testStr = "test mest")
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
