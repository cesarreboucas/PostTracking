package com.PostTracking.Boundaries;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Customer;


@Component
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c WHERE c.active = true ORDER BY c.firstName ASC")
	Iterable<Customer> fetchCustomers();
	
	
}