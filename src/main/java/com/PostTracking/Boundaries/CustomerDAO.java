package com.PostTracking.Boundaries;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Customer;


@Component
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
	Iterable<Customer> findAllByOrderByFirstNameAsc();
}