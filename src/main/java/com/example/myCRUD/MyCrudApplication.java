package com.example.myCRUD;
import java.util.List;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myCRUD.controller.*;
import com.example.myCRUD.model.*;
import com.example.myCRUD.repo.UserRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MyCrudApplication {

	// @Autowired
	// public UserRepo userRepo;

	// @PostConstruct
	// public void initUsers() {

	// }
	public static void main(String[] args) {
		SpringApplication.run(MyCrudApplication.class, args);
	}
}