package com.softisland.demo.business.main;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.softisland.api.business.demo.DemoApiService;
import com.softisland.api.common.model.Menu;

@Service
public class DemoServiceImpl implements DemoApiService{

	@Override
	public List<Record> sayHello(String name) {
		List<Record> records = Db.find(" select * from videos limit 100 ");
		String hello = "hello word:" + name;
		System.out.println("提供者:"+hello);
		return records;
	}

	@Override
	public Record getVideoById(String id) {
		Record record = Db.findById("videos", id);
		return record;
	}

	@Override
	public List<Record> getList(int start,int end) {
		List<Record> records = Db.find(" select * from videos limit "+ start +", "+ end );
		return records;
	}

	@Override
	public List<Menu> getHeaderList() {
		return Menu.dao.find("select * from menu ");
	}

}
