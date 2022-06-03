package com.solvd.dao.jdbcMYSQLImpl;

import com.solvd.dao.IAccountDAO;
import com.solvd.bin.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAO extends AbstractDAO implements IAccountDAO {
    private final static Logger LOGGER = LogManager.getLogger(AccountDAO.class);
    private final static String INSERT = "INSERT INTO Accounts (balance, cbu) VALUES (?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Accounts SET balance=?,cbu=?, WHERE idAccounts=?";
    private final static String SELECT = "SELECT * FROM Accounts WHERE idAccounts=?";
    private final static String DELETE = "DELETE FROM Accounts WHERE idAccounts=?";

    @Override
    public Account getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Account account = new Account();
            rs.next();
            account.setId(Integer.parseInt(rs.getString("idAccounts")));
            account.setBalance(Double.parseDouble(rs.getString("balance")));
            account.setCbu(Double.parseDouble(rs.getString("cbu")));

            return account;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void saveEntity(Account entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();

        try {
            pr = con.prepareStatement(INSERT);
            pr.execute();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateEntity(Account entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();

        try {
            pr = con.prepareStatement(UPDATE);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void removeEntity(long id) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try{
            pr = con.prepareStatement(DELETE);
            pr.setLong(1, id);
            pr.execute();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException();
        }
        finally {
            returnConnection(con);
        }try {
            if(pr != null){
                pr.close();
            }
        } catch (SQLException e) {
            LOGGER.error("There was a problem closing", e);
            throw new RuntimeException();
        }
    }
}
