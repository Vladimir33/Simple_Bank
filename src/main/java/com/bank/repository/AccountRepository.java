package com.bank.repository;

import com.bank.model.Account;

import java.util.List;

public interface AccountRepository {

    Account get(int id);

    List<Account> getAll(int id);

    Account save(Account account);

    boolean delete(int id);

    void updateBalance(int accountFrom, int accountTo, double amount, String description);
}
