package com.sa.employeeproject.service;

import com.sa.employeeproject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
