package com.example32.DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackageClasses = PersonDB.class)
@SpringBootApplication
public class Demo32Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo32Application.class, args);
	}
}
