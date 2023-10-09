package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})  //DataSourceAutoConfiguration을 Enable
public class HibernateExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateExamApplication.class, args);
	}

}
