package com.PostTracking.PostTracking;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.junit.Test;

import com.PostTracking.Entities.Vehicle;
import com.google.gson.Gson;


public class IntegrationTestGetAllVehicles {

	Vehicle[] vehicles;
	URL url;
	HttpURLConnection con;
	Gson gson = new Gson();
	
	@Test
	public void GetAllVehiclesTest() {

		try {
			//Get all Vehicles
			url = new URL("http://127.0.0.1:8080/api/vehicles");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
			}
			in.close();
			vehicles = gson.fromJson(content.toString(), Vehicle[].class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		assertTrue(vehicles.length>0);
	
	}


}
