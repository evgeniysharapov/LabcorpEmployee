package com.labcorp.employee.domain;


import java.util.UUID;

public class ManagerEmployee extends SalariedEmployee implements Employee {

    public ManagerEmployee() {
        this(UUID.randomUUID().toString());
    }
    public ManagerEmployee(String id){
        super(id, 30);
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
