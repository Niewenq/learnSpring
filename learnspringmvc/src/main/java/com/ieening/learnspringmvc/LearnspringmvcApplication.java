package com.ieening.learnspringmvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ieening.learnspringmvc.mapper")
public class LearnspringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspringmvcApplication.class, args);
	}

}
