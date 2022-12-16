package com.Namfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Namfood.Repository.RestaurantRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = RestaurantRepository.class)
public class NamFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamFoodApplication.class, args);
	}

}
