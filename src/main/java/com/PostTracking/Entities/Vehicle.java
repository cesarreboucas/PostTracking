package com.PostTracking.Entities;

public class Vehicle {
	
	private String description;
	private int maxWeight; // Kg
	private int maxVolume; // dc3
	
	
	
	public Vehicle(String description, int maxWeight, int maxVolume) {
		this.description = description;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxWeight() {
		return maxWeight;
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
	
	
	
}
