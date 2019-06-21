package com.borsa.spring;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyStudentDao extends CrudRepository<Customer, Long>{
	
	List<Customer> findByName(String name);
	
	List<Customer> findByNameAndSurname(String name,String surname);

	Future<List<Customer>> findByNameIn(List<String> name);
	
	@Query(value = "select c from Customer c where c.name=:asd")
	List<Customer> test(@Param("asd") String name);
	
	@Query(value = "select * from musteri c where c.name=:asd",nativeQuery = true)
	List<Customer> test2(@Param("asd") String name);
	
	@Modifying
	@Query(value = "update Customer c set c.surname=:asd where c.name=:zxc")
	void updateTest(@Param("zxc") String name,@Param("asd")String surname);
	
	
}
