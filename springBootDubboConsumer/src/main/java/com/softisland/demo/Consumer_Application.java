package com.softisland.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 注意这两个配置类必须放在目录的最前面,否则其他包下面的配置命令@Configuration等无法自动获取加载
 * @Title Consumer_Application.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年3月20日 上午10:51:23
 * @version V1.0
 */
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
