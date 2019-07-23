package com.PostTracking.Boundaries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Journey;

@Component
public interface JourneyDAO extends CrudRepository<Journey, Long> {
    @Query("SELECT a FROM Journey a WHERE a.start>=:minimal")
    List<Journey> fetchFrom(@Param("minimal") java.sql.Timestamp mininmal);
    
	
    /*
     * select * from journey j right join package_journey pj on j.id=pj.journey_id
     * right join package p on pj.package_id=p.id where
     * p.fk_position!=p.fk_destination;
     */
    @Query("SELECT j FROM Journey j right join j.packages p where p.destination!=p.position GROUP by j order by j.start")
    List<Journey> findFilled();
    
    //Using The Helper
    /*
    @Query("SELECT new com.PostTracking.Helper.JourneyStats(COALESCE(sum(p.volume), 0.0),"
    		+ "j.vehicle.maxVolume, COALESCE(sum(p.weight), 0.0), j.vehicle.maxWeight,j) "
    		+ "FROM Journey j left join j.packages p "
    		+ "WHERE j.start>=:minimal GROUP by j")
    List<JourneyStats> getWithCapacity(@Param("minimal") java.sql.Timestamp mininmal);
    */
    
    //Using Journey Property
    @Query("SELECT new com.PostTracking.Entities.Journey(j, COALESCE(sum(p.volume), 0.0),"
    		+ "COALESCE(sum(p.weight), 0.0), j.vehicle.maxVolume ,j.vehicle.maxWeight) "
    		+ "FROM Journey j left join j.packages p "
    		+ "WHERE j.start>=:minimal GROUP by j")
    List<Journey> getWithCapacity(@Param("minimal") java.sql.Timestamp mininmal);
    
}
