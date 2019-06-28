package com.PostTracking.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Customer;
import com.PostTracking.Entities.DistributionCenter;


@Component
public interface PackageDAO extends CrudRepository<com.PostTracking.Entities.Package, Integer> {
    
	@Query("SELECT j FROM com.PostTracking.Entities.Package j WHERE "+
		"((j.origin = :origin or :origin is null) and "+
		"(j.destination = :destination or :destination is null) and "+
		"(j.customer = :customer or :customer is null))")
    public Iterable<com.PostTracking.Entities.Package> findBy(@Param("origin") DistributionCenter origin,
        @Param("destination") DistributionCenter destination, @Param("customer") Customer customer);
    
}
