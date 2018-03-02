package com.softisland.api.demo;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

/**
 * 测试用例接口定义管理
 * @Title DemoService.java
 * @Description TODO
 * @Company: 软岛
 * @author zg
 * @date 2018年2月26日 上午10:10:12
 * @version V1.0
 */
public interface DemoApiService {
	
	public List<Record> sayHello(String name);
}
