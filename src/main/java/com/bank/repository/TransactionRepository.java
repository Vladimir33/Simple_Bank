package com.bank.repository;

import com.bank.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {

    Transaction get(int id);

    List<Transaction> getAll();

    List<Transaction> getBetween(LocalDate startDate, LocalDate endDate);

    Transaction save(Transaction transaction);
}
