package com.PostTracking.Entities;

import java.util.ArrayList;

public class Path {
	private ArrayList<Journey> path = new ArrayList<Journey>();
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
	
	public Path(Path copy) {
		this.path = (ArrayList<Journey>) copy.getPath().clone();
		this.position = copy.getPosition();
		this.visited = (ArrayList<Integer>) copy.getVisited().clone();
	}

	public int getPosition() {
		return position;
	}

	public void addStep(Journey j) {
		this.path.add(j);
		this.position = j.getDestination().getId();
		this.visited.add(this.position);
		//System.out.println(this.position);
		
	}
	
	public ArrayList<Journey> getPath() {
		return path;
	}
	
	public ArrayList<Integer> getVisited() {
		return visited;
	}
	
	public boolean checkAlreadyVisited(int position) {
		return this.visited.contains(position);
	}
	
}

