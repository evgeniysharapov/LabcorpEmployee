package com.labcorp.employee.service;

import com.labcorp.employee.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeDataStore employeeDataStore;

    @Autowired
    private VacationStrategy vacationStrategy;

    public List<Employee> getEmployees() {
        return employeeDataStore.finAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeDataStore.findById(id);
    }

    /**
     * Takes parameter {@code days} and adds it to the total number of days worked also updating accrued vacation days
     * @param days
     */
    public Employee work(String id, int days) {
        Employee employee = employeeDataStore.findById(id);
        vacationStrategy.work(employee, days);

        return employee;
    }

    /**
     * Takes parameter {@code days}  of days on vacation and updates the total number of vacation days taken as well
     * as the number of accrued vacation days
     * @param days
     */
    public Employee takeVacation(String id, float days) {
        Employee employee = employeeDataStore.findById(id);
        vacationStrategy.takeVacation(employee, days);
        return employee;
    }
}
