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
public class MainController {

	@Reference
	private DemoApiService demoService;

	@RequestMapping("/home")
	@ResponseBody
	public List<Record> home(String name) {
		// String name = getPara("name");
		if (null == demoService) {
			System.out.println("引用对象为:" + demoService);
			return null;
		}
		List<Record> records = demoService.sayHello(name);

		System.out.println(name + ">查询数据为:" + records);
		return records;
	}

	@RequestMapping({ "/index", "", "/" })
	public String index(HttpServletRequest request, Model mav) {
		String name = request.getParameter("name");

		List<Record> records = demoService.sayHello(name);
		List<Record> pages = demoService.getList(101, 4);
		Record model = demoService.getVideoById("10010");
		mav.addAttribute("records", records);
		mav.addAttribute("pages", pages);
		mav.addAttribute("name", name);
		mav.addAttribute("model", model);
		return "index";
	}

}
