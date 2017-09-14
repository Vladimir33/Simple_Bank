package com.bank.repository;

import com.bank.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl extends AbstractRepository<Account> implements AccountRepository {
    @Override
    public Account get(int id) {
        return doFind(Account.class, id);
    }

    @Override
    public List<Account> getAll(int id) {
        return em.createNamedQuery(Account.ACC_ALL_SORTED, Account.class).setParameter("id", id).getResultList();
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
