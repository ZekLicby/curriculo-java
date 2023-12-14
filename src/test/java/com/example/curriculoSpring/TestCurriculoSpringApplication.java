package com.example.curriculoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCurriculoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.from(CurriculoSpringApplication::main).with(TestCurriculoSpringApplication.class).run(args);
	}

}
