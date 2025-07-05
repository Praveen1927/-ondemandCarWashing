package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer emp_id) {
        Optional<Employee> optional = employeeRepository.findById(emp_id);
        return optional.orElse(null);
    }

    @Override
    public Employee updateEmployee(Integer emp_id, Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(emp_id);
        if (optional.isPresent()) {
            Employee existingEmployee = optional.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(Integer emp_id) {
        employeeRepository.deleteById(emp_id);
    }
}