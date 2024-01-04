package com.labcorp.employee.domain;


import java.util.UUID;

public class ManagerEmployee extends SalariedEmployee {

    public ManagerEmployee() {
        this(UUID.randomUUID().toString());
    }
    public ManagerEmployee(String id){
        super(id, 30);
    }
}
