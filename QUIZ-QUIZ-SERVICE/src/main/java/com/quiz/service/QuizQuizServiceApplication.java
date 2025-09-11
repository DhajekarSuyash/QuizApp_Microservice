package com.quiz.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizQuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizQuizServiceApplication.class, args);
	}

}
