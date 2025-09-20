package com.hpe.employeeservice.employees.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpe.employeeservice.employees.controllers.EmployeeController;
import com.hpe.employeeservice.employees.manager.EmployeeManager;
import com.hpe.employeeservice.employees.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeManager employeeManager;

    @Autowired
    private ObjectMapper objectMapper;

    // --- TEST FOR THE GET ENDPOINT ---
    @Test
    public void testGetEmployees() throws Exception {
        Employee emp1 = new Employee("1", "Saiyed", "Shizain", "saiyedshizain@gmail.com", "Backend Developer");
        Employee emp2 = new Employee("3", "Tyler", "Durden", "tylerdd@fc.com", "Soap Developer");
        List<Employee> employeeList = Arrays.asList(emp1, emp2);

        when(employeeManager.getAllEmployees()).thenReturn(employeeList);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees", hasSize(2)))
                .andExpect(jsonPath("$.employees[0].first_name", is("Saiyed")));
    }

    // --- TEST FOR THE POST ENDPOINT ---
    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee("4", "Saul", "Goodman", "saulgoodman@sgassociates.com", "Criminal Lawyer");

        // This is a special mock case: the addEmployee method returns void.
        // We don't need a `when().thenReturn()` here. We'll verify the call later.

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(status().isCreated());

        verify(employeeManager, times(1)).addEmployee(any(Employee.class));
    }
}