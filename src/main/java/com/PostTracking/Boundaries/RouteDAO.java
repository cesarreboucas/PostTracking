package com.PostTracking.Boundaries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Route;


@Component
public class RouteDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int createRoute(Route r) {
		entityManager.merge(r);
		return r.getId();
	}
	
	public Route getRoute(int id) {
		Route r = entityManager.find(Route.class, id);
		return r;
	}
	
	public List<Route> getRoutes() {
		List<Route> routes = new ArrayList<Route>();
		
		routes = entityManager.createQuery("from Route order by fk_vehicle", Route.class).getResultList();
		return routes;
	}
	
	/*public List<Route> getRoutes(Vehicle v) {
	TypedQuery<Route> q = entityManager.createQuery("SELECT i FROM Route i JOIN FETCH i.vehicle where i.vehicle="+v.getId(), Route.class);
	q.setFirstResult(0);
	//q.setMaxResults(5);
	return q.getResultList();
}*/

}
