package com.example.county_curd.exceptions;

public class DatabaseEmptyException extends RuntimeException {
    
    public DatabaseEmptyException(String message){
        super(message);    
    }
}
