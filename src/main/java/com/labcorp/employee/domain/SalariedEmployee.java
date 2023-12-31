package com.labcorp.employee.domain;


import java.util.UUID;

public class SalariedEmployee extends AbstractEmployee implements Employee {

    public SalariedEmployee(){
        this(UUID.randomUUID().toString());
    }

    public SalariedEmployee(String id){
        this(id, 15);
    }
    protected SalariedEmployee(String id, int vacationDays){
        super(vacationDays);
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
