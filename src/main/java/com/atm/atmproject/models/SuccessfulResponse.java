package com.atm.atmproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessfulResponse {
    private int code;
    private String message;
    private Iterable<?> data;
    private Optional<?> Data;


    public SuccessfulResponse(int code, String message, Iterable<?> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SuccessfulResponse(int code, String message, Optional<?> Data) {
        this.code = code;
        this.message = message;
        this.Data = Data;
    }

    public SuccessfulResponse(int code, String message) {
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

    public void setData(Optional<?> data) {
        Data = data;
    }
}
