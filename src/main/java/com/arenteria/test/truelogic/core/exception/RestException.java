package com.arenteria.test.truelogic.core.exception;

public class RestException extends Exception{

    private int code;

    public RestException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}