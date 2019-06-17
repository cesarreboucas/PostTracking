package com.PostTracking.Controllers;


import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;

@Controller
public class Starterkit {
	
	@Autowired
	DistributionCenterDAO dcDAO;
	
	@Autowired
	VehicleDAO vDAO;
	
	@Autowired
	RouteDAO rDAO;
	
	@GetMapping("/start")
	@ResponseBody
	public String start() {
		
		/****************Distribution Centers ***************/
		
		ArrayList<DistributionCenter> dcArrayList = new ArrayList<DistributionCenter>();
		
		dcArrayList.add(new DistributionCenter("Surrey","Street s", "SurreyCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("New Westminster","Street s", "New West", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Vancouver","Street s", "VanCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Burnaby","Street s", "BurnabyCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Richmond","Street s", "Rich", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Coquitlam","Street s", "CoquitlamCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Langley","Street s", "SouthCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Maple Ridge","Street s", "Maple", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Delta","Street s", "DeltaCity", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("North Vancouver","UpperCitty s", "UpperCitty", "BC", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("West Point Grey","WestCity s", "WestCity", "BC", "XNX NXN"));
		
		for(DistributionCenter dc : dcArrayList) {
			dcDAO.createDistributionCenter(dc);
		}
		
		/**************** Vehicles **************/
		ArrayList<Vehicle> vArrayList = new ArrayList<Vehicle>(); 
		vArrayList.add(new Vehicle("Ford F-150", 1500, 1500));
		vArrayList.add(new Vehicle("Dodge Ram 3500", 2500, 2500));
		vArrayList.add(new Vehicle("GMC Sierra 3500HD", 3500, 3500));
		vArrayList.add(new Vehicle("Honda Ridgeline", 2500, 2500));
		for(Vehicle v : vArrayList) {
			vDAO.createVehicle(v);
		}
		
		return "{\"ok\"=1}";
	}
	
	@GetMapping("/start2")
	@ResponseBody
	public String start2() {
		
		ArrayList<Route> rArrayList = new ArrayList<Route>();
		rArrayList.add(new Route(vDAO.getVehicle(1) ,dcDAO.getDistributionCenter(1),dcDAO.getDistributionCenter(2),
				new Timestamp(1558087200000L), 7200000, 86400000, 	true));
		rArrayList.add(new Route(vDAO.getVehicle(1),dcDAO.getDistributionCenter(2), dcDAO.getDistributionCenter(6),
				new Timestamp(1558098000000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.getVehicle(1),dcDAO.getDistributionCenter(6),	dcDAO.getDistributionCenter(1),
				new Timestamp(1558108800000L), 7200000, 86400000,true));
		
		rArrayList.add(new Route(vDAO.getVehicle(2),dcDAO.getDistributionCenter(2),	dcDAO.getDistributionCenter(4),
				new Timestamp(1558080000000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.getVehicle(2),dcDAO.getDistributionCenter(4),dcDAO.getDistributionCenter(3),
				new Timestamp(1558090800000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.getVehicle(2),dcDAO.getDistributionCenter(3),dcDAO.getDistributionCenter(5),
				new Timestamp(1558105200000L), 5400000, 86400000, true));
		rArrayList.add(new Route(vDAO.getVehicle(2),dcDAO.getDistributionCenter(5),dcDAO.getDistributionCenter(2),
				new Timestamp(1558116000000L), 5400000, 86400000, true));
		
		rArrayList.add(new Route(vDAO.getVehicle(3),dcDAO.getDistributionCenter(1),	dcDAO.getDistributionCenter(7),
				new Timestamp(1558087200000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.getVehicle(3),dcDAO.getDistributionCenter(7), dcDAO.getDistributionCenter(8),
				new Timestamp(1558098000000L), 7200000, 86400000,true));
		rArrayList.add(new Route(vDAO.getVehicle(3),dcDAO.getDistributionCenter(8),	dcDAO.getDistributionCenter(1),
				new Timestamp(1558108800000L), 7200000, 86400000,true));
		
		rArrayList.add(new Route(vDAO.getVehicle(4),dcDAO.getDistributionCenter(10),dcDAO.getDistributionCenter(3),
				new Timestamp(1558090800000L),3600000, 86400000,true));
		rArrayList.add(new Route(vDAO.getVehicle(4),dcDAO.getDistributionCenter(3), dcDAO.getDistributionCenter(4),
				new Timestamp(1558099800000L),5400000, 86400000,true));
		rArrayList.add(new Route(vDAO.getVehicle(4),dcDAO.getDistributionCenter(4),	dcDAO.getDistributionCenter(10),
				new Timestamp(1558110600000L),5400000, 86400000,true));
		
		for(Route r : rArrayList) {
			rDAO.createRoute(r);
		}
		
/*
		
		// V4
		list.add(new Route(11,v4,northvan,	vancouver,
				new Timestamp(1558090800000L),3600000,86400000,true));
		
		list.add(new Route(12,v4,vancouver, burnaby,
				new Timestamp(1558099800000L), 
				5400000, //1.5 hours
				86400000, // 1 days
				true));
		list.add(new Route(13,v4,burnaby,	northvan,
				new Timestamp(1558110600000L), 
				5400000, // 1.5 hours
				86400000, // 1 days
				true));*/
		
		
		/*
		DistributionCenter dc = new DistributionCenter(15003,"name");
		dc.setName("name");
		dc.setAddress("address");
		dcDAO.createDistributionCenter(dc);*/
		
		return "{\"ok\"=2}";
	}
}
