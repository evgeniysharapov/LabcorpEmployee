package com.labcorp.employee.data;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Typical person data
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private boolean isMale;
    private Date dateOfBirth;
}
