package com.PostTracking.Controllers;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;
import com.PostTracking.Models.VehiclePath;
import com.PostTracking.Models.VehiclePaths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RouteController {

	@Autowired
	RouteDAO rDAO;
	@Autowired
	VehicleDAO vDAO;
	@Autowired
	DistributionCenterDAO dcDAO;
	@Autowired
	VehicleController vController;
	
	/**
	 * Get all routes from the database.
	 * @param m The model that will be sent to the view.
	 * @return The view representing routes
	 */
	@GetMapping("/routes")
	public String showAll(Model m) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vController.getAll().iterator().forEachRemaining(vehicles::add);
		List<Route> routes = new ArrayList<Route>();
		rDAO.findAll().iterator().forEachRemaining(routes::add);

		for(int i=0; i < routes.size(); ++i) {
			int pos =  vehicles.indexOf(routes.get(i).getVehicle());
			vehicles.get(pos).addRoute(routes.get(i));
		}
		m.addAttribute("vehicles", vehicles);
		return "routes/routes";
	}

	/**
	 * Receive a json object of a list of routes. <br>
	 * This method was made for the api, since it just return respose string and not views.
	 * @param routes List of routes.
	 * @return The http status with a response message.
	 */
	@PostMapping("/api/routes")
	public ResponseEntity<?> createRoute(@RequestBody List<Route> routes) {
		try {
			// Do the same validations as the front end
			if(routes.size() < 2) {
				return new ResponseEntity<String>("There should be al least 2 routes", HttpStatus.BAD_REQUEST);
			}
			for (int i=0; i<routes.size(); i++) {
				if(routes.get(i).getOrigin().getId() == routes.get(i).getDestination().getId()) {
					return new ResponseEntity<String>(String.format("Origin and destination of route %d shouldnt be the same", i + 1), HttpStatus.BAD_REQUEST);
				}
				if(routes.get(i).getDuration() <= 0) {
					return new ResponseEntity<String>(String.format("Destination of route %d should be bigger than origin", i + 1), HttpStatus.BAD_REQUEST);
				}
				if(i>=1) {
					if(routes.get(i).getOrigin().getId() != routes.get(i-1).getDestination().getId()) {
						return new ResponseEntity<String>(String.format("Route %d origin should be the same as route %d destiny", i+1, i), HttpStatus.BAD_REQUEST);
					} else if(routes.get(i).getStart().getTime() <= routes.get(i-1).getStart().getTime()) {
						return new ResponseEntity<String>(String.format("Route %d start should be bigger than route %d start", i+1, i), HttpStatus.BAD_REQUEST);
					}
				}
			}
			if(routes.get(0).getOrigin().getId() != routes.get(routes.size() - 1).getDestination().getId()) {
				return new ResponseEntity<String>(String.format("Route %d destination should be the same as route %d origin", routes.size(), 1), HttpStatus.BAD_REQUEST);
			}

			for (int i=0; i<routes.size(); i++) {
				System.out.println(routes.get(i));
				int vehicleId = routes.get(i).getVehicle().getId();
				int originId = routes.get(i).getOrigin().getId();
				int destinationId = routes.get(i).getDestination().getId();

				Optional<Vehicle> vehicle = vDAO.findById(vehicleId);
				if(vehicle.isPresent()) {
					routes.get(i).setVehicle(vehicle.get());
				} else {
					return new ResponseEntity<String>("Vehicle "+ vehicleId +" not found", HttpStatus.NOT_FOUND);
				}

				Optional<DistributionCenter> origin = dcDAO.findById(originId);
				if(origin.isPresent()) {
					routes.get(i).setOrigin(origin.get());
				} else {
					return new ResponseEntity<String>("Origin "+ originId +" not found", HttpStatus.NOT_FOUND);
				}

				Optional<DistributionCenter> destination = dcDAO.findById(destinationId);
				if(destination.isPresent()) {
					routes.get(i).setDestination(destination.get());
				} else {
					return new ResponseEntity<String>("Destination "+ destinationId +" not found", HttpStatus.NOT_FOUND);
				}

				routes.get(i).setAvailable(true);
				// Using the restart calculation as follow:
				// Number of DC * 21600 (6 hours).
				System.out.println("Restart: " + (routes.size() * 21600000));
				routes.get(i).setRestart(routes.size() * 21600000);
			 }
			 
			 rDAO.saveAll(routes);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<String>("Routes created successfully", HttpStatus.OK);
	}

	/**
	 * @return A model exposed to a web view.
	 */
	@ModelAttribute("routes")
	public Iterable<Route> getAll() {
		return rDAO.findAll();
	}
}

