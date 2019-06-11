package com.PostTracking.Entities;

public class DistributionCenter {

	private int id = 0;
	private String name = "";
	private String address = "";
	private String city = "";
	private String province = "";
	private String zipCode = "";
    

    public DistributionCenter(int id, String name) {
    	this.id = id;
    	this.name = name;
    }

	public int getId() {
        return this.id;
    }
    
    public void setId(int id ) {
    	this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
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