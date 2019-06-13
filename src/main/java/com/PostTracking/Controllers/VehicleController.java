package com.PostTracking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@GetMapping("/vehicles")
	public String ShowAll() {
		return "vehicles/vehicles";
		
	}
	
	@GetMapping("/vehicles/add")
	public String CreateVehicle() {
		/*VehicleDAO vd = new VehicleDAO();
		Vehicle v = new Vehicle("Truck001", 1500, 1500);
		vd.createCar(v);*/
		DistributionCenter dc = new DistributionCenter(0, "AAA");
		DistributionCenterDAO dao = new DistributionCenterDAO();
		dao.createDistributionCenter(dc);
		return "vehicles/vehicles";
		
	}
}
