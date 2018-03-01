package com.softisland.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 通过main方法启动服务者
 * @Title provider_Application.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年2月27日 下午5:37:36
 * @version V1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath:dubbo-demo-provider.xml")//很重要
public class Provider_Application {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Provider_Application.class, args);
		System.out.println("provider*****************started");
    }
}
