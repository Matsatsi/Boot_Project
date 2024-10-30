package com.SpringTech.GameApp.service;

import com.SpringTech.GameApp.entity.Employee;
import com.SpringTech.GameApp.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployeeList();

    public Employee fetchEmployeeById(Long id) throws EmployeeNotFoundException;

    public void deleteEmployeeById(Long id);

    public Employee updateEmployee(long id, Employee employee);

    public Employee fetchEmployeeByName(String name);

    List<Employee> fetchByTemperatureLessThan(int temperature);
}
