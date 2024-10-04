package com.test.e_commerce.models.exceptions;

public class NotFoundException extends RuntimeException{

    private static final Integer ERROR_CODE = 404;

    public NotFoundException(String message) {
        super(message);
    }

    public Integer getErrorCode(){
        return ERROR_CODE;
    }
}
