package com.bank.model;

import javax.persistence.*;

//@Entity
//@Table
@Embeddable
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType type;

    @Column(nullable = false)
    private String zipCode;

//    @OneToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Client client;

    public Address() {
    }

    public Address(String city, String street, AddressType type, String zipCode) {
        this.city = city;
        this.street = street;
        this.type = type;
        this.zipCode = zipCode;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
