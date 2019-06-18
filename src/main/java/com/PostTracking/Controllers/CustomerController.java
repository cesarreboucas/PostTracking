package com.PostTracking.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.CustomerDAO;
import com.PostTracking.Entities.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO cdao;

	@GetMapping("/customers")
	public String ShowAll(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers/customers";
	}
	
	@PostMapping("/customers/{id}")
	public String createcustomerView(@ModelAttribute Customer cust, @PathVariable int id, 
			@RequestParam(required=false,name="chkDelete") String chkDelete) {
		// chkDelete can be null or on!
		if(id==0) {
			cdao.createCustomer(cust);
		} else {
			Customer cust_db = cdao.getCustomer(id);
			cust_db.setFirstName(cust.getFirstName());
			cust_db.setLastName(cust.getLastName());
			cust_db.setPhoneNumber(cust.getPhoneNumber());
			cust_db.setEmailAddress(cust.getEmailAddress());
			cust_db.setAddress(cust.getAddress());
			cust_db.setCity(cust.getCity());
			cust_db.setProvince(cust.getProvince());
			cust_db.setZipCode(cust.getZipCode());
			cdao.updateCustomer(cust_db);
		}
		
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/{id}")
	@ResponseBody
	public Customer seekPath(@PathVariable String id) {
		try {
			return cdao.getCustomer(Integer.parseInt(id));
		} catch(Exception ex) {
			return new Customer();
		}
	}
	
	@ModelAttribute("customers")
	public List<Customer> getAll() {
		return cdao.listCustomers();
	}
	
}
