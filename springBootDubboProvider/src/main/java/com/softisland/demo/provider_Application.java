package com.softisland.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:dubbo-demo-provider.xml")//很重要
public class provider_Application {

	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(provider_Application.class, args);
		System.out.println("provider*****************started");
    }
}
