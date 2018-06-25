package com.arenteria.test.truelogic.core.exception;

public class InternalServerErrorException extends RestException {

    private static final int CODE = 500;

    public InternalServerErrorException (String msg) {
        super(CODE, msg);
    }
}
