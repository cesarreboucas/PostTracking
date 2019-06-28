package com.PostTracking.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.DistributionCenter;



@Component
public interface DistributionCenterDAO extends CrudRepository<DistributionCenter, Integer> {
    public Iterable<DistributionCenter> findAllByOrderByNameAsc();
}
