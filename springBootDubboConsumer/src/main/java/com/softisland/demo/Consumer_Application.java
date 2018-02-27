package com.softisland.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;

//@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:dubbo-demo-consumer.xml") // 很重要
public class Consumer_Application implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_Application.class, args);
		System.out.println("consumer启动完毕");

	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer tomcat) {
		tomcat.setPort(80);
	}

}
