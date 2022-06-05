package com.solvd.service.jdbcImpl;

import com.solvd.dao.IEmployeeDAO;
import com.solvd.dao.Impl.EmployeeDAO;
import com.solvd.service.EmployeeService;
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
