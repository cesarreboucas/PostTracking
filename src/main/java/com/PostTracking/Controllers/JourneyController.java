package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.PostTracking.Boundaries.JourneyDAO;
import com.PostTracking.Entities.Journey;

@Controller
public class JourneyController {
	
	@Autowired
	JourneyDAO jDAO;
	
	@GetMapping("/journeys/{id}")
	public String showPackages(@PathVariable String id,Model model) {
		model.addAttribute("journey",jDAO.findById(Integer.parseInt(id)).get());
		return "journeys/journeys";
	}

	@ModelAttribute("journeys")
	public Iterable<Journey> getAll() {	
		return jDAO.findAll();
	}
}
