package com.rabii.gestiondestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class GestionDeStockApplication {

	/*@Autowired
	private ApplicationContext appContext;*/

	public static void main(String[] args) {
		SpringApplication.run(GestionDeStockApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean : beans) {
				System.out.println("rabiibean " + bean);
			}
		};
	}*/

}
