package com.weusouza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.weusouza.resources")
@ComponentScan("com.weusouza.service")
@ComponentScan("com.weusouza.repositories")
@ComponentScan("com.weusouza.domain")
@ComponentScan("com.weusouza.config")
public class AvaliacaoAttornatusApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoAttornatusApplication.class, args);
	}
}
