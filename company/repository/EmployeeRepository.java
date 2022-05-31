package com.company.repository;

import com.company.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}