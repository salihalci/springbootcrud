package com.sa.employeeproject.dao;

import com.sa.employeeproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
