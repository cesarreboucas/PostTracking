package com.PostTracking.Entities;

public class Package {

	private int id;
	private double weight;
	private double volume;
	private String recipient;
	private String address;
	private String city;
	private String province;
	private String zipCode;
	
	public Package(double weight, double volume) {
		this.weight = weight;
		this.volume = volume;
	}
	
	public int getId() {
		return id;
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
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
