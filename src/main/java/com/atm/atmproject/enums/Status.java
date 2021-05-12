package com.atm.atmproject.enums;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public enum Status {
    PENDING("pending"),
    CANCELLED("cancelled"),
    COMPLETED("completed"),
    RECURRING("recurring");

    @NotNull
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
