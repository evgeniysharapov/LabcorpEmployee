package com.labcorp.employee.domain;


public class SalariedEmployee extends AbstractEmployee implements Employee {

    public SalariedEmployee(){
        super(15);
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
