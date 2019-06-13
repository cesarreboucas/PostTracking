package com.PostTracking.Boundaries;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.PostTracking.Entities.Vehicle;

public class VehicleDAO extends EntitiesDAOImpl {
	
	public int createCar(Vehicle v) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		int newVehicleId = 0;
		
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			
			//Create the car
			System.out.println("IDDDDDDDDDDD- >>>>"+v.getMaxVolume());
			System.out.println("IDDDDDDDDDDD- >>>>"+v.getMaxWeight());
			System.out.println("IDDDDDDDDDDD- >>>>"+v.getDescription());
			System.out.println("IDDDDDDDDDDD- >>>>"+v.getId());
			newVehicleId = (Integer) sx.save(v);
			System.out.println("IDDDDDDDDDDD- >>>>"+newVehicleId);
			tx.commit();
			
		} catch(HibernateException hx) {
			if(tx!=null) {
				tx.rollback();
				System.out.println(hx.getMessage());
			}
		} finally {
			sx.close();
			fx.close();
		}
		return newVehicleId;
	}
}
