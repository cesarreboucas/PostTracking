package com.PostTracking.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleDAO vdao;
	
	 /**
	  * Get all vehicles on the database
	  * @param model The vehicle entity
	  * @return Redirect method to [GET] vehicles
	  */
	@GetMapping("/vehicles")
	public String ShowAll(Model model) {
		// Needed to the form
		model.addAttribute("vehicle", new Vehicle());
		return "vehicles/vehicles";
		
	}
	
	/**
	 * Get the car by the id.
	 * @param id The vehicle entity
	 * @return The vehicle model
	 */
	@GetMapping("/vehicles/{id}")
	@ResponseBody
	public Vehicle seekPath(@PathVariable String id) {
		try {
			return vdao.getVehicle(Integer.parseInt(id));
		} catch(Exception ex) {
			return new Vehicle();
		}
	}
	
	/**
	 * Create a new car based on the model provided.
	 * @param vehicle The new vehicle.
	 * @return Redirect to [GET] Vehicles.
	 */
	@PostMapping("/vehicles")
	public String createVehicle(@ModelAttribute Vehicle vehicle) {
		System.out.println("POST");
		System.out.println(vehicle);
		vdao.createVehicle(vehicle);
		return "redirect:/vehicles";
	}
	
	/**
	 * Update the vehicle based on the id
	 * @param vehicle The vehicle entity with an already existing id.
	 * @return Redirect to [GET] Vehicles.
	 */
	@PutMapping("/vehicles")
	public String updateVehicle(@ModelAttribute Vehicle vehicle) {
		Vehicle hibernateVehicle = vdao.getVehicle(vehicle.getId());
		hibernateVehicle.setDescription(vehicle.getDescription());
		hibernateVehicle.setMaxVolume(vehicle.getMaxVolume());
		hibernateVehicle.setMaxWeight(vehicle.getMaxWeight());
		
		System.out.println("POST");
		System.out.println(hibernateVehicle);
		vdao.updateVehicle(hibernateVehicle);
		return "redirect:/vehicles";
	}
	
	/**
	 * TODO Implement the DAO function for the vehicle delete and structure the 
	 * page to be redirected when the client is trying to delete the vehicle. Maybe
	 * show the routes for them with a confirm button.
	 * <br><br>
	 * Delete the vehicle based on the id
	 * @param id The vehicle id.
	 * @return Redirect to [GET] Vehicles.
	 */
	@DeleteMapping("/vehicles")
	public String deleteVehicle(@RequestParam int id) {
		Vehicle hibernateVehicle = vdao.getVehicle(id);
		//vdao.deleteVehicle(v_db);
		System.out.println("DELETE");
		System.out.println(hibernateVehicle);
		return "redirect:/vehicles";
	}
	
	/**
	 * @return The list of all vehicles available on the database.
	 */
	@ModelAttribute("vehicles")
	public List<Vehicle> getAll() {
		return vdao.getVehicles();
	}
	
}
