package com.atm.atmproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessfulResponseIterable {

    private int code;
    private String message;
    private Iterable<?> data;



    public SuccessfulResponseIterable(int code, String message, Iterable<?> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public SuccessfulResponseIterable(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Iterable<?> getData() {
        return data;
    }

    public void setData(Iterable<?> data) {
        this.data = data;
    }


}
