package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee (Employee employee);
    Employee updateEmployee (Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long employeeId);
    void deleteEmployee(long id);
}
