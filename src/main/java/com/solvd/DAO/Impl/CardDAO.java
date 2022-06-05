package com.solvd.dao.Impl;

import com.solvd.dao.ICardDAO;
import com.solvd.bin.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO extends AbstractDAO implements ICardDAO {
    private final static Logger LOGGER = LogManager.getLogger(CardDAO.class);
    private final static String INSERT = "INSERT INTO Cards (number, idAccounts) VALUES (?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Cards SET number=?,idAccounts=? WHERE idCards=?";
    private final static String SELECT = "SELECT * FROM Cards WHERE idCards=?";
    private final static String DELETE = "DELETE FROM Cards WHERE idCards=?";

    @Override
    public Card getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Card card = new Card();
            rs.next();
            card.setId(Integer.parseInt(rs.getString("idCards")));
            card.setNumber(Integer.parseInt(rs.getString("number")));

            return card;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        } finally {
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
    public void saveEntity(Card entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();

        try{
            pr = con.prepareStatement(INSERT);
            pr.setInt(1, entity.getNumber());
            pr.setLong(2, entity.getId());
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
    public void updateEntity(Card entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();

        try{
            pr = con.prepareStatement(UPDATE);
            pr.setInt(1, entity.getNumber());
            pr.setLong(2, entity.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try{
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

        try {
            pr = con.prepareStatement(DELETE);
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try{
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }
}
