package com.PostTracking.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface PackageDAO extends CrudRepository<com.PostTracking.Entities.Package, Integer> {
	
}
