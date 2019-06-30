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
	        joinColumns = @JoinColumn(name = "journey_id"),
	        inverseJoinColumns = @JoinColumn(name = "package_id"))
	private Set<Package> packages = new HashSet<Package>();
    protected Timestamp start;
    protected int duration;
    protected boolean available;
    protected long restart;
	
    public Journey() {}
	
    public Journey(Journey j) {
    	this.vehicle = j.vehicle;
        this.origin = j.origin;
        this.destination = j.destination;
        this.start = j.start;
        this.duration = j.duration;
        this.available = j.available;
        this.restart = j.restart;
	}
    
    public Journey(Vehicle vehicle, DistributionCenter origin,
                    DistributionCenter destination,
                    Timestamp start, int duration, long restart, boolean available) {
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.start = start;
        this.duration = duration;
        this.restart = restart;
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
		for(Journey j : journeys) {
			/*System.out.println("Start: "+this.start.equals(j.start));
			System.out.println("J.Vehivle = "+j.vehicle.getDescription());
			System.out.println("Vehicle: "+this.vehicle.equals(j.vehicle));
			System.out.println("Origin: "+this.origin.equals(j.origin));*/
			/*if(this.origin.equals(j.origin)) {
				if(this.vehicle.equals(j.vehicle)) {
					if(this.start.equals(j.start)) {
						System.out.println("OK!!!");
						return j;
					}else {System.out.println("Start Differente");}
				}else {System.out.println("Vehicle Differente");}
			}else {System.out.println("Origin Differente");}*/
			if(this.start.equals(j.start) && this.vehicle.equals(j.vehicle) && this.origin.equals(j.origin)) {
				return j;
			}
		}
		return new Journey(this);
	}
	
	public Timestamp getNextPossible(long from) {
		// Number of times the route was executed till now.
		int x = (int) Math.ceil((from - this.start.getTime())/ (float)this.restart);
		Timestamp ts = new Timestamp((x*(long)this.restart) + this.start.getTime());
		//System.out.println("Now: "+from);
		//System.out.println("Start: "+this.start);
		//System.out.println("Restart (hours): "+((double)this.restart/1000.0/60.0/60.0));
		//System.out.println("x: "+x+" x*res:"+(x*this.restart));
		//System.out.println("Restart to next:"+x);
		//System.out.println("Next: "+ts);
		//System.out.println();
		return ts;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + duration;
		result = prime * result + id;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Journey j = (Journey) obj;
		return this.id == j.id;
	}
	
	
}