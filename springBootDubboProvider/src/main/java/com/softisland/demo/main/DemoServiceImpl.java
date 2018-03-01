package com.softisland.demo.main;

import com.alibaba.dubbo.config.annotation.Service;
import com.softisland.api.demo.DemoApiService;

@Service
public class DemoServiceImpl implements DemoApiService{

	@Override
	public String sayHello(String name) {
		String hello = "hello word:" + name;
		System.out.println("提供者:"+hello);
		return hello;
	}

}
