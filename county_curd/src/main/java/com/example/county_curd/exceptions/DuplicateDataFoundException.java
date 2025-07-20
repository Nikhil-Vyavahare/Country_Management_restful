package com.example.county_curd.exceptions;

public class DuplicateDataFoundException extends RuntimeException {
    
    public DuplicateDataFoundException(String message){
        super(message);
    }
}
