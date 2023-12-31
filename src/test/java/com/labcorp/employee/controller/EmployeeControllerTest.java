package com.labcorp.employee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    EmployeeController employeeController;

    @Test
    public void testGetEmployee() {
        employeeController.getEmployee();
    }
}
