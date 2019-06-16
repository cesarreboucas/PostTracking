package com.PostTracking.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.PostTracking.Boundaries.VehicleDAO;
import com.PostTracking.Entities.Vehicle;


@Controller
public class VehicleController {
	
	@Autowired
	VehicleDAO vdao;
	
	@GetMapping("/vehicles")
	public String ShowAll(Model model) {
		// Needed to the form
		model.addAttribute("vehicle", new Vehicle());
		return "vehicles/vehicles";
		
	}
	
	@PostMapping("/vehicles/{id}")
	public String createVehicleView(@ModelAttribute Vehicle v, @PathVariable int id, 
			@RequestParam(required=false,name="chkDelete") String chkDelete) {
		// chkDelete can be null or on!
		if(id==0) {
			vdao.createVehicle(v);
		} else {
			Vehicle v_db = vdao.getVehicle(id);
			v_db.setDescription(v.getDescription());
			v_db.setMaxVolume(v.getMaxVolume());
			v_db.setMaxWeight(v.getMaxWeight());
			vdao.updateVehicle(v_db);
		}
		
		return "redirect:/vehicles";
	}
	
	@GetMapping("/vehicles/{id}")
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
