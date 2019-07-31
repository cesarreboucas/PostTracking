package com.PostTracking.Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleDAO vdao;
	@Autowired
	RouteDAO rDAO;
	
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
	 * Returns a JSON object of Vehicles to the API
	 * @return JSON vehicles
	 */
	@GetMapping("/api/vehicles")
	@ResponseBody
	public List<Vehicle> getAllVehicles() {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		getAll().forEach(v -> vehicles.add(v));
		return vehicles;
	}
	
	/**
	 * Get the car by the id.
	 * @param id The vehicle entity
	 * @return The vehicle model
	 */
	@GetMapping("/vehicles/{id}")
	@ResponseBody
	public Vehicle getVehicle(@PathVariable String id) {
		try {
			return vdao.findById(Integer.parseInt(id)).get();
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
	public ResponseEntity<?> createVehicle(@ModelAttribute Vehicle vehicle) {
		try {
			vdao.save(vehicle);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Vehicle saved successfully", HttpStatus.OK);
	}
	
	/**
	 * Update the vehicle based on the id
	 * @param vehicle The vehicle entity with an already existing id.
	 * @return Redirect to [GET] Vehicles.
	 */
	@PutMapping("/vehicles")
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			System.out.println(vehicle);
			Optional<Vehicle> hibernateVehicle = vdao.findById(vehicle.getId());
			if(!hibernateVehicle.isPresent()) {
				return new ResponseEntity<String>("Vehicle not found", HttpStatus.NOT_FOUND);
			}
			hibernateVehicle.get().setDescription(vehicle.getDescription());
			hibernateVehicle.get().setMaxVolume(vehicle.getMaxVolume());
			hibernateVehicle.get().setMaxWeight(vehicle.getMaxWeight());
			hibernateVehicle.get().setAvailable(vehicle.isAvailable());
			vdao.save(hibernateVehicle.get());	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<String>("Vehicle edited successfully", HttpStatus.OK);
	}
	
	/**
	 * page to be redirected when the client is trying to delete the vehicle. Maybe
	 * show the routes for them with a confirm button.
	 * <br><br>
	 * Delete the vehicle based on the id
	 * @param id The vehicle id.
	 * @return Redirect to [GET] Vehicles.
	 */
	@DeleteMapping("/vehicles")
	public String deleteVehicle(@RequestParam int id) {
		Vehicle hibernateVehicle = vdao.findById(id).get();
		hibernateVehicle.setDeleted(true);
		hibernateVehicle.setAvailable(false);
		vdao.save(hibernateVehicle);
		return "redirect:/vehicles";
	}

	/**
	 * For some reason the vehicle entities isn't comming with the routes, so I had to create this 
	 * endpoint to filter the routes based on the vehicle id.
	 * @param vehicleId
	 * @return A list of routes filtered by the vehicleId.
	 */
	@GetMapping("/api/vehicle/{id}/routes")
	@ResponseBody
	public List<Journey> getVehicleRoutes(@PathVariable("id") int vehicleId) {
		System.out.println("[/api/vehicle/:id/routes] " + vehicleId);
		List<Journey> vehicleRoutes = new ArrayList<>();
		rDAO.findAllByVehicle(vehicleId).forEach(route -> vehicleRoutes.add(route));
		return vehicleRoutes;
	}
	
	/**
	 * @return The list of all vehicles available on the database.
	 */
	@ModelAttribute("vehicles")
	public Iterable<Vehicle> getAll() {
		return vdao.fetchVehicles();
	}
	
}
