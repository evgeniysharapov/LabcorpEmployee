package com.labcorp.employee.domain;


public class ManagerEmployee extends AbstractEmployee implements Employee {

    public ManagerEmployee(){
        super(30);
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
