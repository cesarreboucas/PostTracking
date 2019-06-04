package com.PostTracking.Controllers;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Package;
import com.PostTracking.Entities.Path;
import com.PostTracking.Entities.Route;

@Controller
public class PackageController {
	
	@GetMapping("/packages")
	public String showAll() {
		return "packages/packages";
	}
	
	@GetMapping("/packages/add")
	public String insert(Model model) {
		model.addAttribute("chave", "Valor");
		return "packages/add";
	}
	
	@GetMapping("/packages/seekpath")
	@ResponseBody
	public ArrayList<Path> test() {
		//test from 1 to 3
		ArrayList<Path> paths = new ArrayList<Path>();
		Journey[] journeys = getNextJourneys();
		
		int origin_id = 1; // Surrey
		int destination_id = 3; // Vancouver
		
		
		//paths.add(p_initial);
		boolean changed = true;

		// Initializing paths
		paths.add(new Path(origin_id));
				
		while(changed) {
			changed = false;
			for(int x=0; x < paths.size(); ++x) {
				for(int i=0 ; i < journeys.length; ++i) {
					if(journeys[i].getOrigin().getId() == paths.get(x).getPosition() && 
							!paths.get(x).checkAlreadyVisited(journeys[i].getDestination().getId()) &&
							paths.get(x).getPosition() != destination_id ) {
						Path p = new Path(paths.get(x));
						p.addStep(journeys[i]);
												
						
						//checking duplicates
						boolean duplicated = false;
						for(Path compPath : paths) {
							if(p.getVisited().equals(compPath.getVisited())) {
								duplicated = true;
								break;
							}
						}
						
						if(!duplicated) {
							System.out.println("adding to "+paths.get(x).getPosition());
							paths.add(p);
							changed = true;	
						} else {
							System.out.println("Skipping Duplicated");
						}
						
						
							

						
						
						
						
						
						
						
						
						System.out.println("Paths 2: ");
						for(Path pz : paths) {
												
							for(Journey jy : pz.getPath()) {
								System.out.print(jy.getOrigin().getId() + " -> "+jy.getDestination().getId()+" ");
							}
							System.out.println("= Vis:"+pz.getVisited()+"\n");
						}
						System.out.println("Fim Paths: ");
						
					} 
				}
			}
		}
		
		System.out.println();
		
				
		//paths.add(p1);
		//paths.add(p1);
		//paths.add(p1);
		//System.out.println(paths);
		return paths;
	}
	
	@ModelAttribute("packages")
	public ArrayList<Package> getAll() {
		
		ArrayList<Package> list = new ArrayList<Package>();
		list.add(new Package(2.0,2.0));
		list.add(new Package(3.0,3.0));
		list.add(new Package(4.0,4.0));
		list.add(new Package(5.0,5.0));
		return list;
	}
	
	@ModelAttribute("nextJourneys")
	public Journey[] getNextJourneys() {
		
		RouteController rc = new RouteController();
		ArrayList<Route> routes = rc.getAll();
		
		ArrayList<Journey> journeys = new ArrayList<Journey>();
		
		Journey j;
		for(Route route : routes) {
			j = new Journey(route);
			j.setStart(route.getNextPossible(System.currentTimeMillis()));
			
			journeys.add(j);
		}
		return journeys.toArray(new Journey[journeys.size()]);
	}
	
}
