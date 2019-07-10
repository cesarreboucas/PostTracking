package com.PostTracking.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_customer")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name = "package_journey", 
			joinColumns=@JoinColumn(name="package_id"),
			inverseJoinColumns=@JoinColumn(name="journey_id"))
	private Set<Journey> journeys;	

	private double weight;
	private double volume;
	private String recipient;
	private String address;
	private String city;
	private String province;
	private String zipCode;
	
	public Package() {}
	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(Set<Journey> journeys) {
		this.journeys = journeys;
	}

	public boolean validateMe() {
		return (this.getCustomer() instanceof Customer &&
			this.getDestination() instanceof DistributionCenter &&
			this.getOrigin() instanceof DistributionCenter);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + id;
		result = prime * result + ((journeys == null) ? 0 : journeys.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id != other.id)
			return false;
		if (journeys == null) {
			if (other.journeys != null)
				return false;
		} else if (!journeys.equals(other.journeys))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}
	
	
	
}
