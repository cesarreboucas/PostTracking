package com.PostTracking.Boundaries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Journey;
import com.PostTracking.Helper.JourneyStats;

@Component
public interface JourneyDAO extends CrudRepository<Journey, Long> {
    @Query("SELECT a FROM Journey a WHERE a.start>=:minimal")
    List<Journey> fetchFrom(@Param("minimal") java.sql.Timestamp mininmal);

    /*
     * select * from journey j right join package_journey pj on j.id=pj.journey_id
     * right join package p on pj.package_id=p.id where
     * p.fk_position!=p.fk_destination;
     */
    @Query("SELECT j FROM Journey j right join j.packages p where p.destination!=p.position order by j.start")
    List<Journey> findFilled();
    
    @Query("SELECT new com.PostTracking.Helper.JourneyStats(COALESCE(sum(p.volume), 0.0),"
    		+ "COALESCE(sum(p.weight), 0.0), j) "
    		+ "from Journey j left join j.packages p GROUP by j ")
    List<JourneyStats> getWithCapacity();
}
