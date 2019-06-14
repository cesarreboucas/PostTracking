package com.PostTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	DistributionCenterDAO dao;
	@Autowired
	VehicleDAO vdao;
	
	@GetMapping("/vehicles")
	public String ShowAll() {
		return "vehicles/vehicles";
		
	}
	
	@GetMapping("/vehicles/add")
	public String CreateVehicle() {
		/*VehicleDAO vd = new VehicleDAO();*/
		Vehicle v = new Vehicle("Truck001", 1500, 1500);
		vdao.createVehicle(v);
		
		/*DistributionCenter dc = new DistributionCenter(15003,"name");
		dc.setName("name");
		dc.setAddress("address");
		dao.createDistributionCenter(dc);*/
		return "vehicles/vehicles";
		
	}
}
