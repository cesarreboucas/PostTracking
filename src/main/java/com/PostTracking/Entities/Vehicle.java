package com.PostTracking.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Represents the Vehicle entity
 */
@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id = 0;
	private String description;
	private int maxWeight; // Kg
	private int maxVolume; // dc3
	private boolean available = true;
	
	@Transient
	List<Route> routes = new ArrayList<Route>();
	
	public Vehicle() {}
	
	public Vehicle(String description, int maxWeight, int maxVolume) {
		this.description = description;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
	}
	
	public int setId(int Id) {
		return this.Id = Id;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxWeight() {
		return this.maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void addRoute(Route r) {
		this.routes.add(r);
	}
	
	@Override
	public String toString() {
		return 
		String.format("Vehicle ID: %d\n" +
					  "Description: %s\n" +
					  "Max Volume: %d\n" +
					  "Max Weight: %d\n", Id, description, maxVolume, maxWeight);
	}
	
}
