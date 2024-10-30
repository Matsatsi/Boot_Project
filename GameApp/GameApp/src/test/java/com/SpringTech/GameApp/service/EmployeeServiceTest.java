package com.SpringTech.GameApp.service;

import com.SpringTech.GameApp.entity.Employee;
import com.SpringTech.GameApp.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee= Employee.builder()
                .name("Matsatsi")
                .temperature(34)
                .build();

        Mockito.when(employeeRepository.findByNameIgnoreCase("Matsatsi"))
                .thenReturn(employee);
    }

    @Test
    @Disabled
    @DisplayName("Get data based on valid employee Name")
    public void whenValidEmployeeName_thenEmployeeShouldFound(){
        String employeeName ="Matsatsi";
        Employee found = employeeService.fetchEmployeeByName(employeeName);

        assertEquals(employeeName,found.getName());
    }
}