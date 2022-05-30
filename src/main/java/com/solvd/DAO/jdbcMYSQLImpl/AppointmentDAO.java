package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.DAO.IAppointmentDAO;
import com.solvd.bin.Appointment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AppointmentDAO extends AbstractDAO implements IAppointmentDAO {
    private final static Logger LOGGER = LogManager.getLogger(AppointmentDAO.class);
    private final static String INSERT = "INSERT INTO Appointments (date, time, idClients) VALUES (?,?,?) WHERE id=?";
    private final static String UPDATE = "UPDATE Appointments SET date=?,time=?,idClients=?, WHERE idAppointments=?";
    private final static String SELECT = "SELECT * FROM Appointments WHERE idAppointments=?";
    private final static String DELETE = "DELETE FROM Appointments WHERE idAppointments=?";

    @Override
    public Appointment getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();

        try{
            pr = con.prepareStatement(SELECT);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Appointment appointment = new Appointment();
            rs.next();
            appointment.setId(Integer.parseInt(rs.getString("id")));
            appointment.setDate(Date.from(Instant.parse(rs.getString("date"))));
            appointment.setTime(Time.valueOf(rs.getString("time")));

            return appointment;
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
    public void saveEntity(Appointment entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        long id = entity.getId();
        Date date = entity.getDate();
        Time time = entity.getTime();

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
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateEntity(Appointment entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        long id = entity.getId();
        Date date = entity.getDate();
        Time time = entity.getTime();

        try {
            pr = con.prepareStatement(UPDATE);
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
