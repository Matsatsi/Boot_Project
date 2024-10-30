package com.SpringTech.GameApp.controller;

import com.SpringTech.GameApp.entity.Employee;
import com.SpringTech.GameApp.error.EmployeeNotFoundException;
import com.SpringTech.GameApp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .name("Tumi")
                .temperature(38)
                .build();

    }

    @Test
    void saveEmployee() throws Exception {
        Employee inputEmployee = Employee.builder()
                .name("Tumi")
                .temperature(28)
                .build();
        Mockito.when(employeeService.saveEmployee(inputEmployee))
                .thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\": \"Tumi\",\n" +
                        "\t\"temperature\":28\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchEmployeeById() throws EmployeeNotFoundException {

//        Mockito.when(employeeService.fetchEmployeeById(1L))
//                .thenReturn(employee);
//
//        mockMvc.perform("/employess")
    }
}