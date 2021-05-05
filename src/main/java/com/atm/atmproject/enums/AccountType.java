package com.atm.atmproject.enums;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking"),
    CREDIT("Credit"),
    ;

    private final String type;


    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

