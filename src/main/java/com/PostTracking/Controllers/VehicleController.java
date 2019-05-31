package com.PostTracking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VehicleController {
	
	@GetMapping("/vehicles")
	public String ShowAll() {
		return "vehicles/vehicles";
		
	}
}
