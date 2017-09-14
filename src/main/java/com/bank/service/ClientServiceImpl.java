package com.bank.service;

import com.bank.model.Client;
import com.bank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.getAll();
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}
