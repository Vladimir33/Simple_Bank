package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Account get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Account> getAll(int id) {
        return repository.getAll(id);
    }

    @Override
    @Transactional
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return repository.delete(id);
    }
}
