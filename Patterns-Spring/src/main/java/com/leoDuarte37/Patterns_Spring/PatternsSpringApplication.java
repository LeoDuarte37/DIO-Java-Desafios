package com.leoDuarte37.Patterns_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PatternsSpringApplication {

	/*	Explorando Design Patterns com Spring

			- Singleton: @Bean e @Autowired;
			- Strategy: @Service e @Repository;
			- Facade: vamos abstrair a complexidade
			  das integrações: Spring Data JPA
			  e ViaCEP (Feign).
	 */

	public static void main(String[] args) {
		SpringApplication.run(PatternsSpringApplication.class, args);
	}
}
