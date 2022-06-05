package com.solvd.service.mybatisImpl;

import com.solvd.bin.Client;
import com.solvd.dao.IClientDAO;
import com.solvd.service.ClientService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class ClientServicesImpl implements ClientService {
    @Override
    public Client getClient(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IClientDAO clientDAO = session.getMapper(IClientDAO.class);
            Client client = clientDAO.getEntityById(id);
            return client;
        }
    }

    @Override
    public void saveClient(Client client) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IClientDAO clientDAO = session.getMapper(IClientDAO.class);
            clientDAO.saveEntity(client);
            session.commit();
        }
    }

    @Override
    public void update(Client client) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IClientDAO clientDAO = session.getMapper(IClientDAO.class);
            clientDAO.updateEntity(client);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IClientDAO clientDAO = session.getMapper(IClientDAO.class);
            clientDAO.removeEntity(id);
            session.commit();
        }
    }
}
