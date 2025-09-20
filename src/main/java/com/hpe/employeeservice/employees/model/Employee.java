package com.hpe.employeeservice.employees.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}
