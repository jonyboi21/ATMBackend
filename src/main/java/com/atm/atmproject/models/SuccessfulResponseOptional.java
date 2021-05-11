package com.atm.atmproject.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessfulResponseOptional {

    private int code;
    private String message;
    private Optional<?> data;

    public SuccessfulResponseOptional(int code, String message, Optional<Account> date) {
        this.code = code;
        this.message = message;
        this.data = date;
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

    public Optional<?> getData() {
        return data;
    }

    public void setData(Optional<?> data) {
        this.data = data;
    }
}
