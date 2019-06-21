package com.PostTracking.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.PostTracking.Boundaries.DistributionCenterDAO;
import com.PostTracking.Boundaries.JourneyDAO;
import com.PostTracking.Boundaries.RouteDAO;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Package;
import com.PostTracking.Entities.Path;
import com.PostTracking.Entities.Journey;

/**
 * Controls the endpoints for the Packages
 * @author 300296145
 *
 */
@Controller
public class PackageController {
	
	@Autowired
	RouteDAO rDAO;
	@Autowired
	JourneyDAO jDAO;
	@Autowired
	DistributionCenterDAO dcDAO;
	
	/**
	 * Maps the /packages (List of Packages)
	 * @return the view of /packages
	 */
	@GetMapping("/packages")
	public String showAll() {
		return "packages/packages";
	}
	
	/**
	 * Maps the /packages/add
	 * @param model Adds the Package object to fill the form
	 * @return the View to Add the package
	 */
	@GetMapping("/packages/add")
	public String insert(Model model) {
		model.addAttribute("package", new Package());
		return "packages/add";
	}
	
	/**
	 * Seeks the path between two distribution centers to route a package
	 * @param origin The origin DC 
	 * @param destination the destination DC 
	 * @return The JSON with possible Paths to reach the destination
	 */
	@GetMapping("/packages/seekpath/{origin}/{destination}")
	@ResponseBody
	public ArrayList<Path> seekPath(@PathVariable String origin,@PathVariable String destination) {
		//test from 1 to 3
		ArrayList<Path> paths = new ArrayList<Path>();
		List<Route> routes = rDAO.getRoutes();
		System.out.println(routes.get(0));
		int origin_id = 0;
		int destination_id = 0;
		try {
			origin_id = Integer.parseInt(origin);
			destination_id = Integer.parseInt(destination);
		} catch(Exception ex) {
			System.out.println("Unable to parse Origin or Destination on PackageController@seekPath");
			return null;
		}
		
		// Initializing paths to the first iteration
		paths.add(new Path(origin_id));
			
		for(int x=0; x < paths.size(); ++x) {
			for(int i=0 ; i < routes.size(); ++i) {
				/* Three conditions:
					-> if the Journey starts where the path is at this moment
					-> if the Journey doesn't go to a already visited place	
					-> if the the current position not the destination 
				*/ 
				if(routes.get(i).getOrigin().getId() == paths.get(x).getPosition() && 
						!paths.get(x).checkAlreadyVisited(routes.get(i).getDestination().getId()) &&
						paths.get(x).getPosition() != destination_id ) {
					// create a new path using the current one (Hard Copy) and adding the journey
					Path p = new Path(paths.get(x));
					p.addStep(new Route(routes.get(i)));
					paths.add(p);
					System.out.println("adding from: "+paths.get(x).getPosition()+" to: "+p.getPosition());
					System.out.println("Paths Size: "+paths.size()+" x:"+x);
					// Logging paths -- Remove later
					System.out.println("-> Paths: ");
					for(Path pz : paths) {
						System.out.println(pz);
					}
				} 
			}
		}
		
		//Removing incomplete paths
		for(int x=0; x < paths.size(); ++x) {
			// If current position != destination, drop
			if(paths.get(x).getPosition() != destination_id) {
				paths.remove(x);
				--x; //Backing X after index changed
				//System.out.println("Deleting: Paths Size ->"+paths.size());
			}
			// If Path is good, refresh timestamp
			else {
				System.out.println("Working ON: Paths Size ->"+paths.size());
				ArrayList<Route> routesOfPath = paths.get(x).getPath();
				System.out.println(paths.get(x));
	
				long minimal = System.currentTimeMillis();
				for(int i=0; i < routesOfPath.size() ; ++i) {
					System.out.println(routesOfPath.get(i).getRestart());
					System.out.println("Minimal: "+minimal);
					System.out.println("New Start: "+routesOfPath.get(i).getNextPossible(minimal));
					routesOfPath.get(i).setStart(routesOfPath.get(i).getNextPossible(minimal));
					//jDAO.createJourney(routesOfPath.get(i));
					minimal = routesOfPath.get(i).getArrival().getTime();
					System.out.println();
				}
			}
		}
		
		return paths;
	}
	
	/**
	 * Makes the packages list available to the views
	 * @return list of packages
	 */
	@ModelAttribute("packages")
	public ArrayList<Package> getAll() {
		ArrayList<Package> list = new ArrayList<Package>();
		return list;
	}
	
	/**
	 * Makes the Distribution Centers list available to the view Add package
	 * @return list of distribution centers
	 */
	@ModelAttribute("distributionCenters")
	public List<DistributionCenter> getDistributionCentes() {
		return dcDAO.getDistributionCenters();
	}
	
	/**
	 * TODO move to propper place
	 * Generate the journey list from Routes 
	 * @return An Array of Journeys
	 */
	/*
	@ModelAttribute("journeys")
	public Journey[] getJourneys() {
		
		List<Route> routes = rDAO.getRoutes();		
		ArrayList<Journey> journeys = new ArrayList<Journey>();
		Journey j;
		for(Route route : routes) {
			j = (Journey) route;
			journeys.add(j);
		}
		return journeys.toArray(new Route[journeys.size()]);
	}
	*/
}
