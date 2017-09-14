package com.bank.model;


import javax.persistence.*;

import static com.bank.model.Account.ACC_ALL_SORTED;
import static com.bank.model.Account.ACC_DELETE;


@NamedQueries({@NamedQuery(name = ACC_ALL_SORTED, query = "SELECT a FROM Account a ORDER BY a.balance"),
        @NamedQuery(name = ACC_DELETE, query = "DELETE FROM Account a where a.id=:id")})
@Entity
@Table
public class Account extends BaseEntity {

    public static final String ACC_ALL_SORTED = "Account.getAllSorted";
    public static final String ACC_DELETE = "Account.delete";

//    @Column(nullable = false)
//    private Integer clientId;

    @ManyToOne
    private Client client;


    @Column(nullable = false)
    private double balance;

    public Account() {
    }

    public Account(Integer id, Client client, double balance) {
        super(id);
        this.client = client;
        this.balance = balance;
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
}
