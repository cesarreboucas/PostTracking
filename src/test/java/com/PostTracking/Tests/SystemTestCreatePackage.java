package com.PostTracking.Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import com.PostTracking.Entities.Customer;
import com.PostTracking.Entities.DistributionCenter;
import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Package;
import com.PostTracking.Entities.Path;
import com.google.gson.Gson;

public class SystemTestCreatePackage {
	Package p;
	URL url;
	HttpURLConnection con;
	Gson gson = new Gson();
	DistributionCenter[] dcs;
	Customer[] customers;
	Path[] paths;
	Random r = new Random();
	
	public SystemTestCreatePackage() {
		System.out.println("Getting all Distribution Centers");
		try {
			//Get The DCS
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
		System.out.println("Getting all Customers");
		try {
			// Get The Customers
			url = new URL("http://127.0.0.1:8080/api/customers");
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
			customers = gson.fromJson(content.toString(), Customer[].class); 
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
		
	@Test
	public void GetAllDistributionCenters() {
		//Body moved to Constructor to fix Order
		assertTrue(dcs.length>0);
	}
	
	@Test
	public void A_GetAllCustomers() {
		assertTrue(customers.length>0);
	}
	
	@Test
	public void CreateRandomPackage() {
		System.out.println("Create Random Package");
		
		p = new Package();
		p.setCustomer(customers[r.nextInt(customers.length)]);
		int index_origin = r.nextInt(dcs.length);
		int index_destination;
		do {
			index_destination = r.nextInt(dcs.length); 
		} while (index_destination == index_origin);
		p.setOrigin(dcs[16]);
		p.setDestination(dcs[10]);
		p.setWeight(r.nextInt(200));
		p.setVolume(r.nextInt(200));
		
		// Getting the path
		try {
			url = new URL("http://127.0.0.1:8080/packages/seekpath/"+
					p.getOrigin().getId()+"/"+p.getDestination().getId()+"/"+
					p.getWeight()+"/"+p.getVolume());
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
			paths = gson.fromJson(content.toString(), Path[].class);
			//System.out.println(paths[0]);
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			//URL myurl = new URL("http://140.161.84.11:8080/packages");
			URL myurl = new URL("http://127.0.0.1:8080/api/packages");
			con = (HttpURLConnection) myurl.openConnection();
			con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        
            StringBuilder sb = new StringBuilder();
            sb.append("customer="+p.getCustomer().getId()+"&");
            sb.append("origin="+p.getOrigin().getId()+"&");
            sb.append("destination="+p.getDestination().getId()+"&");
            //sb.append("journeys="+paths[0].getVisited().toString()+"&");
            String journeys_str = "journeys=";
            for(Journey j : paths[0].getJourneys()) {
            	journeys_str += j.getId()+",";
            }
            sb.append(journeys_str.substring(0, journeys_str.length()-1));
            sb.append("&");
            sb.append("weight="+p.getWeight()+"&");
            sb.append("volume="+p.getVolume()+"&");
            sb.append("recipient=test");
            System.out.println(sb.toString());
            
            byte[] postData = sb.toString().getBytes(StandardCharsets.UTF_8);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }
            
            BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
			in.close();
			p = gson.fromJson(content.toString(), Package.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(p.getId()>0);
	}
}
