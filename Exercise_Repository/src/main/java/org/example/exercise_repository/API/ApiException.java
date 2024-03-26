package org.example.jpa.API;

public class ApiException extends RuntimeException{

    public ApiException (String message){
        super(message);
    }
}
