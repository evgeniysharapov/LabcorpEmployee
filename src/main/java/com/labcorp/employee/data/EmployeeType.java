package com.labcorp.employee.data;

/**
 * Type of an employee: manager, salaried, hourly, etc.
 */
public enum EmployeeType {
    HOURLY(10),
    SALARIED(15),
    MANAGER(30);

    public final int maxVacationDays;

    private EmployeeType(int maxVacationDays) {
        this.maxVacationDays = maxVacationDays;
    }
}
