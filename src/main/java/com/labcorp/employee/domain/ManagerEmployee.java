package com.labcorp.employee.domain;


import java.util.UUID;

public class ManagerEmployee extends AbstractEmployee implements Employee {

    public ManagerEmployee() {
        this(UUID.randomUUID().toString());
    }
    public ManagerEmployee(String id){
        super(30);
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
