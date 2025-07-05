package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer emp_id);
    Employee updateEmployee(Integer emp_id, Employee employee);
    void deleteEmployee(Integer emp_id);


}
