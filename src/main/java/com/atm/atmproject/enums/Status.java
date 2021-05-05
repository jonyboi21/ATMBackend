package com.atm.atmproject.enums;

public enum Status {
    PENDING("pending"),
    CANCELLED("cancelled"),
    COMPLETED("completed");

    private final String status;

     Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
