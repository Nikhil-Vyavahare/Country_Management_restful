package com.example.county_curd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.county_curd.model.ErorrReseponse;



@ControllerAdvice
public class GlobleExceptionHandler {
    
    @ExceptionHandler(DuplicateDataFoundException.class)
    public ResponseEntity<?> DuplicateDataHandler(DuplicateDataFoundException ddfe , WebRequest webRequest){
        ErorrReseponse erorrReseponse = new ErorrReseponse(ddfe.getMessage() , webRequest.getDescription(false),"DUPLICATE DATA FOUND");
        return new ResponseEntity<>(erorrReseponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> DataNotFoundHandler( DataNotFoundException dnfe , WebRequest webRequest){
        ErorrReseponse erorrReseponse = new ErorrReseponse(dnfe.getMessage() , webRequest.getDescription(false),"DATA NOT FOUND");
        return new ResponseEntity<>(erorrReseponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseEmptyException.class)
    public ResponseEntity<?> DatabaseEmptyHandler( DatabaseEmptyException dnfe , WebRequest webRequest){
        ErorrReseponse erorrReseponse = new ErorrReseponse(dnfe.getMessage() , webRequest.getDescription(false),"DATA NOT FOUND");
        return new ResponseEntity<>(erorrReseponse,HttpStatus.NOT_FOUND);
    }
}
