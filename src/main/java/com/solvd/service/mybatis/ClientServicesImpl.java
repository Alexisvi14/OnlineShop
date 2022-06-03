package com.solvd.service.mybatis;

import com.solvd.bin.Client;
import com.solvd.dao.IClientDAO;
import com.solvd.service.ClientService;
import org.apache.ibatis.session.SqlSession;

public class ClientServicesImpl extends AbstractSession implements ClientService {
    @Override
    public Client getClient(long id) {
        SqlSession sqlSession = sqlSession();
        IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
        Client client = clientDAO.getEntityById(id);

        return client;
    }

    @Override
    public void saveClient(Client client) {
        SqlSession sqlSession = sqlSession();
        IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
        clientDAO.saveEntity(client);
        sqlSession.commit();
    }

    @Override
    public void update(Client client) {
        SqlSession sqlSession = sqlSession();
        IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
        clientDAO.updateEntity(client);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IClientDAO clientDAO = sqlSession.getMapper(IClientDAO.class);
        clientDAO.removeEntity(id);
        sqlSession.commit();
    }
}
