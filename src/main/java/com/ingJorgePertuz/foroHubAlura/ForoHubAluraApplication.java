package com.ingJorgePertuz.foroHubAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ForoHubAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubAluraApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("API REST desplegada exitosamente!");
			System.out.println("URL principal: http://localhost:8080/");
		};
	}

	@Controller
	public class DefaultController {
		@RequestMapping("/")
		public String home() {
			return "redirect:/users";
		}
	}
}
