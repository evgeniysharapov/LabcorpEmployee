package com.labcorp.employee.controller;

import com.labcorp.employee.data.Employee;
import com.labcorp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}/work/{days}")
    public Employee work(@PathVariable String id, @PathVariable int days) {
        Employee employee = employeeService.work(id, days);
        return employee;
    }

    @PutMapping("/employee/{id}/vacation/{days}")
    public Employee vacation(@PathVariable String id, @PathVariable float days) {
        Employee employee = employeeService.takeVacation(id, days);
        return employee;
    }
}
