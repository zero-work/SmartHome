package com.example.smartserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SmartserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartserverApplication.class, args);
	}

}
