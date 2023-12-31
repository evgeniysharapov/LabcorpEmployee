package com.labcorp.employee.service;

import com.labcorp.employee.domain.Employee;
import com.labcorp.employee.domain.HourlyEmployee;
import com.labcorp.employee.domain.ManagerEmployee;
import com.labcorp.employee.domain.SalariedEmployee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeService {

    private Map<String, Employee> employees;

    public EmployeeService() {
        super();
        int employeeId = 1;
        employees = new HashMap<>();
        for( int i = 0; i < 10; i++) {
            String id = String.valueOf(employeeId++);
            employees.put(id, new SalariedEmployee(id));
        }
        for( int i = 0; i < 10; i++) {
            String id = String.valueOf(employeeId++);
            employees.put(id, new HourlyEmployee(id));
        }
        for( int i = 0; i < 10; i++) {
            String id = String.valueOf(employeeId++);
            employees.put(id, new ManagerEmployee(id));
        }
    }

    public List<Employee> getEmployees() {
        return employees.values().stream().toList();
    }

}
