package model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
// @NoArgsContrustor
// @AllArgsContrustor
// @Setter
// @Getter
// @ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private float salary;

    public Employee() {

    }
    public Employee(String name, float salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
