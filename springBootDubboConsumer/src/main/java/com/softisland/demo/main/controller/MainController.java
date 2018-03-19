package com.softisland.demo.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jfinal.plugin.activerecord.Record;
import com.softisland.api.demo.DemoApiService;

@Controller
public class MainController{

	@Reference
	private DemoApiService demoService;

	@RequestMapping("/home")
	@ResponseBody
	public List<Record> home(String name ) {
//		String name = getPara("name");
		if (null == demoService) {
			System.out.println("引用对象为:" + demoService);
			return null;
		}
		List<Record> records = demoService.sayHello(name);
		System.out.println(name+">查询数据为:"+records);
		return records;
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model) {
		String name = request.getParameter("name");
		
		if (null == demoService) {
			System.out.println("引用对象为:" + demoService);
		}
		List<Record> records = demoService.sayHello(name);
		System.out.println(name+">查询数据统计为:"+records.size()+"条数据");
		model.addAttribute("records", records);
		model.addAttribute("name", name);
		return "index";
	}

}
