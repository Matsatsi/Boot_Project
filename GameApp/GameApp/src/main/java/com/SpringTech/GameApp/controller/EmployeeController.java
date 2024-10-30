package com.SpringTech.GameApp.controller;

import com.SpringTech.GameApp.entity.Employee;
import com.SpringTech.GameApp.error.EmployeeNotFoundException;
import com.SpringTech.GameApp.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class  EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployees(){

        LOGGER.info("Inside fetchEmployeeList of EmployeeController");
        return employeeService.fetchEmployeeList();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long id)
            throws EmployeeNotFoundException {
        return employeeService.fetchEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return "Department deleted successfully";
       }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable long id,
                                   @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name") String name){
        return  employeeService.fetchEmployeeByName(name);
    }

    @GetMapping("/employees/temperature/{temperature}")
    public List<Employee> fetchByTemperatureLessThan(@PathVariable("temperature") int temperature){
        return employeeService.fetchByTemperatureLessThan(temperature);
    }
}
