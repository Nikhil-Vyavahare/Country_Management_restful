package com.example.county_curd.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.county_curd.model.Region;





@Repository
public interface RegionRepo extends JpaRepository<Region,Long> {
    Optional<Region> findByRegionName(String regionName);
    
}
