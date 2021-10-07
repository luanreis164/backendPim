package com.hotelUnip.pim.services.exceptions;

public class DataIntegrityException extends RuntimeException{
    private static final long SerialVersionUID=1L;

    public DataIntegrityException(String msg){
        super(msg);

    }

    public DataIntegrityException(String msg, Throwable cause){
        super(msg,cause);
    }


}