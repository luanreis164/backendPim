package com.hotelUnip.pim.services.exceptions;


public class ConstraintViolationException extends RuntimeException{

    public ConstraintViolationException(String msg){
        super(msg);
    }

    public ConstraintViolationException(String msg, Throwable cause){
        super(msg,cause);

    }

}
