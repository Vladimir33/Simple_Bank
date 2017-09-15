package com.bank.service;

import com.bank.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    Transaction get(int id);

    List<Transaction> getAll();

    List<Transaction> getBetween(LocalDate startDate, LocalDate endDate);

    Transaction save(Transaction transaction);
}
