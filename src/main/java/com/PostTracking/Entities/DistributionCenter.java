package com.PostTracking.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Represents the Distribution Center entity
 */
@Entity
@Table(name="distribution_center")
public class DistributionCenter {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   	private int id;
	private String name = "";
	private String address = "";
	private String city = "";
	private String province = "";
	private String zipCode = "";
	
	
	public DistributionCenter() {}
	
	public DistributionCenter(String name, String address, String city, String province, String zipCode) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}

	public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getAddress() {
		return this.address;
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
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		DistributionCenter other = (DistributionCenter) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
    
}