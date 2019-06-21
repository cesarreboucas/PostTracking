package com.PostTracking.Entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Represents the Route entity
 * Associates with Vehicle and Distribution Center entities
 */
@Entity
@Table(name="journey")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name="Journey.findAll", query="SELECT a FROM Journey a")
public class Journey {
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_vehicle")
    protected Vehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_origin")
    protected DistributionCenter origin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_destination")
    protected DistributionCenter destination;
    @ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "package_journey",
	        joinColumns = @JoinColumn(name = "post_id"),
	        inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Package> tags = new ArrayList<Package>();
    protected Timestamp start;
    protected int duration;
    protected boolean available;
	
    public Journey() {}
	
    public Journey(Journey j) {
    	this.vehicle = j.vehicle;
        this.origin = j.origin;
        this.destination = j.destination;
        this.start = j.start;
        this.duration = j.duration;
        this.available = j.available;
	}
    
    public Journey(Vehicle vehicle, DistributionCenter origin,
                    DistributionCenter destination,
                    Timestamp start, int duration, boolean available) {
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.start = start;
        this.duration = duration;
        this.available = available;
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

	public int getId() {
		return id;
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
}