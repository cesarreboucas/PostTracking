package com.PostTracking.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="DistributionCenter")
public class DistributionCenter {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   	private int id;
	private String name = "";
	private String address = "";
	private String city = "";
	private String province = "";
	private String zipCode = "";
	
	public DistributionCenter() {
		// TODO Auto-generated constructor stub
	}
    
    public DistributionCenter(int id, String name) {
    	//this.id = id;
    	this.name = name;
    }

	public int getId() {
        return this.id;
    }
    
    /*public void setId(int id ) {
    	this.id = id;
    }*/
    
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
    
}