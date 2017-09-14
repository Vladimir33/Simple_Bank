package com.bank.service;

import com.bank.model.Client;

import java.util.List;

public interface ClientService {

    Client get(int id);

    List<Client> getAll();

    Client save(Client client);

    boolean delete(int id);
}
