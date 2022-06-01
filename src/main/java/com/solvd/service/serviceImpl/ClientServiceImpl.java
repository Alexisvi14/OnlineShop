package com.solvd.service.serviceImpl;

import com.solvd.DAO.IClientDAO;
import com.solvd.DAO.jdbcMYSQLImpl.ClientDAO;
import com.solvd.service.ClientService;
import com.solvd.bin.Client;

public class ClientServiceImpl implements ClientService {
    @Override
    public Client getClient(long id) {
        IClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.getEntityById(id);
        return client;
    }

    @Override
    public void saveClient(Client client) {
        IClientDAO clientDAO = new ClientDAO();
        clientDAO.saveEntity(client);
    }

    @Override
    public void update(Client client) {
        IClientDAO clientDAO = new ClientDAO();
        clientDAO.updateEntity(client);
    }

    @Override
    public void delete(long id) {
        IClientDAO clientDAO = new ClientDAO();
        clientDAO.removeEntity(id);
    }
}
