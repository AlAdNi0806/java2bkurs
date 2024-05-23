package com.example.prak13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Prak13Application implements CommandLineRunner {

	@Value("${program.user.name}")
	private String myName;

	@Value("${program.user.last_name}")
	private String studentLastName;

	@Value("${program.user.group}")
	private String studentGroup;

	public static void main(String[] args) {
		SpringApplication.run(Prak13Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Имя студента: " + myName);
		System.out.println("Фамилия студента: " + studentLastName);
		System.out.println("Группа Студента: " + studentGroup);
	}
}
