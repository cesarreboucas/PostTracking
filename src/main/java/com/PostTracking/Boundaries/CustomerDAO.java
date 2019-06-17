package com.PostTracking.Boundaries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Customer;

@Component
public class CustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public int createCustomer(Customer cust) {
		entityManager.merge(cust);
		return cust.getId();
	}
	
	
	public Customer getCustomer(int id) {
		Customer cust = entityManager.find(Customer.class, id);
		return cust;
	}
	
	
	public boolean updateCustomer(Customer cust)	{
		
		Customer findCust = entityManager.find(Customer.class, cust.getId());
		findCust.setFirstName(cust.getFirstName());
		findCust.setLastName(cust.getLastName());
		findCust.setPhoneNumber(cust.getPhoneNumber());
		findCust.setEmailAddress(cust.getEmailAddress());
		findCust.setAddress(cust.getAddress());
		findCust.setCity(cust.getCity());
		findCust.setProvince(cust.getProvince());
		findCust.setZipCode(cust.getZipCode());
		entityManager.merge(findCust);
		return true;
	}
	
	public boolean deletePhone(Customer cust)	{
		
		entityManager.remove(cust);
		return true;
	}
	
	public List<Customer> listCustomers() {
		
		List<Customer> custList = null;
		custList = entityManager.createQuery("select c from Customer c").getResultList();
		return custList;
	}
}