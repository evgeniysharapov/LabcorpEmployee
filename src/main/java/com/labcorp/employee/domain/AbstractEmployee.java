package com.labcorp.employee.domain;

import static java.lang.String.format;

public abstract class AbstractEmployee {
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
    protected AbstractEmployee(int annualVacationDays) {
        this.annualVacationDays = annualVacationDays;
    }

    private float vacationFactor() {
        return (float)this.annualVacationDays / (float)ANNUAL_WORKDAYS;
    }

    protected void addWork(int days) {
        // check pre-conditions
        if ( days < 0 || days > ANNUAL_WORKDAYS )
            throw new IllegalArgumentException(format("Number of days worked should be between 0 and %d", ANNUAL_WORKDAYS));
        daysWorked += days;
        accruedVacationDays += days * vacationFactor();
    }

    protected void removeVacation(float days) {
        // check pre-conditions
        if ( days < 0 || days > accruedVacationDays)
            throw new IllegalArgumentException(format("Number of vacation days should be between 0 and %f", accruedVacationDays));
        vacationDaysTaken += days;
        accruedVacationDays -= days;
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
}
