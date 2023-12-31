package com.labcorp.employee.controller;

import com.labcorp.employee.domain.Employee;
import com.labcorp.employee.domain.SalariedEmployee;
import com.labcorp.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    EmployeeController employeeController;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testGetEmployee() {
        List<Employee> result =  employeeController.getEmployee();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeController.getEmployeeById("1");
        assertNotNull(employee);
        assertEquals("1", employee.getId());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testWork() {
        Employee employee = employeeController.work("1", 5);
        assertNotNull(employee);
        assertEquals("1", employee.getId());
        assertEquals(5, employee.getDaysWorked());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testVacation() {
        Employee emp = employeeController.getEmployeeById("1");
        // we just want to take a vacation for 1 day
        if( emp.getAccruedVacationDays() < 1) {
            employeeController.work("1", 60); // at least one day in 2 months
        }

        Employee employee = employeeController.vacation("1", 1);
        assertNotNull(employee);
        assertEquals(1, employee.getVacationDaysTaken());
        assertTrue(employee.getAccruedVacationDays() > 0);

    }
}
