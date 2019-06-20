package com.PostTracking.Controllers;


import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.CustomerDAO;
import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.Customer;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;

// https://mockaroo.com/

@Controller
public class Starterkit {
	
	@Autowired
	CustomerDAO cDAO;
	
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
		
		/**************** Customer **************/
		ArrayList<Customer> cArrayList = new ArrayList<Customer>(); 
		cArrayList.add(new Customer("Jon", "Snow", "123-456-7890", "jon.snow@winter.com", "Castle Black", "Frickin Cold", "Westeros", "S0o-F4R"));
		cArrayList.add(new Customer("Barbara", "McRill", "898-569-6799", "bmcrill0@mozilla.com", "27 Bultman Alley", "Maple Ridge", "British Columbia", "V2X"));
		cArrayList.add(new Customer("Jonathon", "Kennermann", "605-284-5565", "jkennermann1@de.vu", "47672 Jenifer Park", "North Vancouver", "British Columbia", "K1B"));
		cArrayList.add(new Customer("Emmery", "Vittery", "620-146-8347", "evittery2@prnewswire.com", "32291 Sachs Parkway", "Delta", "British Columbia", "M2J"));
		cArrayList.add(new Customer("Suzette", "Pietz", "710-112-4229", "spietz3@gmpg.org", "3777 Fulton Trail", "Langley", "British Columbia", "H1V"));
		cArrayList.add(new Customer("Mickey", "Loughan", "371-971-6381", "mloughan4@wordpress.com", "88 Loomis Lane", "Burnaby", "British Columbia", "V4C"));
		cArrayList.add(new Customer("Marthena", "Pestor", "767-914-3602", "mpestor5@hp.com", "4 Bartelt Drive", "Delta", "British Columbia", "H9G"));
		cArrayList.add(new Customer("Jeffrey", "Eisikovitsh", "111-486-1930", "jeisikovitsh6@google.pl", "970 Holy Cross Pass", "Vancouver", "British Columbia", "H1V"));
		cArrayList.add(new Customer("Elfrida", "Rooma", "890-897-4809", "erooma7@vk.com", "5 Summit Alley", "Langley", "British Columbia", "H1V"));
		cArrayList.add(new Customer("Annadiana", "Gantz", "205-933-7071", "agantz8@ameblo.jp", "26 Ronald Regan Avenue", "Langley", "British Columbia", "V9G"));
		cArrayList.add(new Customer("Moe", "Dishmon", "349-877-4588", "mdishmon9@netvibes.com", "56801 Westerfield Street", "Langley", "British Columbia", "V2A"));
		cArrayList.add(new Customer("Lindsey", "Leavey", "907-229-1353", "lleaveya@cisco.com", "3 Sycamore Place", "North Vancouver", "British Columbia", "V9A"));
		cArrayList.add(new Customer("Adilson", "Hill", "257-401-8656", "ahill@wired.com", "2 Sullivan Street", "Coquitlam", "British Columbia", "V9P"));
		cArrayList.add(new Customer("Leighton", "Jeannard", "830-331-5515", "ljeannardc@dot.gov", "0 Troy Avenue", "North Vancouver", "British Columbia", "V9C"));
		cArrayList.add(new Customer("Venita", "Fison", "808-411-6301", "vfisond@admin.ch", "0720 5th Avenue", "Delta", "British Columbia", "G2L"));
		cArrayList.add(new Customer("Orbadiah", "Bly", "755-505-1253", "oblye@hatena.ne.jp", "3863 Rowland Drive", "Coquitlam", "British Columbia", "E1W"));
		cArrayList.add(new Customer("Justine", "Gives", "793-964-3078", "jgivesf@symantec.com", "8490 Truax Terrace", "Coquitlam", "British Columbia", "L9T"));
		cArrayList.add(new Customer("Markos", "Oki", "889-612-4366", "mokig@liveinternet.ru", "168 Wayridge Place", "Maple Ridge", "British Columbia", "M2J"));
		cArrayList.add(new Customer("Dante", "Bispo", "521-104-6254", "dbispoh@msn.com", "24 Grasskamp Junction", "Richmond", "British Columbia", "V7Y"));
		cArrayList.add(new Customer("Elana", "Tripet", "328-662-7976", "etripeti@cocolog-nifty.com", "44 Meadow Vale Parkway", "Vancouver", "British Columbia", "V6L"));
		cArrayList.add(new Customer("Eduard", "Catterell", "360-163-7077", "ecatterellj@who.int", "0 Sherman Hill", "North Vancouver", "British Columbia", "M2J"));
		for(Customer c : cArrayList) {
			cDAO.createCustomer(c);
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
