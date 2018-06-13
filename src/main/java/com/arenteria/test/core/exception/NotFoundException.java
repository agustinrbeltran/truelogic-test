package com.arenteria.test.core.exception;

public class NotFoundException extends RestException {

    private int code;

    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}