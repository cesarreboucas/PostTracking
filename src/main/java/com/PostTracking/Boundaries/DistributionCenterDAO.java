package com.PostTracking.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.DistributionCenter;



@Component
public interface DistributionCenterDAO extends CrudRepository<DistributionCenter, Integer> {
	@Query("SELECT dc FROM DistributionCenter dc WHERE dc.active = true ORDER BY dc.name ASC")
	Iterable<DistributionCenter> fetchDCs();
}
