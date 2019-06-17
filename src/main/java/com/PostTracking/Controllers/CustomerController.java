package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.PostTracking.Boundaries.CustomerDAO;
import com.PostTracking.Entities.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO cdao;

	@GetMapping("/customers")
	public String ShowAll() {
		return "customers/customers";
	}
	
	@GetMapping("/customers/add")
	public String CreateCustomer() {
		Customer c1 = new Customer("Jon", "Snow", "123-456-7890", "snow.jon@winter.com", "Castle Black", "Frickin Cold", "Westeros", "S0o-F4R");
		cdao.createCustomer(c1);
		return "customers/customers";
		
	}
	
}
