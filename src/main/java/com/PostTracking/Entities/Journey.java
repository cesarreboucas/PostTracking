package com.PostTracking.Entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Represents the Route entity Associates with Vehicle and Distribution Center
 * entities
 */
@Entity
@Table(name = "journey")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Journey.findAll", query = "SELECT a FROM Journey a")
public class Journey {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_vehicle")
	protected Vehicle vehicle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_origin")
	protected DistributionCenter origin;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_destination")
	protected DistributionCenter destination;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "package_journey", joinColumns = @JoinColumn(name = "journey_id"), inverseJoinColumns = @JoinColumn(name = "package_id"))
	@JsonBackReference
	private Set<Package> packages = new HashSet<Package>();
	protected Timestamp start;
	protected int duration;
	protected boolean available;
	protected long restart;
	
	@Transient
	private Double availableVolume;
	@Transient
	private Double availableWeight;

	public Journey() {
	}

	public Journey(Journey j) {
		this.id = j.id;
		this.vehicle = j.vehicle;
		this.origin = j.origin;
		this.destination = j.destination;
		this.start = j.start;
		this.duration = j.duration;
		this.available = j.available;
		this.restart = j.restart;
	}

	public Journey(Vehicle vehicle, DistributionCenter origin, DistributionCenter destination, Timestamp start,
			int duration, long restart, boolean available) {
		this.vehicle = vehicle;
		this.origin = origin;
		this.destination = destination;
		this.start = start;
		this.duration = duration;
		this.restart = restart;
		this.available = available;
	}
	
	/**
	 * This constructor is specific to the SeekPath, when testing availability of journeys
	 * P.S.: The Capacities of Vehicles are passed to avoid multiple calls when retrieving journeys 
	 * @param comVolume The committed Volume
	 * @param comWeight the committed Weight
	 * @param totalVolume The capacity of Vehicle
	 * @param totalWeight The capacity of Vehicle
	 */
	public Journey(Journey j, double comVolume, double comWeight, int totalVolume, int totalWeight) {
		this(j);
		this.availableVolume = (totalVolume - comVolume);
		this.availableWeight = (totalWeight - comWeight);
		
	}
	
	public double getAvailableVolume() {
		if(availableVolume==null) {
			return getVehicle().getMaxVolume();
		}
		return availableVolume.doubleValue();
	}

	public double getAvailabledWeight() {
		if(availableWeight==null) {
			return this.getVehicle().getMaxWeight();
		}
		return availableWeight.doubleValue();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getStart() {
		return start;
	}

	public Timestamp getArrival() {
		return new Timestamp(this.start.getTime() + this.duration);
	}

	public void setStart(Timestamp t) {
		this.start = t;
	}

	public long getRestart() {
		return this.restart;
	}

	public void setRestart(int restart) {
		this.restart = restart;
	}

	public Set<Package> getPackages() {
		return this.packages;
	}

	public Journey checkExistingJourney(List<Journey> journeys) {
		for (Journey j : journeys) {
			if (getStart().equals(j.getStart()) && getVehicle().equals(j.getVehicle()) && getOrigin().equals(j.getOrigin())) {
				return j;
			}
		}
		return new Journey(this);
	}

	public Journey getNextPossible(long from) {
		// Number of times the route was executed till now.
		int x = (int) Math.ceil((from - this.start.getTime()) / (float) this.restart);
		Timestamp ts = new Timestamp((x * this.restart) + this.start.getTime());
		return new Journey(this.vehicle, this.origin, this.destination, ts, this.duration, this.restart, this.available);
		
		
	}
	
	public boolean checkCapacity(double volume, double weight) {
		return (getAvailabledWeight() >= weight && getAvailableVolume() >=volume);
	}

	@Override
	public boolean equals(Object obj) {
		Journey j = (Journey) obj;
		return this.id == j.getId();
	}

	@Override
	public String toString() {
		return String.format("VehicleId: %d\nOriginId: %d\nDestinationId: %d\nStart: %d\nDuration: %d", vehicle.getId(),
				origin.getId(), destination.getId(), getStart().getTime(), getDuration());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

}