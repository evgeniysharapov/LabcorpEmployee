package com.labcorp.employee.domain;


public class HourlyEmployee extends AbstractEmployee implements Employee {

    public HourlyEmployee(){
        super(10);
    }

    @Override
    public void work(int days) {
        addWork(days);
    }

    @Override
    public void takeVacation(float days) {
        removeVacation(days);
    }
}
