package com.test.e_commerce.models.exceptions;

public class ServerException extends RuntimeException{
    private static final Integer ERROR_CODE = 500;

    public ServerException(){
        super("Internal Server Error");
    }

    public Integer getErrorCode(){
        return ERROR_CODE;
    }
}
