package org.sopt.www.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class FirstSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootApplication.class, args);
	}

}
