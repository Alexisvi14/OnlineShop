package com.solvd.service.mybatis;

import com.solvd.dao.IAccountDAO;
import com.solvd.service.AccountService;
import com.solvd.bin.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AccountServicesImpl extends AbstractSession implements AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountServicesImpl.class);

    @Override
    public Account getAccount(long id) {
        SqlSession session = sqlSession();
        IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
        Account account = accountDAO.getEntityById(id);
        return account;
    }
    /*Trying to optimize the code

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(Constants.MYBATISCONFIG);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(reader);
        try (SqlSession session = sql.openSession()) {
            IAccountDAO AccountDAO = session.getMapper(IAccountDAO.class);
            Account account = AccountDAO.getEntityById(id);
            return account;
        }
    }*/

    @Override
    public void saveAccount(Account account) {
        SqlSession sqlSession = sqlSession();
        IAccountDAO AccountDAO = sqlSession.getMapper(IAccountDAO.class);
        AccountDAO.saveEntity(account);
        sqlSession.commit();
        }

    @Override
    public void update(Account account) {
        SqlSession sqlSession = sqlSession();
        IAccountDAO AccountDAO = sqlSession.getMapper(IAccountDAO.class);
        AccountDAO.updateEntity(account);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IAccountDAO AccountDAO = sqlSession.getMapper(IAccountDAO.class);
        AccountDAO.removeEntity(id);
        sqlSession.commit();
        }
    }
