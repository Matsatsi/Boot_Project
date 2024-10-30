package com.SpringTech.GameApp.repository;

import com.SpringTech.GameApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);

    public Employee findByNameIgnoreCase(String name);

    public List<Employee> findAllByTemperatureLessThan(int temperature);
}
