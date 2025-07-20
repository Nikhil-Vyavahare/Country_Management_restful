package com.example.county_curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.county_curd.Repository.CountryRepo;
import com.example.county_curd.exceptions.DataNotFoundException;
import com.example.county_curd.exceptions.DatabaseEmptyException;
import com.example.county_curd.exceptions.DuplicateDataFoundException;
import com.example.county_curd.model.Country;



@Service
public class CountryService {

	@Autowired
    private CountryRepo repository;
	
	public Country createCountry(Country country) {
		if (repository.findByCountryName(country.getCountryName()).isPresent()) {
            throw new DuplicateDataFoundException("Country Already Exists With Name:"+country.getCountryName());
        }
       return repository.save(country);
	}
	
	public List<Country> getAllCountries() {
		if ((repository.findAll()).isEmpty()) {
            throw new DatabaseEmptyException("Database is Empty");
        }
        return repository.findAll();
	}

	public Country getCountryById(String CountryId){
		if (! repository.findById(CountryId).isPresent()) {
            throw new DataNotFoundException("Country Not Found With ID:"+ CountryId);
        }
		
		return repository.findById(CountryId).get();
	}
	
	

    public Country updateFullCountry(Country newData, String countryId) {
        Country existing = repository.findById(countryId)
            .orElseThrow(() -> new DataNotFoundException("Country not found with ID: " + countryId));

        if (repository.findByCountryName(newData.getCountryName()).isPresent()) {
            throw new DuplicateDataFoundException("Country already exists with name: " + newData.getCountryName());
        }

        existing.setCountryName(newData.getCountryName());
        existing.setRegion(newData.getRegion());
        return repository.save(existing);
    }

	public String deleteCountry(String CountryId){
		if (! repository.findById(CountryId).isPresent()) {
            throw new DataNotFoundException("Country Not Found With ID:"+ CountryId);
        }
        repository.deleteById(CountryId);
		return "Country Deleted With ID: "+ CountryId;
	}
}
