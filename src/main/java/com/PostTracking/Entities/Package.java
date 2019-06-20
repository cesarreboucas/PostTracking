package com.PostTracking.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents the Package entity
 * Associates with Distribution Center entity
 */
@Entity
@Table(name="package")
public class Package {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_origin")
	private DistributionCenter origin;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_destination")
	private DistributionCenter destination;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_position")
	private DistributionCenter position;
	@ManyToMany(mappedBy = "tags")
    private List<Route> journeys = new ArrayList<Route>();	
	private double weight;
	private double volume;
	private String recipient;
	private String address;
	private String city;
	private String province;
	private String zipCode;
	
	public Package() {}
	
	public Package(double weight, double volume) {
		this.weight = weight;
		this.volume = volume;
	}
	
	public int getId() {
		return this.id;
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
	
	public DistributionCenter getOrigin() {
		return origin;
	}

	public void setOrigin(DistributionCenter origin) {
		this.origin = origin;
	}

	public DistributionCenter getDestination() {
		return destination;
	}

	public void setDestination(DistributionCenter destination) {
		this.destination = destination;
	}

	public DistributionCenter getPosition() {
		return position;
	}

	public void setPosition(DistributionCenter position) {
		this.position = position;
	}
}
