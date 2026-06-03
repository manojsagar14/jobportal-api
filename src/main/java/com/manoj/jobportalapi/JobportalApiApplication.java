package com.manoj.jobportalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JobportalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobportalApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Job Portal API!";
	}

}