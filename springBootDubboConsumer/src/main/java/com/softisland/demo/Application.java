package com.softisland.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 注意这两个配置类必须放在目录的最前面,否则其他包下面的配置命令@Configuration等无法自动获取加载
 * @Title SpringBootStartApplication.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年2月26日 下午2:10:21
 * @version V1.0
 */
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return  builder.sources(Consumer_Application.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer tomcat) {
		// TODO Auto-generated method stub
	} 
}
