package com.example.myCRUD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.example.myCRUD.controller.*;
import com.example.myCRUD.model.*;

@SpringBootApplication
public class MyCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCrudApplication.class, args);
	}
}