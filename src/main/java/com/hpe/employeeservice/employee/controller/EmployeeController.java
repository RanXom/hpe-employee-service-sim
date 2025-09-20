package com.hpe.employeeservice.employee.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @PostMapping
    public String createEmployee() {
        return "Employee created";
    }

    @GetMapping
    public String getEmployee() {
        return "Employee details";
    }

    @PutMapping
    public String updateEmployee() {
        return "Employee updated";
    }

    @DeleteMapping
    public String deleteEmployee() {
        return "Employee deleted";
    }
}
