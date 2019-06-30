package com.PostTracking.Boundaries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Journey;



@Component
public interface JourneyDAO extends CrudRepository<Journey, Integer> {
	@Query("SELECT a FROM Journey a WHERE a.start>=:minimal")
    List<Journey> fetchFrom(@Param("minimal") java.sql.Timestamp mininmal);

}
