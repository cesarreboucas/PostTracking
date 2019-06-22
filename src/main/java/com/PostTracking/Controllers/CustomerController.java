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
	 * Handles the new customer and the edition of an existing customer                                                                                                              
	 * @param cust Customer that comes from the form
	 * @param id Id from Customer (when it is already mapped)
	 * @param chkDelete If the checkbox delete is Chacked
	 * @return The view /Customer
	 */
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
	
	/**
	 * Returns a customer object from an ID
	 * @param id The id of Customer
	 * @return the JSON object of a customer
	 */
	@GetMapping("/customers/{id}")
	@ResponseBody
	public Customer seekPath(@PathVariable String id) {
		try {
			return cdao.getCustomer(Integer.parseInt(id));
		} catch(Exception ex) {
			return new Customer();
		}
	}
	
	/**
	 * Makes customers list available in the view.
	 * @return List of custommers
	 */
	@ModelAttribute("customers")
	public List<Customer> getAll() {
		return cdao.listCustomers();
	}
	
}
