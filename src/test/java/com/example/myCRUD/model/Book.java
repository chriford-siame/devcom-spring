package com.example.myCRUD.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Books")
@NoArgsContrustor
@AllArgsContrustor
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GenerateValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
}
