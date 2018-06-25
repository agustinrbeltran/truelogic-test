package com.arenteria.test.truelogic.core.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestException{

    private int code;
    private String msg;

    public RestException(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    @JsonProperty
    public int getCode() {
        return code;
    }

    @JsonProperty
    public String getMsg() {
        return msg;
    }
}