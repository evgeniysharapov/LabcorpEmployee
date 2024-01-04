package com.labcorp.employee.domain;


import java.util.UUID;

public class HourlyEmployee extends Employee {

    public HourlyEmployee() {
        this(UUID.randomUUID().toString());
    }

    public HourlyEmployee(String id){
        super(10);
        setId(id);
    }
}
