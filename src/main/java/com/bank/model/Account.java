package com.bank.model;


import javax.persistence.Column;
import javax.persistence.Table;

@Table
public class Account extends BaseEntity {

    @Column(nullable = false)
    private Integer clientId;

    @Column(nullable = false)
    private double balance;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
