package com.arenteria.test.truelogic.core.exception;

public class NotFoundException extends RestException {

    private static final int CODE = 404;

    public NotFoundException (String msg) {
        super(CODE, msg);
    }
}