package com.atm.atmproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Sort;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public class SuccessfulResponse {
    private int code;
    private String message;
    private Iterable<?> data;
    private String stuff;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public SuccessfulResponse(int code, String message, Iterable<?> data) {
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public SuccessfulResponse() {
    }

    public SuccessfulResponse(int code, String fantastic_job, Optional<Customer> customerById) {
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

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }
}
