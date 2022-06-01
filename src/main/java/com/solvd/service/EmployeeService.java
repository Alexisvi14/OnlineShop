package com.solvd.service;

import com.solvd.bin.Employee;

public interface EmployeeService {
    Employee getEmployee(long id);
    void saveEmployee(Employee employee);
    void update(Employee employee);
    void delete(long id);
}
