package com.softisland.demo.common.config.enjoy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot 集成 Enjoy的配置文件<br/>
 * 参考文章地址:	http://www.jfinal.com/doc/6-10
 * @Title EnjoyConfig.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年3月19日 下午3:36:52
 * @version V1.0
 */
@Configuration
public class EnjoyConfig {

	@Bean(name = "jfinalViewResolver")
	public MyViewResolver getJFinalViewResolver() {
		MyViewResolver jfr = new MyViewResolver();
		// setDevMode 配置放在最前面
		jfr.setDevMode(true);

		// 使用 ClassPathSourceFactory 从 class path 与 jar 包中加载模板文件(这里会导致目录找不到html文件)
//		jfr.setSourceFactory(new ClassPathSourceFactory());
		jfr.setPrefix("/views/");
		jfr.setSuffix(".html");
		jfr.setContentType("text/html;charset=UTF-8");
		jfr.setOrder(0);
		jfr.addSharedFunction("/views/common/_layout.html");
		jfr.addSharedFunction("/views/common/_paginate.html");
		jfr.addSharedFunction("/views/common/header.html");
		jfr.addSharedFunction("/views/common/footer.html");
		return jfr;
	}
}
