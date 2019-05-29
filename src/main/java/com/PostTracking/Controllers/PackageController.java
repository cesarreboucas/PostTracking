package com.PostTracking.Controllers;


import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PostTracking.Entities.Package;

@RestController
public class PackageController {
	
	@GetMapping("/packages")
	public ArrayList<Package> getAll() {
		ArrayList<Package> list = new ArrayList<Package>();
		list.add(new Package(2.0,2.0));
		list.add(new Package(3.0,3.0));
		list.add(new Package(4.0,4.0));
		list.add(new Package(5.0,5.0));
		
		return list;
		
	}
	
}
