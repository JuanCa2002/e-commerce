package com.test.e_commerce.models.exceptions;

public class BadRequestException extends RuntimeException{
    private static final Integer ERROR_CODE = 400;

    public BadRequestException(String message){
        super(message);
    }

    public Integer getErrorCode(){
        return ERROR_CODE;
    }
}
