package com.example.commandlinerunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// ApplicationRunner example with scheduling.

@SpringBootApplication
@EnableScheduling
public class CommandLineRunnerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		System.out.println("Hello World from Application Runner");
	}
}
