package com.PostTracking.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.PostTracking.Boundaries.JourneyDAO;
import com.PostTracking.Entities.Journey;

@Controller
public class JourneyController {
	
	@Autowired
	JourneyDAO jDAO;
	
	@ModelAttribute("journeys")
	public Iterable<Journey> getAll() {	
		return jDAO.findAll();
	}
}
