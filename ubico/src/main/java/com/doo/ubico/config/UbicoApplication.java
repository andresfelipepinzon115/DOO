package com.doo.ubico.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages= {"com.doo.ubico.api.controller"})
public class UbicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbicoApplication.class, args);
	}

}



