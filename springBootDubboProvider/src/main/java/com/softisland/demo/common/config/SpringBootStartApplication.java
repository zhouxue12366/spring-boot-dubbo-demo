//package com.softisland.demo.common.config;
//
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//
///**
// * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
// * 
// * @Title SpringBootStartApplication.java
// * @Description TODO
// * @Company: 软岛
// * @author zg
// * @date 2018年2月26日 下午2:10:21
// * @version V1.0
// */
//public class SpringBootStartApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		// 注意这里要指向原先用main方法执行的Application启动类
//		return  builder.sources(Application.class);
//	}
//}
