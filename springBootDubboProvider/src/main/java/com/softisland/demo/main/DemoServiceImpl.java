package com.softisland.demo.main;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.softisland.api.demo.DemoApiService;

@Service
public class DemoServiceImpl implements DemoApiService{

	@Override
	public List<Record> sayHello(String name) {
		List<Record> records = Db.find(" select * from sys_users limit 100 ");
		String hello = "hello word:" + name;
		System.out.println("提供者:"+hello);
		return records;
	}

}
