package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String ShowAll(Model model) {
		model.addAttribute("dc", new DistributionCenter());
		return "dcs/dcs";	
	}
	
	/**
	 * Returns a customer object from an ID
	 * @param id The id of the Distribution Center
	 * @return the JSON of the Distribution Center
	 */
	@GetMapping("/dc/{id}")
	@ResponseBody
	public DistributionCenter getDistributionCenter(@PathVariable String id) {
		try {
			return dcDAO.findById(Integer.parseInt(id)).get();	
		} catch(Exception ex) {
			return new DistributionCenter();
		}
	}
	
	/**
	 * Create a new customer.
	 * @param distCenter The new distribution center
	 * @return The view of Distribution Center
	 */
	@PostMapping("/dcs")
	public String createDistributionCenter(@ModelAttribute DistributionCenter distCenter) {
		System.out.println("POST");
		System.out.println(distCenter);
		dcDAO.save(distCenter);
		return "redirect:/dcs";
	}
	
	/**
	 * Update the Distribution Center
	 * @param distCenter The distribution center with an already existing id.
	 * @return The view of Distribution Center
	 */
	@PutMapping("/dcs")
	public String updateDistributionCenter(@ModelAttribute DistributionCenter distCenter) {
		DistributionCenter distCenter_db = dcDAO.findById(distCenter.getId()).get();
		distCenter_db.setName(distCenter.getName());
		distCenter_db.setAddress(distCenter.getAddress());
		distCenter_db.setCity(distCenter.getCity());
		distCenter_db.setProvince(distCenter.getProvince());
		distCenter_db.setZipCode(distCenter.getZipCode());
		
		System.out.println("POST");
		System.out.println(distCenter_db);
		dcDAO.save(distCenter_db);
		return "redirect:/dcs";
	}
	
	
	/**
	 * Makes Distribution centers list available in the view.
	 * @return List of Distribution Centers
	 */
	@ModelAttribute("dcs")
	public Iterable<DistributionCenter> getAll() {
		return dcDAO.findAllByOrderByNameAsc();
	}
	
	
}
