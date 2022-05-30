package com.solvd.DAO.service.serviceImpl;

import com.solvd.DAO.IEmployeeDAO;
import com.solvd.DAO.jdbcMYSQLImpl.EmployeeDAO;
import com.solvd.DAO.service.EmployeeService;
import com.solvd.bin.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee getEmployee(long id) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEntityById(id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.saveEntity(employee);
    }

    @Override
    public void update(Employee employee) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.updateEntity(employee);
    }

    @Override
    public void delete(long id) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.removeEntity(id);
    }
}
