package com.labcorp.employee.domain;

import static java.lang.String.format;

/**
 * Basic functionality for an employee
 */
public class Employee {
    private final static int ANNUAL_WORKDAYS = 260;
    private final int annualVacationDays;
    private int daysWorked;
    private float accruedVacationDays;
    private float vacationDaysTaken;

    private String id;

    /**
     * Sets the number of vacation days an employee gets per year
     * @param annualVacationDays
     */
    protected Employee(int annualVacationDays) {
        this.annualVacationDays = annualVacationDays;
    }

    private float vacationFactor() {
        return (float)this.annualVacationDays / (float)ANNUAL_WORKDAYS;
    }

    /**
     * Shows how many vacation days an employee has accrued
     * @return
     */
    public float getAccruedVacationDays() {
        return accruedVacationDays;
    }

    /**
     * Shows how many full days employee has worked
     * @return
     */
    public int getDaysWorked() {
        return daysWorked;
    }

    /**
     * shows how many vacation days an employee has taken
     * @return
     */
    public float getVacationDaysTaken() {
        return vacationDaysTaken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Takes parameter {@code days} and adds it to the total number of days worked also updateing accrued vacation days
     * @param days
     */
    public void work(int days) {
        // check pre-conditions
        if ( days < 0 || days > ANNUAL_WORKDAYS || daysWorked + days > ANNUAL_WORKDAYS )
            throw new IllegalArgumentException(format("Number of days worked should be between 0 and %d", ANNUAL_WORKDAYS));
        daysWorked += days;
        accruedVacationDays += days * vacationFactor();
    }

    /**
     * Takes parameter {@code days}  of days on vacation and updates the total number of vacation days taken as well
     * as the number of accrued vacation days
     * @param days
     */
    public void takeVacation(float days) {
        // check pre-conditions
        if ( days < 0 || days > accruedVacationDays)
            throw new IllegalArgumentException(format("Number of vacation days should be between 0 and %f", accruedVacationDays));
        vacationDaysTaken += days;
        accruedVacationDays -= days;
    }

}
