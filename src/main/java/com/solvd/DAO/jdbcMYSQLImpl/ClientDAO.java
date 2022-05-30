package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.DAO.IClientDAO;
import com.solvd.bin.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientDAO extends AbstractDAO implements IClientDAO {
    private final static Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private final static String INSERT = "INSERT INTO Clients (first_name, last_name, npi, email) VALUES (?,?,?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Clients SET first_name=?,last_name=?,npi=?,email=?, WHERE idClients=?";
    private final static String SELECT = "SELECT * FROM Clients WHERE idClients=?";
    private final static String DELETE = "DELETE FROM Clients WHERE idClients=?";

    @Override
    public Client getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try{
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Client client = new Client();
            rs.next();
            client.setId(Integer.parseInt(rs.getString("idClients")));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            client.setNpi(Integer.parseInt(rs.getString("npi")));
            client.setEmail(rs.getString("email"));

            return client;
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
                LOGGER.error("Exception while closing resources", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void saveEntity(Client entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        double npi = entity.getNpi();
        String email = entity.getEmail();

        try{
            pr = con.prepareStatement(INSERT);
            pr.execute();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
        }
        try {
            if (pr != null)
                pr.close();
        } catch (SQLException e) {
            LOGGER.error("Exception while closing", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateEntity(Client entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        double npi = entity.getNpi();
        String email = entity.getEmail();

        try{
            pr = con.prepareStatement(UPDATE);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement", e);
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
        }
        try{
            if (pr != null){
                pr.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while closing", e);
            throw new RuntimeException();
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
            LOGGER.error("There was a problem while doing the statement", e);
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
        }
        try{
            if (pr != null){
                pr.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while closing", e);
            throw new RuntimeException();
        }
    }
}
