package com.example.jpa_relational.Api;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
