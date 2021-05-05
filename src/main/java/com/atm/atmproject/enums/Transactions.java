package com.atm.atmproject.enums;

public enum Transactions {
    P2P("p2p"),
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

    private final String type;

    Transactions(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
