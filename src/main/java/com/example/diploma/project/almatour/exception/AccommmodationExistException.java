package com.example.diploma.project.almatour.exception;

import org.springframework.http.HttpStatus;


public class AccommmodationExistException extends RuntimeException{
    private HttpStatus status;
    public AccommmodationExistException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
