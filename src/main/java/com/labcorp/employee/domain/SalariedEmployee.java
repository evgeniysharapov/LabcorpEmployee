package com.labcorp.employee.domain;


import java.util.UUID;

public class SalariedEmployee extends AbstractEmployee implements Employee {

    public SalariedEmployee(){
        this(UUID.randomUUID().toString());
    }

    public SalariedEmployee(String id){
        super(15);
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
