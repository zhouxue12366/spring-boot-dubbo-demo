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
@ImportResource("classpath:dubbo-demo-provider.xml")//扫描加载dubbo的配置文件
public class Provider_Application {
	
	/**
	 *  如果使用main方法启动项目的话,需要将pom.xml中的移除嵌入式tomcat插件注释;
	 * 相反,如果需要用自己的tomcat启动,只需要在pom.xml中移除嵌入式tomcat插件打开;
	 * @Title main
	 * @Description TODO  
	 * @param args
	 * @throws IOException 
	 * @since 2018年3月1日 下午4:43:01
	 */
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Provider_Application.class, args);
		System.out.println("provider*****************started");
    }
}
