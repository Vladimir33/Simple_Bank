package com.bank.repository;

import com.bank.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
    @Transactional
    public Account save(Account account) {
        return doSave(account);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Account.ACC_DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public void updateBalance(int accountFrom, int accountTo, double amount, String description) {
        Account from = get(accountFrom);
        Account to = get(accountTo);

        if (Objects.equals(description, "Top Up")) {
            to.setBalance(to.getBalance() + amount);
        } else if (Objects.equals(description, "Withdraw")) {
            from.setBalance(from.getBalance() - amount);
        } else {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }
}
