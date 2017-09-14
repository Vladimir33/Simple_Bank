package com.bank.repository;

import com.bank.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientRepositoryImpl extends AbstractRepository<Client> implements ClientRepository {


    @Override
    public Client get(int id) {
        return doFind(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        return em.createNamedQuery(Client.ALL_SORTED, Client.class).getResultList();
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return doSave(client);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Client.DELETE).setParameter("id", id).executeUpdate() != 0;
    }
}
