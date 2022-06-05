package com.solvd.service.jdbcImpl;

import com.solvd.dao.IClientDAO;
import com.solvd.dao.Impl.ClientDAO;
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
