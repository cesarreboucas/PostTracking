package com.PostTracking.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Package;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleDAO vdao;
	
	@GetMapping("/vehicles")
	public String ShowAll() {
		return "vehicles/vehicles";
		
	}
	
	@ModelAttribute("vehicles")
	public List<Vehicle> getAll() {
		List<Vehicle>  list = vdao.getVehicles();
		return list;
	}
	
	@GetMapping("/vehicles/add")
	public String CreateVehicle() {
		return null;
		
	}
}
