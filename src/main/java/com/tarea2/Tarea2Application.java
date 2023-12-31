package com.tarea2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Tarea2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tarea2Application.class, args);
	}
}
