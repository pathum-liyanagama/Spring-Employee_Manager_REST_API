package com.pathum.EmployeeManager.controller;

import com.pathum.EmployeeManager.model.Employee;
import com.pathum.EmployeeManager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    void deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);

        if(employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee not found"
            );
        }

        employeeService.deleteEmployee(employeeId);
    }

}
