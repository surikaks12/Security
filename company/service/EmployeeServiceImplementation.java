package com.company.service;

import com.company.domain.Employee;
import com.company.domain.EmployeeDTO;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return new EmployeeDTO(employee.get());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(stu -> new EmployeeDTO(stu)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO insertEmployee(Employee student) {
        return new EmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO getEmployeeByName(String name) {
        Employee employee = employeeRepository.findByName(name);
        return new EmployeeDTO(employee);
    }
}
