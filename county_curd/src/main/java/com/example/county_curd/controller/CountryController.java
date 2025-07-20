package com.example.county_curd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.county_curd.model.Country;
import com.example.county_curd.service.CountryService;



@RestController
@RequestMapping("countries")
public class CountryController {
    
    @Autowired
    private CountryService countryService;
    
    @GetMapping
    public ResponseEntity<?> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCountryById(@PathVariable String id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.createCountry(country));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable String id, @RequestBody Country updatedCountry) {
        return ResponseEntity.ok(countryService.updateFullCountry(updatedCountry, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable String id) {
       return ResponseEntity.ok(countryService.deleteCountry(id));
    }

}
