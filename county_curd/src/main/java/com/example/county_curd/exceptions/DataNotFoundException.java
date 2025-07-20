package com.example.county_curd.exceptions;

public class DataNotFoundException extends RuntimeException {
    
    public DataNotFoundException(String message){
        super(message);
    }
}
