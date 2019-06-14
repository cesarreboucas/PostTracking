package com.PostTracking.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Entities.DistributionCenter;


@Controller
public class DCController {
	
	@Autowired
	DistributionCenterDAO dcDAO;
	
	@GetMapping("/dcs")
	public String ShowAll() {
		return "dcs/dcs";	
	}
	
	@GetMapping("/dc/{id}")
	@ResponseBody
	public DistributionCenter seekPath(@PathVariable String id) {
		try {
			return dcDAO.getDistributionCenter(Integer.parseInt(id));
		} catch(Exception ex) {
			return new DistributionCenter();
		}
		
	}
	
	@ModelAttribute("dcs")
	public List<DistributionCenter> getAll() {
		return dcDAO.getDistributionCenters();
	}
	
	
}
