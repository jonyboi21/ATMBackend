package com.atm.atmproject.enums;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking"),
    CREDIT("Credit");

    @NotNull
    private final String type;

    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

