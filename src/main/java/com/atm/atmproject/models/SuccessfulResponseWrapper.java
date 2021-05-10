package com.atm.atmproject.models;

public class SuccessfulResponseWrapper {
    private SuccessfulResponse successfulResponse;

    public SuccessfulResponseWrapper(SuccessfulResponse successfulResponse) {
        this.successfulResponse = successfulResponse;
    }

    public SuccessfulResponse getSuccessfulResponse() {
        return successfulResponse;
    }

    public void setSuccessfulResponse(SuccessfulResponse successfulResponse) {
        this.successfulResponse = successfulResponse;
    }
}
