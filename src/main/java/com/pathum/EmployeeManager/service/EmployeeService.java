package com.pathum.EmployeeManager.service;

import com.pathum.EmployeeManager.dao.EmployeeDAO;
import com.pathum.EmployeeManager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployeeById(id);
    }

}
