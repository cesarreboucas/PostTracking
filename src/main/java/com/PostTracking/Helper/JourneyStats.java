package com.PostTracking.Helper;

import com.PostTracking.Entities.Journey;

public class JourneyStats {
	public int journey_id;
	public double comp_volume;
	public double comp_weight;
	public double av_volume;
	public double av_weight;
	public Journey j;
	
	public JourneyStats(double comp_volume, double av_volume, double comp_weight, double av_weight, Journey j) {
		//this.journey_id = journey_id;
		this.comp_volume = comp_volume;
		this.comp_weight = comp_weight;
		this.av_volume = av_volume;
		this.av_weight = av_weight;
		this.j = j;
	}
	
	
	
}
