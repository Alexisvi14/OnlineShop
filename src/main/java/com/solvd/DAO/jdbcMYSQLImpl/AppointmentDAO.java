package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.DAO.IAppointmentDAO;
import com.solvd.bin.clientRelated.Appointment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDAO extends AbstractDAO implements IAppointmentDAO {
    private final static Logger LOGGER = LogManager.getLogger(AppointmentDAO.class);
    private final static String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM Appointments WHERE idAppointments=?";
    private final static String DELETE_APPOINTMENT_BY_ID = "DELETE FROM Appointments WHERE idAppointments=?";

    @Override
    public Appointment getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();

        try{
            pr = con.prepareStatement(SELECT_APPOINTMENT_BY_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Appointment appointment = new Appointment();
            rs.next();
            appointment.setId(Integer.parseInt(rs.getString("id")));
            appointment.setDate(LocalDate.ofEpochDay(Integer.parseInt(rs.getString("date"))));
            appointment.setTime(LocalTime.ofSecondOfDay(Integer.parseInt(rs.getString("time"))));

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
        LocalTime time = entity.getTime();
        LocalDate date = entity.getDate();

        try{
            String query = "INSERT INTO Appointment (id,time,date) VALUES (" + id + "," + time.toString() + ","
                    + date.toString() + ")";
            pr = con.prepareStatement(query);
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
        LocalTime time = entity.getTime();
        LocalDate date = entity.getDate();

        try {
            String query = "UPDATE Appointments SET id=" + id + "time=" + time.toString() + "date=" +
                    date.toString() + "WHERE idAppointments=?";
            pr = con.prepareStatement(query);
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
            pr = con.prepareStatement(DELETE_APPOINTMENT_BY_ID);
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
