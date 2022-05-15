package com.javalec.worldCup;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource(value= {"classpath:servlet-context.xml"
}) 
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		}

}
