package com.labcorp.employee.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Business logic tests for the Employee domain
 */
public class EmployeeTests {

    public static final int MAX_DAYS_WORKED = 260;

    @Test
    public void testSalariedEmployee_Work_WholeYear() {
        Employee employee = new SalariedEmployee();
        employee.work(MAX_DAYS_WORKED);
        assertDoesNotThrow(() -> employee.takeVacation(15));
    }

    @Test
    public void testHourlyEmployee_Work_WholeYear() {
        Employee employee = new HourlyEmployee();
        employee.work(MAX_DAYS_WORKED);
        assertDoesNotThrow(() -> employee.takeVacation(10));
    }

    @Test
    public void testManagerEmployee_Work_WholeYear() {
        Employee employee = new ManagerEmployee();
        employee.work(MAX_DAYS_WORKED);
        assertDoesNotThrow(() -> employee.takeVacation(30));
    }

    @Test
    public void testSalariedEmployee_IllegalVacation() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            SalariedEmployee salariedEmployee = new SalariedEmployee();
            salariedEmployee.work(5);
            salariedEmployee.takeVacation(2);
        });
        assertEquals("Number of vacation days should be between 0 and 0.288462", e.getMessage());
    }

    @Test
    public void testHourlyEmployee_IllegalVacation() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Employee employee = new HourlyEmployee();
            employee.work(5);
            employee.takeVacation(2);
        });
        assertEquals("Number of vacation days should be between 0 and 0.192308", e.getMessage());
    }

    @Test
    public void testManagerEmployee_IllegalVacation() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Employee employee = new ManagerEmployee();
            employee.work(5);
            employee.takeVacation(2);
        });
        assertEquals("Number of vacation days should be between 0 and 0.576923", e.getMessage());
    }

    @Test
    public void testAnyEmployee_IllegalWork_Over() {
        Class[] employeeTypes =  new Class[] {HourlyEmployee.class, ManagerEmployee.class, SalariedEmployee.class};
        Random random = new Random();
        for( Class employeeType : employeeTypes ) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                Employee employee = (Employee) employeeType.newInstance();
                // random number over 260
                employee.work(random.nextInt(1000) + MAX_DAYS_WORKED);
            });
            assertEquals(format("Number of days worked should be between 0 and %d", MAX_DAYS_WORKED), e.getMessage());
        }
    }

    @Test
    public void testAnyEmployee_IllegalWork_Under() {
        Class[] employeeTypes =  new Class[] {HourlyEmployee.class, ManagerEmployee.class, SalariedEmployee.class};
        Random random = new Random();
        for( Class employeeType : employeeTypes ) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                Employee employee = (Employee) employeeType.newInstance();
                // random negative number
                employee.work(random.nextInt(1000) * -1);
            });
            assertEquals(format("Number of days worked should be between 0 and %d", MAX_DAYS_WORKED), e.getMessage());
        }
    }


}
