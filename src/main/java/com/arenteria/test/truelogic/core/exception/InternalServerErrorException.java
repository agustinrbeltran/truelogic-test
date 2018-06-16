package com.arenteria.test.truelogic.core.exception;

public class InternalServerErrorException extends RestException {

    private int code;

    public InternalServerErrorException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
