package com.bank.repository;

import com.bank.model.Client;

import java.util.List;

public interface ClientRepository {

    Client get(int id);

    List<Client> getAll();

    Client save(Client client);

    boolean delete(int id);
}
