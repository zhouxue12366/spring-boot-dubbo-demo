package com.softisland.demo.main;

import com.alibaba.dubbo.config.annotation.Service;
import com.softisland.demo.common.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		String hello = "hello word:" + name;
		System.out.println(hello);
		return hello;
	}

}
