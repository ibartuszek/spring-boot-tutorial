package com.example.configclientapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Refresh: POST + http://localhost:9000/actuator/refresh
// Actuator can be reached via: http://localhost:9000/actuator
// client of ConfigurationServerApplication

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RestController
	@RefreshScope
	class ExampleController {

		@Value("${welcome.message}")
		String welcomeText;

		@RequestMapping(value = "/")
		public String welcomeText() {
			return welcomeText;
		}
	}

}
