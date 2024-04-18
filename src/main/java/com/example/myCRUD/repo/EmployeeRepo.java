package com.example.myCRUD.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
