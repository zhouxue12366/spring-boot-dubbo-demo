package com.softisland.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:dubbo-demo-consumer.xml") // 很重要
@EnableAutoConfiguration
@SpringBootApplication
public class Consumer_Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_Application.class, args);
		System.out.println("consumer启动完毕");

	}

}
