package com.evaluacion.java.parteuno.service;

import com.evaluacion.java.parteuno.exception.ResourceNotFoundException;
import com.evaluacion.java.parteuno.model.Employee;
import com.evaluacion.java.parteuno.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getEmployee_id());
        if (employeeDb.isPresent()){
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setEmployee_id(employee.getEmployee_id());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(employee.getFirstname());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employee.getEmployee_id());
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
        if(employeeDb.isPresent()){
            return employeeDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
        if(employeeDb.isPresent()){
            this.employeeRepository.delete(employeeDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employeeId);
        }
    }
}
