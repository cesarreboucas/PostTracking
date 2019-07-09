package com.PostTracking.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Route;


@Component
public interface RouteDAO extends CrudRepository<Route, Integer> {
}
