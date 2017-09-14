package com.bank.repository;

import com.bank.model.Account;

import java.util.List;

public class AccountRepositoryImpl extends AbstractRepository<Account> implements AccountRepository {
    @Override
    public Account get(int id) {
        return doFind(Account.class, id);
    }

    @Override
    public List<Account> getAll() {
        return em.createNamedQuery(Account.ACC_ALL_SORTED, Account.class).getResultList();
    }

    @Override
    public Account save(Account account) {
        return doSave(account);
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Account.ACC_DELETE).setParameter("id", id).executeUpdate() != 0;
    }
}
