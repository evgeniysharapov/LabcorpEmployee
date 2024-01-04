package com.labcorp.employee.service;


import com.labcorp.employee.LabcorpEmployeeConfig;
import com.labcorp.employee.data.Employee;
import com.labcorp.employee.data.EmployeeType;
import com.labcorp.employee.service.VacationStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = {VacationStrategy.class})
public class VacationStrategyTest {
    @Autowired
    VacationStrategy vacationStrategy;

    @Test
    public void testHourlyEmployee_Work_WholeYear() {
        Employee employee = Employee
                .builder()
                .id("1")
                .employeeType(EmployeeType.HOURLY)
                .firstName("John")
                .lastName("Doe")
                .isMale(true)
                .dateOfBirth(Date.valueOf("1980-01-01"))
                .build();

        vacationStrategy.work(employee, 260);
        assertDoesNotThrow(() -> vacationStrategy.takeVacation(employee, 10));
    }

    @Test
    public void testSalariedEmployee_Work_WholeYear() {
        Employee employee = Employee
                .builder()
                .id("1")
                .employeeType(EmployeeType.SALARIED)
                .firstName("John")
                .lastName("Doe")
                .isMale(true)
                .dateOfBirth(Date.valueOf("1980-01-01"))
                .build();

        vacationStrategy.work(employee, 260);
        assertDoesNotThrow(() -> vacationStrategy.takeVacation(employee, 15));
    }
}
