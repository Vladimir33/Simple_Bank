package com.bank.model;

import java.util.List;

public class Client extends BaseEntity {

    private String name;

    private int age;

    private Address address;

    private List<Account> accounts;
}
