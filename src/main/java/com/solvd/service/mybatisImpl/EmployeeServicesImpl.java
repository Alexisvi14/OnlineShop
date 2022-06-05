package com.solvd.service.mybatisImpl;

import com.solvd.bin.Employee;
import com.solvd.dao.IEmployeeDAO;
import com.solvd.service.EmployeeService;
import com.solvd.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class EmployeeServicesImpl implements EmployeeService {
    @Override
    public Employee getEmployee(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            Employee employee = employeeDAO.getEntityById(id);
            return employee;
        }
    }

    @Override
    public void saveEmployee(Employee employee) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.saveEntity(employee);
            session.commit();
        }
    }

    @Override
    public void update(Employee employee) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.updateEntity(employee);
            session.commit();
        }
    }

    @Override
    public void delete(long id) {
        try(SqlSession session = SessionFactory.getInstance().getSession()){
            IEmployeeDAO employeeDAO = session.getMapper(IEmployeeDAO.class);
            employeeDAO.removeEntity(id);
            session.commit();
        }
    }
}
