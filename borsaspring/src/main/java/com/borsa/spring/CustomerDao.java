package com.borsa.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED,noRollbackFor = IllegalAccessException.class)
	public void persist(Customer customer) {
		entityManager.persist(customer);
		customer.setValue1(100);
	}
	
	public List<Customer> getCustomersByName(String name){
		TypedQuery<Customer> createQuery = entityManager.createQuery("select c from Customer c where c.name= :xyz",Customer.class);
		createQuery.setParameter("xyz", name);
		return createQuery.getResultList();
	}
	
	public List<Customer> getCustomersByNameWithNative(String name){
		Query createNativeQuery = entityManager.createNativeQuery("select * from Musteri c where c.name= :xyz",Customer.class);
		createNativeQuery.setParameter("xyz", name);
		return createNativeQuery.getResultList();
	}

}
