package com.SpringTech.GameApp.repository;

import com.SpringTech.GameApp.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository  employeeRepository;
    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .name("Mellow")
                .temperature(26)
                .build();

        testEntityManager.persist(employee);
    }

    @Test
    public void WhenFindById_theTurnDepartment(){
        Employee employee = employeeRepository.findById(1L).get();
        assertEquals(employee.getName(), "Mellow");
    }
}