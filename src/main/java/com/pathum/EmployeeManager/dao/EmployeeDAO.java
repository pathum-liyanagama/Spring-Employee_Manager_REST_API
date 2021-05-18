package com.pathum.EmployeeManager.dao;

import com.pathum.EmployeeManager.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List getAllEmployees();

    Employee findEmployeeById(int employeeId);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);

}
