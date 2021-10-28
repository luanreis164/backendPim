package com.hotelUnip.pim.services.exceptions;

public class AuthorizationException extends RuntimeException{
    private static final long SerialVersionUID=1L;

    public AuthorizationException(String msg){
        super(msg);

    }

    public AuthorizationException(String msg, Throwable cause){
        super(msg,cause);
    }


}