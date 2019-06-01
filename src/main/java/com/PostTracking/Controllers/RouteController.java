package com.PostTracking.Controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RouteController {

	@GetMapping("/routes")
	public String showAll() {
		return "routes/routes";
	}

	@ModelAttribute("routes")
	public ArrayList<Route> getAll() {
		
		DistributionCenter surrey = new DistributionCenter("Surrey");
		DistributionCenter newWestminster = new DistributionCenter("New Westminster");
		DistributionCenter vancouver = new DistributionCenter("Vancouver");
		DistributionCenter burnaby = new DistributionCenter("Burnaby");
		DistributionCenter richmond = new DistributionCenter("Richmond");

		Vehicle v1 = new Vehicle("Truck_001", 1500, 1500);
		Vehicle v2 = new Vehicle("Truck_002", 2500, 2500);

		ArrayList<Route> list = new ArrayList<Route>();
		list.add(
			new Route(
					1,v1,
					surrey,
					newWestminster,
					new Timestamp(485172000000L), // 17 - May - 2019 10am
					172800000, // 2 days
					0,true),
			new Route(
						1,v1,
						new Timestamp(1558087200000L), // 17 - May - 2019 10am
						172800000, // 2 days
						0,true),
			);
		
	
		return list;
		
		
	}
	
}
