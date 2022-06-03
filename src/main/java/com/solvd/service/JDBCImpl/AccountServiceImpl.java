package com.solvd.service.JDBCImpl;

import com.solvd.dao.IAccountDAO;
import com.solvd.dao.jdbcMYSQLImpl.AccountDAO;
import com.solvd.service.AccountService;
import com.solvd.bin.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountServiceImpl implements AccountService {
    private final static Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);


    @Override
    public Account getAccount(long id) {
        IAccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.getEntityById(id);
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.saveEntity(account);
    }

    @Override
    public void update(Account account) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.updateEntity(account);
    }

    @Override
    public void delete(long id) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.removeEntity(id);
    }
}
