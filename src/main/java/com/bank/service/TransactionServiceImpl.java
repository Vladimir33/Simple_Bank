package com.bank.service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Transaction> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Transaction> getBetween(LocalDate startDate, LocalDate endDate) {
        return repository.getBetween(startDate, endDate);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
}
