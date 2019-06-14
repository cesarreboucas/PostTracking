package com.PostTracking.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleDAO vdao;
	
	@GetMapping("/vehicles")
	public String ShowAll() {
		return "vehicles/vehicles";
		
	}
	
	@GetMapping("/vehicles/add")
	public String createVehicleView() {
		return null;
	}
	
	@GetMapping("/vehicle/{id}")
	@ResponseBody
	public Vehicle seekPath(@PathVariable String id) {
		try {
			return vdao.getVehicle(Integer.parseInt(id));
		} catch(Exception ex) {
			return new Vehicle();
		}
	}
	
	@ModelAttribute("vehicles")
	public List<Vehicle> getAll() {
		return vdao.getVehicles();
	}
}
