package com.softisland.demo.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.softisland.api.demo.DemoApiService;

@Controller
public class MainController {

	@Reference
	private DemoApiService demoService;

	@RequestMapping("/aaa")
	@ResponseBody
	public String home(String name) {
		if (null == demoService) {
			System.out.println("引用对象为:" + demoService);
			return "没有引用成功......";
		}
		String say = demoService.sayHello(name);
		System.out.println(say);
		return say;
	}

}
