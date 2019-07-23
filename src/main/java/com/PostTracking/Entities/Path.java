package com.PostTracking.Entities;

import java.util.ArrayList;

/**
 * Represents the a set of Journeys to reach a certain destination
 * @author 300296145
 *
 */
public class Path {
	private ArrayList<Journey> journeys = new ArrayList<>();
	private int position; // Distribution Center ID
	private ArrayList<Integer> visited = new ArrayList<Integer>();
	
	/**
	 * Sets the origin of the path
	 * @param position Origin position
	 */
	public Path(int position) {
		this.position = position;
		this.visited.add(position);
	}
	
	/**
	 * Duplicates the Path
	 * @param copy Path to be copied
	 */
	public Path(Path copy) {
		this.journeys = (ArrayList<Journey>) copy.getJourneys().clone();
		this.position = copy.getPosition();
		this.visited = (ArrayList<Integer>) copy.getVisited().clone();
	}

	public int getPosition() {
		return position;
	}
	
	/**
	 * Adds a route or journey to a path
	 * @param r the route/journey to be added
	 */
	public void addStep(Route r) {
		this.journeys.add(r);
		this.position = r.getDestination().getId();
		this.visited.add(this.position);
		//System.out.println(this.position);
		
	}
	
	public ArrayList<Journey> getJourneys() {
		return journeys;
	}
	
	public ArrayList<Integer> getVisited() {
		return visited;
	}
	
	public boolean checkAlreadyVisited(int position) {
		return this.visited.contains(position);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Journey jy : this.getJourneys()) {
			sb.append(jy.getOrigin().getId() + " => "+jy.getDestination().getId()+" ("+jy.getVehicle().getId()+") | ");
		}
		sb.append(" - Vis:"+this.getVisited()+"\n");
		return sb.toString();
		
	}
	
}

