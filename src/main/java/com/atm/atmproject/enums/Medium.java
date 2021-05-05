package com.atm.atmproject.enums;

public enum Medium {
    BALANCE("balance"),
    REWARDS("rewards");

    private final String medium;

    Medium(String medium) {
        this.medium = medium;
    }

    public String getMedium() {
        return medium;
    }
}
