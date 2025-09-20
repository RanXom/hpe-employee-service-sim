package com.hpe.employeeservice.employees.controllers;

import com.hpe.employeeservice.employees.manager.EmployeeManager;
import com.hpe.employeeservice.employees.model.Employee;
import com.hpe.employeeservice.employees.model.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    public ResponseEntity<Employees> getEmployees() {
        Employees employeesWrapper = new Employees();
        employeesWrapper.setEmployees(employeeManager.getAllEmployees());
        return ResponseEntity.ok(employeesWrapper);
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
