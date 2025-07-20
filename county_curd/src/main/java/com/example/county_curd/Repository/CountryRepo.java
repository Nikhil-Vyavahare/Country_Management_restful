package com.example.county_curd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.county_curd.model.Country;





public interface CountryRepo extends JpaRepository<Country,String>{
    Optional<Country> findByCountryName(String countryName);
}
