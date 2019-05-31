package com.PostTracking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

	@GetMapping("/routes")
	public String getAll() {
		return "routes/routes";
	}
	
}
