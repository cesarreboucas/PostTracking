package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.PostTracking.Boundaries.CustomerDAO;
import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.JourneyDAO;
import com.PostTracking.Boundaries.PackageDAO;
import com.PostTracking.Entities.Customer;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Package;


/**
 * Controller for Journey entity
 * 
 * @author 300296145
 *
 */
@Controller
public class JourneyController {

	@Autowired
	JourneyDAO jDAO;
	@Autowired
	CustomerDAO cDAO;
	@Autowired
	DistributionCenterDAO dcDAO;
	@Autowired
	PackageDAO pDAO;

	/**
	 * Maps /journeys/{id}
	 * 
	 * @param id    the Id of the Package
	 * @param model the Model to be sent to the view
	 * @return the view for a specific journey
	 */
	@GetMapping("/journeys/{id}")
	public String showPackages(@PathVariable String id, Model model) {
		model.addAttribute("journey", jDAO.findById(Long.parseLong(id)).get());
		model.addAttribute("package", new Package());
		return "journeys/journeysDetail";
	}
	
	@GetMapping("/journeys")
	public String showJourneys() {	
		return "journeys/journeys";
	}

	@GetMapping("/journeys/checkpackages/{journey_id}")
	public ResponseEntity<?> checkPackages(@PathVariable String journey_id) {
		long id;
		try{
			id = Integer.parseInt(journey_id);
		} catch(Exception e) {
			return new ResponseEntity<String>("Impossible to recognize the Journey ID", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		Journey j = jDAO.findById(id).get();
		if(j==null) {
			return new ResponseEntity<String>("Impossible to request the Journey", HttpStatus.NOT_FOUND);	
		}
		for(Package p : j.getPackages()) {
			if(j.getOrigin().getId()==p.getPosition().getId()) {
				p.setPosition(j.getDestination());
				pDAO.save(p);
			} 			
		}
		return new ResponseEntity<String>(j.getDestination().getName(), HttpStatus.OK);
	}

	@ModelAttribute("journeys")
	public Iterable<Journey> getAll() {
		return jDAO.findAll();
	}

	@ModelAttribute("filledJourneys")
	public Iterable<Journey> getAllFilled() {
		return jDAO.findFilled();
	}

	/**
	 * Makes the Distribution Centers list available to the view Add package
	 * 
	 * @return list of distribution centers
	 */
	@ModelAttribute("distributionCenters")
	public Iterable<DistributionCenter> getDistributionCentes() {
		return dcDAO.fetchDCs();
	}

	/**
	 * Makes the Customer list available to the view Add package
	 * 
	 * @return list of Customers
	 */
	@ModelAttribute("customers")
	public Iterable<Customer> getCustomers() {
		return cDAO.findAll();
	}
}
