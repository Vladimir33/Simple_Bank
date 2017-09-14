package com.bank.service;

import com.bank.model.Account;

import java.util.List;

public interface AccountService {

    Account get(int id);

    List<Account> getAll(int id);

    Account save(Account account);

    boolean delete(int id);
}
