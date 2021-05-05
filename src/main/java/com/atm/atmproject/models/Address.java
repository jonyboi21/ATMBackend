package com.atm.atmproject.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ADDRESS_ID")
    private Long id;

    private String street_number;

    private String street_name;

    private String city;

    private String state;

    private String zip;
}
