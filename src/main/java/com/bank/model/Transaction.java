package com.bank.model;


import javax.persistence.*;
import java.time.LocalDateTime;

import static com.bank.model.Transaction.GET_BETWEEN;
import static com.bank.model.Transaction.TX_ALL_SORTED;

@NamedQueries({@NamedQuery(name = TX_ALL_SORTED, query = "SELECT t FROM Transaction t ORDER BY t.dateTime DESC"),
@NamedQuery(name = GET_BETWEEN, query = "SELECT t FROM Transaction t WHERE" +
        " t.dateTime BETWEEN :startDate AND :endDate ORDER BY t.dateTime DESC")})
@Entity
@Table
public class Transaction extends BaseEntity {

    public static final String TX_ALL_SORTED = "TX.getAllSorted";
    public static final String GET_BETWEEN = "TX.getBetween";

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "tx_time", columnDefinition = "timestamp default now()")
    private LocalDateTime dateTime = LocalDateTime.now();


    @OneToOne
    private Account accountTo;

    @OneToOne
    private Account accountFrom;

    @Column
    private String description;

    public Transaction(Integer id, double amount, TransactionType type, Account accountTo, Account accountFrom, String description) {
        super(id);
        this.amount = amount;
        this.type = type;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.description = description;
    }

    public Transaction() {
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
