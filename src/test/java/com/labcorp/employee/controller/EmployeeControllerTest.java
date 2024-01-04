package com.labcorp.employee.controller;

import com.labcorp.employee.data.Employee;
import com.labcorp.employee.service.EmployeeDataStore;
import com.labcorp.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static com.labcorp.employee.data.EmployeeType.HOURLY;
import static com.labcorp.employee.data.EmployeeType.MANAGER;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    EmployeeController employeeController;

    @Autowired
    EmployeeDataStore employeeDataStore;

    @Autowired
    EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        // creating hourly employee
        employeeDataStore.save(Employee.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .isMale(true)
                .employeeType(HOURLY)
                .build());
        // creating salaried employee
        employeeDataStore.save(Employee.builder()
                .id("2")
                .firstName("Jane")
                .lastName("Doe")
                .isMale(false)
                .employeeType(HOURLY)
                .build());
        // creating manager employee
        employeeDataStore.save(Employee.builder()
                .id("3")
                .firstName("John")
                .lastName("Smith")
                .isMale(true)
                .employeeType(MANAGER)
                .build());
    }

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
        // do some work
        employeeController.work("1", 30);
        // take vacation
        Employee employee = employeeController.vacation("1", 1);
        assertNotNull(employee);
        assertEquals(1, employee.getVacationDaysTaken());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testNotEnoughVacation() {
        Employee emp = employeeController.getEmployeeById("1");
        // do some work
        employeeController.work("1", 3);
        // try take vacation
        assertThrows(IllegalArgumentException.class, () -> employeeController.vacation("1", 1));
    }

}
