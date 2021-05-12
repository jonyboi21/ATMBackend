package com.atm.atmproject.enums;

import javax.validation.constraints.NotNull;

public enum Medium {
    BALANCE("balance"),
    REWARDS("rewards");

    @NotNull
    private final String medium;

    Medium(String medium) {
        this.medium = medium;
    }

    public String getMedium() {
        return medium;
    }
}
