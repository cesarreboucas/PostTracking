package com.PostTracking.Boundaries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Route;
import com.PostTracking.Entities.Vehicle;


@Component
public interface RouteDAO extends CrudRepository<Route, Integer> {

}
