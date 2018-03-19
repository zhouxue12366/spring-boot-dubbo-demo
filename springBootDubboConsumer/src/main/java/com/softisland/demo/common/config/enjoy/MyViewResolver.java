package com.softisland.demo.common.config.enjoy;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.jfinal.template.ext.spring.JFinalViewResolver;

/**
 * ctx配置:有时候我们的项目会添加项目路径，这样页面访问资源和Controller时必须带上。Jfinal框架中可以使用 new
 * ContextPathHandler来很方便地添加，和SpringBoot集成的时候可以如下配置 <br/> <br/>
 * ps1：这里实现ApplicationListener接口，是为了在容器初始化完成后再添加ctx对象，不然getServletContext()
 * 对象可能取到的是空值。 <br/><br/>
 * ps2：SpringBoot使用了spring-boot-devtools热部署的情况下，重启服务时Enjoy模版可能会报错，不能重复添加ctx对象，
 * 这里参考http://www.jfinal.com/share/457，进行配置后正常 <br/> <br/>
 * 
 * @Title MyViewResolver.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年3月19日 下午1:40:36
 * @version V1.0
 */
public class MyViewResolver extends JFinalViewResolver implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * 添加默认路径
	 * 
	 * @param contextRefreshedEvent
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		getEngine().addSharedObject("ctx", getServletContext().getContextPath());
	}
}
