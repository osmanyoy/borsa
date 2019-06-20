package com.borsa.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void persist(Customer customer) {
		entityManager.persist(customer);
	}
	
}
