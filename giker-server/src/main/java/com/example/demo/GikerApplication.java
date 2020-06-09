package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackageClasses= {ProductCategoryRepository.class})
//@EntityScan(basePackageClasses= {ProductCategory.class})
//@EnableJpaRepositories(basePackageClasses= {ProductCategory.class})

@SpringBootApplication

public class GikerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GikerApplication.class, args);
	}

}
