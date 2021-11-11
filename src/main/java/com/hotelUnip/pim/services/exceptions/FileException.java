package com.hotelUnip.pim.services.exceptions;

public class FileException extends RuntimeException{
    private static final long SerialVersionUID=1L;

    public FileException(String msg){
        super(msg);

    }

    public FileException(String msg, Throwable cause){
        super(msg,cause);
    }


}