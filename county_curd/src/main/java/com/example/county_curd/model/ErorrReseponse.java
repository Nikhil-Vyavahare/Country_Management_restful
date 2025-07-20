package com.example.county_curd.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErorrReseponse {
    private LocalDateTime localDateTime;
    private String errorMessage;
    private String errorDetails;
    private String errorCode;


    public ErorrReseponse( String errorMessage, String errorDetails, String errorCode) {
        this.localDateTime = localDateTime.now();
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
        this.errorCode = errorCode;
    }
    
    
    
}
