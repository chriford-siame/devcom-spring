package com.example.myCRUD.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCRUD.model.Employee;
import com.example.myCRUD.repo.EmployeeRepo;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = new ArrayList<>();
            employeeRepo.findAll().forEach(employees::add);
            
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/get/{id}")
    public ResponseEntity<Employee> getBookById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);

        if(employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employees/add")
    public ResponseEntity<Employee> addBook(@RequestBody Employee employee) {
        Employee employeeObj = employeeRepo.save(employee);
        return new ResponseEntity<>(employeeObj, HttpStatus.OK);
    }
    
    @PostMapping("/employees/edit/{id}")
    public ResponseEntity<Employee> updateBookById(@PathVariable Long id, @RequestBody Employee newEmployeeData) {
        Optional<Employee> currentEmployeeData = employeeRepo.findById(id);
        if (currentEmployeeData.isPresent()) {
            Employee updatedEmployeeData = currentEmployeeData.get();
            updatedEmployeeData.setName(newEmployeeData.getName());
            updatedEmployeeData.setSalary(newEmployeeData.getSalary());
            
            Employee employee = employeeRepo.save(newEmployeeData);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id) {
        employeeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
