package com.example.examen_task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.examen_task.mapper")
public class ExamenTaskApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExamenTaskApplication.class, args);
	}

}
