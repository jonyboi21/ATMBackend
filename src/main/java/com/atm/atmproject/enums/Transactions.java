package com.atm.atmproject.enums;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public enum Transactions {
    P2P("p2p"),
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

    @NotNull
    private final String type;

    Transactions(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
