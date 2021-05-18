package com.pathum.EmployeeManager.controller;

import com.pathum.EmployeeManager.model.Employee;
import com.pathum.EmployeeManager.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
