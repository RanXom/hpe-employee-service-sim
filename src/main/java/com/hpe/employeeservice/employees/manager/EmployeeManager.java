
package com.hpe.employeeservice.employees.manager;

import com.hpe.employeeservice.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManager {

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeManager() {
        employeeList.add(new Employee("1", "Saiyed", "Shizain", "saiyedshizain@gmail.com", "Backend Developer"));
        employeeList.add(new Employee("2", "Saul", "Goodman", "saulgoodman@sgassociates.com", "Criminal Lawyer"));
        employeeList.add(new Employee("3", "Tyler", "Durden", "tylerdd@fc.com", "Soap Developer"));
    }

    public List<Employee> getAllEmployees() {
        return this.employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }
}