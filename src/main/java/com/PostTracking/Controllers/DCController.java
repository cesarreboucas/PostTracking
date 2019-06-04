package com.PostTracking.Controllers;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.PostTracking.Entities.DistributionCenter;

@Controller
public class DCController {
	
	@GetMapping("/dcs")
	public String ShowAll() {
		return "dcs/dcs";
		
	}
	
	@ModelAttribute("routes")
	public ArrayList<DistributionCenter>  getAll() {
		return null;
		
	}
	
	
}
