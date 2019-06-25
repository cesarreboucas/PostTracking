package com.PostTracking.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Entities.DistributionCenter;

/**
 * Controls the endpoints for the Distribution Centers
 * @author 300296145
 *
 */
@Controller
public class DCController {
	
	@Autowired
	DistributionCenterDAO dcDAO;
	
	/**
	 * Maps /dcs (List of all Distribution Centers)
	 * @return the View for all Distribution Centers
	 */
	@GetMapping("/dcs")
	public String ShowAll() {
		return "dcs/dcs";	
	}
	
	/**
	 * Returns a customer object from an ID
	 * @param id The id of the Distribution Center
	 * @return the JSON of the Distributuion Center
	 */
	@GetMapping("/dc/{id}")
	@ResponseBody
	public DistributionCenter getDistributionCenter(@PathVariable String id) {
		try {
			Optional<DistributionCenter> dc = dcDAO.findById(Integer.parseInt(id));
			if(dc.isPresent()) {
				return dc.get();	
			} else {
				return new DistributionCenter();
			}
			
		} catch(Exception ex) {
			return new DistributionCenter();
		}
	}
	
	/**
	 * Makes Distribution centers list available in the view.
	 * @return List of Distribution Centers
	 */
	@ModelAttribute("dcs")
	public Iterable<DistributionCenter> getAll() {
		return dcDAO.findAll();
	}
	
	
}
