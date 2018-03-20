package com.softisland.api.business.demo;

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
	
	/**
	 * 根据ID获取
	 * @Title getVideoById
	 * @Description TODO  
	 * @param id
	 * @return 
	 * @since 2018年3月19日 下午4:36:07
	 */
	public Record getVideoById(String id);
	
	public List<Record> getList(int start,int end);
	
}
