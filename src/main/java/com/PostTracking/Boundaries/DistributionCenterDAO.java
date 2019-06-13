package com.PostTracking.Boundaries;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.PostTracking.Entities.DistributionCenter;

public class DistributionCenterDAO {
	public static SessionFactory getFactory() {
		StandardServiceRegistry ssr = null;
		Metadata meta = null;
		SessionFactory factory = null;
		try {
			//Read the config
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			// Build the metadata from the service registry
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			//Build factory
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		return factory;
	}
	
	public int createDistributionCenter(DistributionCenter dc) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		int newDCId=0;
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			
			newDCId = (Integer) sx.save(dc);
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
		return newDCId;
	}
}
