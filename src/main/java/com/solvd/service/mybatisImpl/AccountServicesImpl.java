package com.solvd.service.mybatisImpl;

import com.solvd.dao.IAccountDAO;
import com.solvd.dao.Impl.AccountDAO;
import com.solvd.service.AccountService;
import com.solvd.bin.Account;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AccountServicesImpl implements AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountServicesImpl.class);

    @Override
    public Account getAccount(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            Account account = accountDAO.getEntityById(id);
            return account;
        }
    }

    @Override
    public void saveAccount(Account account) {
        try(SqlSession session = SessionFactory.getInstance().getSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.saveEntity(account);
            session.commit();
        }
    }

    @Override
    public void update(Account account) {
        try(SqlSession session = SessionFactory.getInstance().getSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.updateEntity(account);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()) {
            IAccountDAO accountDAO = session.getMapper(IAccountDAO.class);
            accountDAO.removeEntity(id);
            session.commit();
        }
    }
}

