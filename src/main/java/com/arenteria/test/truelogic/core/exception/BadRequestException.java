package com.arenteria.test.truelogic.core.exception;

public class BadRequestException extends RestException {

    private int code;

    public BadRequestException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
