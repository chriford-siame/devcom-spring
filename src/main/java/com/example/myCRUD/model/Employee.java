package com.example.myCRUD.model;

import lombok.*;
import jakarta.persistence.*;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private float salary;

    public Employee() {}

    public Employee(String name, float salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public void setName(String name) {
        this.name = name;
    }
}
