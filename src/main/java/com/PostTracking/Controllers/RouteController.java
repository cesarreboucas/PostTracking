package com.PostTracking.Controllers;


import java.util.List;

import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RouteController {

	@Autowired
	RouteDAO rDAO;
	@Autowired
	VehicleController vController;
	
	@GetMapping("/routes")
	public String showAll(Model m) {
		List<Vehicle> vehicles = vController.getAll();
		List<Route> routes = rDAO.getRoutes();
		for(int i=0; i < routes.size(); ++i) {
			int pos = vehicles.indexOf(routes.get(i).getVehicle());
			vehicles.get(pos).addRoute(routes.get(i));
		}
		m.addAttribute("vehicles", vehicles);
		return "routes/routes";
	}

	@ModelAttribute("routes")
	public List<Route> getAll() {
		List<Route> list = rDAO.getRoutes();
		return list;
	}
}

