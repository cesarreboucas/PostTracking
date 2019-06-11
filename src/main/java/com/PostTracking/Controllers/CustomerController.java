package com.PostTracking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@GetMapping("/customers")
	public String ShowAll() {
		return "customers/customers";
		
	}
	
}
