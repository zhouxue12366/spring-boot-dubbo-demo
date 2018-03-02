package com.softisland.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 
 * @Title SpringBootStartApplication.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年2月26日 下午2:10:21
 * @version V1.0
 * //@ComponentScan(basePackages="com.softisland.demo")   //默认扫描是当前包下的路径  
//@Configuration  
//@EnableAutoConfiguration
//@ComponentScan(basePackages="com.softisland.*")//默认扫描是当前包下的路径 
//@SpringBootApplication //如果继承了SpringBootServletInitializer类后,就不能在使用这个命令，否则会扫描不到api的接口类,切记
//@ImportResource("classpath:dubbo-demo-provider.xml")//加载dubbo.xml文件
 ***/
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(Provider_Application.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer tomcat) {
		// TODO Auto-generated method stub
		
	}

}
