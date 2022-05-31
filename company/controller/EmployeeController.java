package com.company.controller;

import com.company.domain.Employee;
import com.company.domain.EmployeeDTO;
import com.company.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(this.employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/employees", params = "employee")
    public ResponseEntity<EmployeeDTO> insertStudent(@RequestParam Employee employee) {
        return new ResponseEntity<>(this.employeeService.insertStudent(employee), HttpStatus.OK);
    }

    @GetMapping(value = "/employee", params = "name")
    public ResponseEntity<EmployeeDTO> getEmployeeByName(@RequestParam String name) {
        return new ResponseEntity<>(this.employeeService.getEmployeeByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/employee", params = "id")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@RequestParam long id) {
        return new ResponseEntity<>(this.EmployeeService.getEmployeeById(id), HttpStatus.OK);
    }
}