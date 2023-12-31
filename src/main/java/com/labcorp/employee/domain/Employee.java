package com.labcorp.employee.domain;

/**
 * Basic functionality for an employee
 */
public interface Employee {
    /**
     * Id of the employee
     * @return
     */
    public String getId();
    /**
     * Takes parameter {@code days} and adds it to the total number of days worked also updateing accrued vacation days
     * @param days
     */
    public void work(int days);

    /**
     * Takes parameter {@code days}  of days on vacation and updates the total number of vacation days taken as well
     * as the number of accrued vacation days
     * @param days
     */
    public void takeVacation(float days);
}
