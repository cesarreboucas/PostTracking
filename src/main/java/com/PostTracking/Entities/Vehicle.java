package com.PostTracking.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	@javax.persistence.Id
	@GeneratedValue
	private int Id = 0;
	private String description;
	private int maxWeight; // Kg
	private int maxVolume; // dc3
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String description, int maxWeight, int maxVolume) {
		this.description = description;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
	}
	
	public int getId() {
		return Id;
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
	
	
	
}
