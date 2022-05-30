package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.DAO.IPaymentDAO;
import com.solvd.bin.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO extends AbstractDAO implements IPaymentDAO {
    private final static Logger LOGGER = LogManager.getLogger(PaymentDAO.class);
    private final static String INSERT = "INSERT INTO Payments (money, place, idAccounts) VALUES (?,?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Payments SET money=?,place=?,idAccounts=?, WHERE idPayments=?";
    private final static String SELECT = "SELECT * FROM Payments WHERE idPayments=?";
    private final static String DELETE = "DELETE FROM Payments WHERE idPayments=?";

    @Override
    public Payment getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Payment payment = new Payment();
            rs.next();
            payment.setId(Integer.parseInt(rs.getString("id")));
            payment.setMoney(Integer.parseInt(rs.getString("money")));
            payment.setPlace(rs.getString("place"));

            return payment;
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
    public void saveEntity(Payment entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        Double money = entity.getMoney();
        String place = entity.getPlace();

        try {
            pr = con.prepareStatement(INSERT);
            pr.execute();
        } catch (SQLException e) {
            LOGGER.info("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try{
                if (pr != null);
                pr.close();
            }catch (SQLException e){
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateEntity(Payment entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        Double money = entity.getMoney();
        String place = entity.getPlace();

        try{
            pr = con.prepareStatement(UPDATE);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null);
                pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing");
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
