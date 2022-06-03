package com.solvd.dao.jdbcMYSQLImpl;

import com.solvd.dao.IShopDAO;
import com.solvd.bin.Shop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopDAO extends AbstractDAO implements IShopDAO {
    private final static Logger LOGGER = LogManager.getLogger(ShopDAO.class);
    private final static String INSERT = "INSERT INTO Shops (name, web_page, phone_number, idOwner, idClients) VALUES (?,?,?,?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Shops SET name=?,web_page=?, phone_number=?, idOwner=?, idClients=? WHERE idShop=?";
    private final static String SELECT = "SELECT * FROM Shops WHERE idShop=?";
    private final static String DELETE = "DELETE FROM Shops WHERE idShop=?";

    @Override
    public Shop getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();

        try {
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Shop shop = new Shop();
            rs.next();
            shop.setId(Integer.parseInt(rs.getString("idShop")));
            shop.setName(rs.getString("name"));
            shop.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            shop.setWebPage(rs.getString("web_page"));

            return shop;
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
    public void saveEntity(Shop entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String name = entity.getName();
        String web_page = entity.getWebPage();
        int phone_number = entity.getPhoneNumber();

        try{
            pr = con.prepareStatement(INSERT);
            pr.execute();

        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try{
                if (pr != null);
                pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateEntity(Shop entity) {
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
        try {
            pr = con.prepareStatement(DELETE);
            pr.setLong(Integer.parseInt("1"), id);
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
                throw new RuntimeException();
            }
        }
    }
}
