package com.hotelUnip.pim.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> list = new ArrayList<>();


    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return list;
    }

    public void addError(String fieldError, String message) {
        list.add(new FieldMessage(fieldError,message));
    }
}
