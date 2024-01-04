package com.labcorp.employee.service;

import com.labcorp.employee.data.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a mock data store for employees.  It is not a real data store. But it's quite easy to make it one.
 * For now, it just creates a bunch of employees and stores them in a map.
 */
@Component
public class EmployeeDataStore {
    private Map<String, Employee> employees;

    public EmployeeDataStore() {
        super();
        employees = new HashMap<>();
    }

    public List<Employee> finAll() {
        return employees.values().stream().toList();
    }

    public Employee findById(String id) {
        return employees.get(id);
    }

    public Employee save(Employee employee) {
        employees.put(employee.getId(), employee);
        return employee;
    }

    public void deleteById(String id) {
        employees.remove(id);
    }

    public void delete(Employee employee) {
        employees.remove(employee.getId());
    }

}
