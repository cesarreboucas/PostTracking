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
		
		dcArrayList.add(new DistributionCenter("Winterfell","Street s", "The North", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Castle Black","Street s", "The Wall", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Casterly Rock","Street s", "The Reach", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("King's Landing","Street s", "King's Landing", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Storm's End","Street s", "The Stormlands", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Dragonstone","Street s", "Dragonstone", "Blackwater Bay", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Pyke","Street s", "Iron Lands", "The Sunset Sea", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Highgarden","Street s", "The Reach", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Riverrun","Street s", "The Riverlands", "Westeros", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Eyrie","UpperCitty s", "Mountains of the Moon", "The Vale", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Vaes Dothrak","WestCity s", "Dothraki Sea", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Pentos","Street s", "The Flatlands", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Myr","Street s", "The Disputed Lands", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Volantis","Street s", "Volantis", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Mereen","Street s", "Dothraki Sea", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Norvos","Street s", "Hills of Norvos", "Essos", "XNX NXN"));
		dcArrayList.add(new DistributionCenter("Vaes Khadokh","Street s", "Dothraki Sea", "Essos", "XNX NXN"));
		
		for(DistributionCenter dc : dcArrayList) {
			dcDAO.save(dc);
		}
		
		/**************** Vehicles **************/
		ArrayList<Vehicle> vArrayList = new ArrayList<Vehicle>(); 
		vArrayList.add(new Vehicle("Ford F-150", 1500, 1500));
		vArrayList.add(new Vehicle("Dodge Ram 3500", 2500, 2500));
		vArrayList.add(new Vehicle("GMC Sierra 3500HD", 3500, 3500));
		vArrayList.add(new Vehicle("Honda Ridgeline", 2500, 2500));
		for(Vehicle v : vArrayList) {
			vDAO.save(v);
		}
		
		/**************** Customer **************/
		ArrayList<Customer> cArrayList = new ArrayList<Customer>(); 
		cArrayList.add(new Customer("Jon", "Snow", "123-456-7890", "jon.snow@winter.com", "Castle Black", "The Wall", "Westeros", "S0o-F4R"));
		cArrayList.add(new Customer("Ned", "Stark", "898-569-6700", "ned.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Catelyn", "Stark", "898-569-6701", "catelyn.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Robb", "Stark", "898-569-6702", "robb.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Sansa", "Stark", "898-569-6703", "sansa.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Arya", "Stark", "898-569-6704", "arya.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Brandon", "Stark", "898-569-6705", "brandon.stark@winterfell.com", "Winterfell", "The North", "Westeros", "P1P-0I3"));
		cArrayList.add(new Customer("Tyrion", "Lannister", "605-284-5565", "tyrion.lann@casterlyrock.com", "Casterly Rock", "The Reach", "Westeros", "M0N-3Y0"));
		cArrayList.add(new Customer("Jaime", "Lannister", "605-284-5566", "jaime.lann@casterlyrock.com", "Casterly Rock", "The Reach", "Westeros", "M0N-3Y0"));
		cArrayList.add(new Customer("Tyrion", "Lannister", "605-284-5567", "tyrion.lann@casterlyrock.com", "Casterly Rock", "The Reach", "Westeros", "M0N-3Y0"));
		cArrayList.add(new Customer("Robert", "Baratheon", "620-146-8343", "robert.barat@kl.com", "Red Keep", "King's Landing", "Westeros", "K1N-0G0"));
		cArrayList.add(new Customer("Cersei", "Baratheon", "620-146-8344", "cersei@kl.com", "Red Keep", "King's Landing", "Westeros", "K1N-0G0"));
		cArrayList.add(new Customer("Joffrey", "Baratheon", "620-146-8345", "joffrey.barat@kl.com", "Red Keep", "King's Landing", "Westeros", "K1N-0G0"));
		cArrayList.add(new Customer("Myrcella", "Baratheon", "620-146-8346", "myrcella.barat@kl.com", "Red Keep", "King's Landing", "Westeros", "K1N-0G0"));
		cArrayList.add(new Customer("Tommen", "Baratheon", "620-146-8347", "tommen.barat@kl.com", "Red Keep", "King's Landing", "Westeros", "K1N-0G0"));
		cArrayList.add(new Customer("Yara", "Greyjoy", "710-112-4220", "yara.greyjoy@ironlands.com", "Pyke Castle", "Iron Lands", "The Sunset Sea", "I3L-4N0"));
		cArrayList.add(new Customer("Theon", "Greyjoy", "710-112-4221", "theon.greyjoy@ironlands.com", "Pyke Castle", "Iron Lands", "The Sunset Sea", "I3L-4N0"));
		cArrayList.add(new Customer("Olenna", "Tyrell", "371-971-6380", "olenna.tyrell@highgarden.com", "Highgarden", "The Reach", "Westeros", "G4R-0e5"));
		cArrayList.add(new Customer("Margaery", "Tyrell", "371-971-6381", "margaery.tyrell@highgarden.com", "Highgarden", "The Reach", "Westeros", "G4R-0e5"));
		cArrayList.add(new Customer("Loras", "Tyrell", "371-971-6382", "loras.tyrell@highgarden.com", "Highgarden", "The Reach", "Westeros", "G4R-0e5"));
		cArrayList.add(new Customer("Khal", "Drogo", "767-914-3600", "khal.drogo@dothraki.com", "Vaes Dothrak", "Dothraki Sea", "Essos", "D0T-H4K"));
		cArrayList.add(new Customer("Daenerys", "Targaryen", "767-914-3601", "dany.targ@dragons.com", "Vaes Dothrak", "Dothraki Sea", "Essos", "D0T-H4K"));
		cArrayList.add(new Customer("Viserys", "Targaryen", "767-914-3602", "viserys.targ@targ.com", "Vaes Dothrak", "Dothraki Sea", "Essos", "D0T-H4K"));
		cArrayList.add(new Customer("Renly", "Baratheon", "111-486-1930", "renly.barat@stormsend.com", "Storm's End", "The Stormlands", "Westeros", "S1I-R5S"));
		cArrayList.add(new Customer("Stannis", "Baratheon", "890-897-4809", "stannis.barat@dragonstone.com", "Dragonstone Castle", "Dragonstone", "Blackwater Bay", "D5A-6O2"));
		cArrayList.add(new Customer("Brynden", "Tully", "205-933-7071", "brynden.tully@riverrun.com", "Riverrun", "The Riverlands", "Westeros", "V9G-4F6"));
		cArrayList.add(new Customer("Edmure", "Tully", "205-933-7072", "edmure.tully@riverrun.com", "Riverrun", "The Riverlands", "Westeros", "V9G-4F6"));
		cArrayList.add(new Customer("Jon", "Arryn", "349-877-4588", "jon.arryn@eyrie.com", "The Eyrie", "Mountains of the Moon", "The Vale", "V4L-E4E"));
		cArrayList.add(new Customer("Lysa", "Arryn", "349-877-4589", "lysa.arryn@eyrie.com", "The Eyrie", "Mountains of the Moon", "The Vale", "V4L-E4E"));
		for(Customer c : cArrayList) {
			cDAO.save(c);
		}
		
		
		return "<a href=\"/start2\">Second Part</a>";
	}
	
	@GetMapping("/start2")
	@ResponseBody
	public String start2() {
		
		ArrayList<Route> rArrayList = new ArrayList<Route>();
		rArrayList.add(new Route(vDAO.findById(1).get() ,dcDAO.findById(1).get(),dcDAO.findById(2).get(),
				new Timestamp(1558087200000L), 7200000, 86400000, 	true));
		rArrayList.add(new Route(vDAO.findById(1).get(),dcDAO.findById(2).get(), dcDAO.findById(6).get(),
				new Timestamp(1558098000000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.findById(1).get(),dcDAO.findById(6).get(),dcDAO.findById(1).get(),
				new Timestamp(1558108800000L), 7200000, 86400000,true));
		
		rArrayList.add(new Route(vDAO.findById(2).get(),dcDAO.findById(2).get(),dcDAO.findById(4).get(),
				new Timestamp(1558080000000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.findById(2).get(),dcDAO.findById(4).get(),dcDAO.findById(3).get(),
				new Timestamp(1558090800000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.findById(2).get(),dcDAO.findById(3).get(),dcDAO.findById(5).get(),
				new Timestamp(1558105200000L), 5400000, 86400000, true));
		rArrayList.add(new Route(vDAO.findById(2).get(),dcDAO.findById(5).get(),dcDAO.findById(2).get(),
				new Timestamp(1558116000000L), 5400000, 86400000, true));
		
		rArrayList.add(new Route(vDAO.findById(3).get(),dcDAO.findById(1).get(),dcDAO.findById(7).get(),
				new Timestamp(1558087200000L), 7200000, 86400000, true));
		rArrayList.add(new Route(vDAO.findById(3).get(),dcDAO.findById(7).get(), dcDAO.findById(8).get(),
				new Timestamp(1558098000000L), 7200000, 86400000,true));
		rArrayList.add(new Route(vDAO.findById(3).get(),dcDAO.findById(8).get(),dcDAO.findById(1).get(),
				new Timestamp(1558108800000L), 7200000, 86400000,true));
		
		rArrayList.add(new Route(vDAO.findById(4).get(),dcDAO.findById(10).get(),dcDAO.findById(3).get(),
				new Timestamp(1558090800000L),3600000, 86400000,true));
		rArrayList.add(new Route(vDAO.findById(4).get(),dcDAO.findById(3).get(), dcDAO.findById(4).get(),
				new Timestamp(1558099800000L),5400000, 86400000,true));
		rArrayList.add(new Route(vDAO.findById(4).get(),dcDAO.findById(4).get(),dcDAO.findById(10).get(),
				new Timestamp(1558110600000L),5400000, 86400000,true));
		
		for(Route r : rArrayList) {
			rDAO.save(r);
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
		
		return "<a href=\"/\">Index</a>";
	}
}
