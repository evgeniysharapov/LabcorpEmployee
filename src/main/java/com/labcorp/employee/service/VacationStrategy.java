package com.labcorp.employee.service;

import com.labcorp.employee.data.Employee;
import com.labcorp.employee.data.EmployeeType;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * This class is responsible for calculating vacation days accrued and vacation days taken
 */
@Component
public class VacationStrategy {
    private final static int ANNUAL_WORKDAYS = 260;


    private float vacationFactor(EmployeeType employeeType) {
        return (float) employeeType.maxVacationDays / (float) ANNUAL_WORKDAYS;
    }

    public void work(Employee e, int days) {
        // check pre-conditions
        // we can't cap the number of days worked either
        if (days < 0 || days > ANNUAL_WORKDAYS || days + e.getDaysWorked() > ANNUAL_WORKDAYS)
            throw new IllegalArgumentException(format("Number of days worked should be between 0 and %d but was %d", ANNUAL_WORKDAYS, days));
        // XXX: there's still a case of working over a year
        e.setDaysWorked(e.getDaysWorked() + days);
        e.setVacationDaysAccrued(e.getVacationDaysAccrued() + days * vacationFactor(e.getEmployeeType()));
    }

    public void takeVacation(Employee e, float days) {
        // check pre-conditions
        if (days < 0 || days > e.getVacationDaysAccrued())
            throw new IllegalArgumentException(format("Number of vacation days should be between 0 and %f but was %f", e.getVacationDaysAccrued(), days));
        e.setVacationDaysTaken(e.getVacationDaysTaken() + days);
        e.setVacationDaysAccrued(e.getVacationDaysAccrued() - days);
    }
}