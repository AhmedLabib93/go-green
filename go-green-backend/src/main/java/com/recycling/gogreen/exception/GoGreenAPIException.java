package com.recycling.gogreen.exception;

import org.springframework.http.HttpStatus;

public class GoGreenAPIException extends RuntimeException {

    private HttpStatus status;

    public GoGreenAPIException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
    
}
