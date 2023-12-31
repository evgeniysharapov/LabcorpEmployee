package com.labcorp.employee.domain;


import java.util.UUID;

public class HourlyEmployee extends AbstractEmployee implements Employee {

    public HourlyEmployee() {
        this(UUID.randomUUID().toString());
    }
    public HourlyEmployee(String id){
        super(10);
        setId(id);
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
