package com.solvd.service;

import com.solvd.bin.Client;

public interface ClientService {
    Client getClient(long id);
    void saveClient(Client client);
    void update(Client client);
    void delete(long id);
}
