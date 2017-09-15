package com.bank.repository;

import com.bank.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class TransactionRepositoryImpl extends AbstractRepository<Transaction> implements TransactionRepository {
    @Override
    public Transaction get(int id) {
        return doFind(Transaction.class, id);
    }

    @Override
    public List<Transaction> getAll() {
        return em.createNamedQuery(Transaction.TX_ALL_SORTED, Transaction.class).getResultList();
    }

    @Override
    public List<Transaction> getBetween(LocalDate startDate, LocalDate endDate){
        return em.createNamedQuery(Transaction.GET_BETWEEN, Transaction.class)
                .setParameter("startDate", LocalDateTime.of(startDate, LocalTime.MIN))
                .setParameter("endDate", LocalDateTime.of(endDate, LocalTime.MAX)).getResultList();
    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        return doSave(transaction);
    }
}
