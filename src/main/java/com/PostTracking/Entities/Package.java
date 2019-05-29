package com.PostTracking.Entities;

public class Package {

	private double weight;
	private double volume;
	
	public Package(double weight, double volume) {
		this.weight = weight;
		this.volume = volume;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
	
}
