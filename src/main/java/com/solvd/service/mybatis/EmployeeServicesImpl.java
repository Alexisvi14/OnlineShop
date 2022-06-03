package com.solvd.service.mybatis;

import com.solvd.bin.Employee;
import com.solvd.dao.ICardDAO;
import com.solvd.dao.IEmployeeDAO;
import com.solvd.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;

public class EmployeeServicesImpl extends AbstractSession implements EmployeeService {
    @Override
    public Employee getEmployee(long id) {
        SqlSession sqlSession = sqlSession();
        IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
        Employee employee = employeeDAO.getEntityById(id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        SqlSession sqlSession = sqlSession();
        IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
        employeeDAO.saveEntity(employee);
        sqlSession.commit();
    }

    @Override
    public void update(Employee employee) {
        SqlSession sqlSession = sqlSession();
        IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
        employeeDAO.updateEntity(employee);
        sqlSession.commit();
    }

    @Override
    public void delete(long id) {
        SqlSession sqlSession = sqlSession();
        IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
        employeeDAO.removeEntity(id);
        sqlSession.commit();
    }
}
