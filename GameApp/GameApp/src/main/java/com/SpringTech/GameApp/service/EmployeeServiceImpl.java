package com.SpringTech.GameApp.service;

import com.SpringTech.GameApp.entity.Employee;
import com.SpringTech.GameApp.error.EmployeeNotFoundException;
import com.SpringTech.GameApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee empDB =employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getName())&&
        !"".equalsIgnoreCase(employee.getName())) {
            empDB.setName(employee.getName());
        }

        return employeeRepository.save(empDB);
    }

    @Override
    public Employee fetchEmployeeByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Employee> fetchByTemperatureLessThan(int temperature) {
        return employeeRepository.findAllByTemperatureLessThan(temperature);
    }


}
