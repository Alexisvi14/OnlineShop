package com.solvd.DAO.jdbcMYSQLImpl;

import com.solvd.DAO.IEmployeeDAO;
import com.solvd.bin.staff.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends AbstractDAO implements IEmployeeDAO {
    private final static Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);
    private final static String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM Employees WHERE idEmployees=?";
    private final static String DELETE_EMPLOYEE_BY_ID = "DELETE FROM Employees WHERE idEmployees=?";

    @Override
    public Employee getEntityById(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try{
            pr = con.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Employee employee = new Employee();
            rs.next();
            employee.setId(Integer.parseInt(rs.getString("id")));
            employee.setFirstName(rs.getString("firstName"));
            employee.setLastName(rs.getString("lastName"));
            employee.setSalary(Integer.parseInt(rs.getString("salary")));

            return employee;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try{
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
    public void saveEntity(Employee entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        double salary = entity.getSalary();

        try {
            String query = "INSERT INTO Employees (first_Name,last_Name,salary) VALUES (" + firstName.toString() +
                    "," + lastName.toString() + "," + salary + ")";
            pr = con.prepareStatement(query);
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
    public void updateEntity(Employee entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        double salary = entity.getSalary();

        try {
            String query = "UPDATE Employees SET first_Name=" + firstName.toString() + "last_Name=" +
                    lastName.toString() + "salary=" + salary + "WHERE idEmployees=?";
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

        try {
            pr = con.prepareStatement(DELETE_EMPLOYEE_BY_ID);
            pr.setLong(1, id);
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
