package com.softisland.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:dubbo-demo-consumer.xml") // 扫描加载dubbo的配置文件
public class Consumer_Application {

	/**
	 * 如果使用main方法启动项目的话,需要将pom.xml中的移除嵌入式tomcat插件注释;
	 * 相反,如果需要用自己的tomcat启动,只需要在pom.xml中移除嵌入式tomcat插件打开;
	 * @Title main
	 * @Description TODO  
	 * @param args 
	 * @since 2018年3月1日 下午4:39:06
	 */
	public static void main(String[] args) {
		SpringApplication.run(Consumer_Application.class, args);
		System.out.println("consumer启动完毕");

	}

}
