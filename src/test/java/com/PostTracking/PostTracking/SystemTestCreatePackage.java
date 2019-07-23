package com.PostTracking.PostTracking;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.PostTracking.Entities.Customer;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Package;
import com.google.gson.Gson;

public class SystemTestCreatePackage {
	Package p;
	URL url;
	HttpURLConnection con;
	Gson gson = new Gson();
	DistributionCenter[] dcs;
	Customer[] customers;
	
		
	@Test
	public void TestEnvironment() {
		System.out.println("Testing Environment");
		try {
			// Get The DCS
			url = new URL("http://127.0.0.1:8080/api/dcs");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					in.close();
					dcs = gson.fromJson(content.toString(), DistributionCenter[].class); 
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(dcs.length>0);
	
	}

}
