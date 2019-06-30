package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.CustomerDAO;
import com.PostTracking.Entities.Customer;
/**
 * Controls the endpoints for the Customers
 * @author 300296145
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO cdao;
	
	/**
	 * Maps the /customers (List of all customers)
	 * @param model sends the customer Object to the view to fill the html form
	 * @return the view of Customers (list)
	 */
	@GetMapping("/customers")
	public String ShowAll(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers/customers";
	}
	

	/**
	 * Creates a new Customer
	 * @param customer The new customer
	 * @return The view /Customer
	 */
	@PostMapping("/customers")
	public String createCustomer(@ModelAttribute Customer customer) {
		System.out.println("POST");
		System.out.println(customer);
		cdao.save(customer);
		return "redirect:/customers";
	}
	
	/**
	 * Update the Customer
	 * @param customer The customer entity with an already existing id.
	 * @return The view /Customer
	 */
	@PutMapping("/customers")
	public String updateCustomer(@ModelAttribute Customer customer) {
		Customer cust_db = cdao.findById(customer.getId()).get();
		cust_db.setFirstName(customer.getFirstName());
		cust_db.setLastName(customer.getLastName());
		cust_db.setPhoneNumber(customer.getPhoneNumber());
		cust_db.setEmailAddress(customer.getEmailAddress());
		cust_db.setAddress(customer.getAddress());
		cust_db.setCity(customer.getCity());
		cust_db.setProvince(customer.getProvince());
		cust_db.setZipCode(customer.getZipCode());
		
		System.out.println("POST");
		System.out.println(cust_db);
		cdao.save(cust_db);
		return "redirect:/customers";
	}
	
	public String deleteCustomer(@ModelAttribute Customer customer) {
		Customer cust_db = cdao.findById(customer.getId()).get();
		cust_db.setActive(false);
		cdao.save(cust_db);
		return "redirect:/customers";
	}
	
	/**
	 * Returns a customer object from an ID
	 * @param id The id of Customer
	 * @return the JSON object of a customer
	 */
	@GetMapping("/customers/{id}")
	@ResponseBody
	public Customer seekPath(@PathVariable String id) {
		try {
			return cdao.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Customer();
		}
	}
	
	/**
	 * Makes customers list available in the view.
	 * @return List of custommers
	 */
	@ModelAttribute("customers")
	public Iterable<Customer> getAll() {
		return cdao.findAllByOrderByFirstNameAsc();
	}
	
}
