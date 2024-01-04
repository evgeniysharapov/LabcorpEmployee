package com.labcorp.employee.data;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person {
    private String id;
    private EmployeeType employeeType;

    private float vacationDaysAccrued;

    private float vacationDaysTaken;

    private int daysWorked;

    @Builder
    public Employee(String firstName, String lastName, boolean isMale, Date dateOfBirth, String id, EmployeeType employeeType) {
        super(firstName, lastName, isMale, dateOfBirth);
        this.id = id;
        this.employeeType = employeeType;
    }

}
