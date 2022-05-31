package com.company.service;

import com.company.domain.Employee;
import com.company.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO getEmployeeById(Long id);
    List<StudentDTO> getAllEmployees();
    EmployeeDTO insertEmployee(Employee employee);
    EmployeeDTO getEmployeeByName(String name);
}