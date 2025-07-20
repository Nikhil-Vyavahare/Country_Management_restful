package com.example.county_curd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.county_curd.Repository.RegionRepo;
import com.example.county_curd.exceptions.DataNotFoundException;
import com.example.county_curd.exceptions.DatabaseEmptyException;
import com.example.county_curd.exceptions.DuplicateDataFoundException;
import com.example.county_curd.model.Region;



@Service
public class RegionService {
    @Autowired
    private RegionRepo repository;

    public Region createRegion(Region region){
        if (repository.findByRegionName(region.getRegionName()).isPresent()) {
            throw new DuplicateDataFoundException("Region Already Exists With Name:"+region.getRegionName());
        }
       return repository.save(region);
    }

    public List<Region> getAllRegions(){
        if ((repository.findAll()).isEmpty()) {
            throw new DatabaseEmptyException("Database is Empty");
        }
        return repository.findAll();
    }

    public Region getRegionById(Long regionId){
		if (! repository.findById(regionId).isPresent()) {
            throw new DataNotFoundException("Region Not Found With ID:"+ regionId);
        }
		
		return repository.findById(regionId).get();
	}

    public Region updateRegion(String newName, Long regionId){
        Region existRegion = repository.findById(regionId).get();
        if (repository.findByRegionName(newName).isPresent()) {
            throw new DuplicateDataFoundException("Region Alrady Exists With Name:"+newName);
        }
        existRegion.setRegionName(newName);
        repository.save(existRegion);
        return existRegion;
    }

    public String deleteRegion(Long regionId){
		if (! repository.findById(regionId).isPresent()) {
            throw new DataNotFoundException("Region Not Found With ID:"+ regionId);
        }
        repository.deleteById(regionId);
        return "Region Deleted With ID: "+ regionId;
	}
}
