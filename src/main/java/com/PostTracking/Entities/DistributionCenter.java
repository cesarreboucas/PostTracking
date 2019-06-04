package com.PostTracking.Entities;

public class DistributionCenter {

    private String name;
    private int id;

    public DistributionCenter(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
}