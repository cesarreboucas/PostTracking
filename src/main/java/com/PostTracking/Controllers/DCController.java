package com.PostTracking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DCController {
	
	@GetMapping("/dcs")
	public String ShowAll() {
		return "dcs/dcs";
		
	}
}
