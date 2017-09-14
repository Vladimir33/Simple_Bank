package com.bank.model;


import javax.persistence.*;

import java.util.Date;

import static com.bank.model.Account.ACC_ALL_SORTED;
import static com.bank.model.Account.ACC_DELETE;


@NamedQueries({@NamedQuery(name = ACC_ALL_SORTED, query = "SELECT a FROM Account a where a.client.id=:id ORDER BY a.balance"),
        @NamedQuery(name = ACC_DELETE, query = "DELETE FROM Account a where a.id=:id")})
@Entity
@Table
public class Account extends BaseEntity {

    public static final String ACC_ALL_SORTED = "Account.getAllSorted";
    public static final String ACC_DELETE = "Account.delete";

//    @Column(nullable = false)
//    private Integer clientId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    private Client client;

    @Column(nullable = false)
    private double balance;

    @Column
    private String description;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    public Account() {
    }

    public Account(Integer id, Client client, String description, AccountType type) {
        super(id);
        this.client = client;
        this.description = description;
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
