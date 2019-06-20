package com.PostTracking.Entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;




/**
 * Represents the Journey entity
 * Associates with Vehicle and Distribution Center entities
 *
 */
@Entity
@Table(name="journey")
public class Journey extends Route {
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "package_journey",
	        joinColumns = @JoinColumn(name = "post_id"),
	        inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Package> tags = new ArrayList<Package>();
	
	public Journey(Route r) {
		super(r.vehicle, r.origin, r.destination, r.start,
				r.duration, r.restart, r.available);
	}
	
	public Journey(int id, Vehicle vehicle, DistributionCenter origin,
            DistributionCenter destination,
            Timestamp start, int duration,
            int restart, boolean available) {
		super(vehicle, origin, destination, start, duration, restart, available);
	}
	
	public Timestamp getNextPossible(long from) {
		//System.out.println("Now: "+from);
		//System.out.println("Start: "+this.start);
		//System.out.println("Restart (hours): "+((double)this.restart/1000.0/60.0/60.0));
		// Number of times the route was executed till now.
		int x = (int) Math.ceil((from - this.start.getTime())/ (float)this.restart);
		//System.out.println("x: "+x+" x*res:"+(x*this.restart));
		Timestamp ts = new Timestamp((x*(long)this.restart) + this.start.getTime());
		//System.out.println("Restart to next:"+x);
		//System.out.println("Next: "+ts);
		//System.out.println();
		return ts;	
	}
	

}
