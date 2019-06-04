package com.PostTracking.Controllers;

import java.sql.Timestamp;
import java.util.ArrayList;


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
		
		DistributionCenter surrey = new DistributionCenter(1, "Surrey");
		DistributionCenter newWestminster = new DistributionCenter(2, "New Westminster");
		DistributionCenter vancouver = new DistributionCenter(3, "Vancouver");
		DistributionCenter burnaby = new DistributionCenter(4, "Burnaby");
		DistributionCenter richmond = new DistributionCenter(5, "Richmond");
		DistributionCenter coquitlam = new DistributionCenter(6, "Coquitlam");
		DistributionCenter langley = new DistributionCenter(7, "Langley");
		DistributionCenter mapleRidge = new DistributionCenter(8, "Maple Ridge");

		Vehicle v1 = new Vehicle("Truck_001", 1500, 1500);
		Vehicle v2 = new Vehicle("Truck_002", 2500, 2500);
		Vehicle v3 = new Vehicle("Truck_003", 3500, 3500);

		ArrayList<Route> list = new ArrayList<Route>();
		list.add(new Route(1,v1,surrey,	newWestminster,
				new Timestamp(1558087200000L), // 17 - May - 2019 10:00
				7200000, //2 hours
				86400000, // 1 days
				true));
		list.add(new Route(2,v1,newWestminster, coquitlam,
				new Timestamp(1558098000000L), // 17 - May - 2019 13:00
				7200000, //2 hours
				86400000, // 1 days
				true));
		list.add(new Route(3,v1,coquitlam,	surrey,
				new Timestamp(1558108800000L), // 17 - May - 2019 16:00
				7200000, // 2 hours
				86400000, // 1 days
				true));
		
		// V2
		list.add(new Route(4,v2,newWestminster,	burnaby,
				new Timestamp(1558080000000L), // 17 - May - 2019 8:00
				7200000, // 2 horas
				86400000, // 1 days
				true));
		list.add(new Route(5,v2,burnaby,vancouver,
				new Timestamp(1558090800000L), // 17 - May - 2019 11:00
				7200000, // 2 horas
				86400000, // 1 days
				true));
		list.add(new Route(6,v2,vancouver,richmond,
				new Timestamp(1558105200000L), // 17 - May - 2019 15:00
				5400000, // 1.5 horas
				86400000, // 1 days
				true));
		list.add(new Route(7,v2,richmond,newWestminster,
				new Timestamp(1558116000000L), // 17 - May - 2019 18:00
				5400000, // 1.5 horas
				86400000, // 1 days
				true));
		// V3
		list.add(new Route(8,v3,surrey,	langley,
				new Timestamp(1558087200000L), // 17 - May - 2019 10:00
				7200000, //2 hours
				86400000, // 1 days
				true));
		list.add(new Route(9,v3,langley, mapleRidge,
				new Timestamp(1558098000000L), // 17 - May - 2019 13:00
				7200000, //2 hours
				86400000, // 1 days
				true));
		list.add(new Route(10,v3,mapleRidge,	surrey,
				new Timestamp(1558108800000L), // 17 - May - 2019 16:00
				7200000, // 2 hours
				86400000, // 1 days
				true));
		
		return list;
		
		
	}
	
}

