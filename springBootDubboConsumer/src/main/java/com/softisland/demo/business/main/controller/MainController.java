package com.softisland.demo.business.main.controller;

import java.util.List;
import java.util.Random;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.softisland.api.business.demo.DemoApiService;
import com.softisland.api.business.mostViewed.MostViewedService;
import com.softisland.api.common.model.Menu;
import com.softisland.api.common.model.MostViewed;

@Controller
public class MainController {

	@Reference
	private DemoApiService demoService;

	@Reference
	private MostViewedService mostViewedService;

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private Queue pornjamQueue;

	@Autowired
	private Topic topic;

	@RequestMapping("/home")
	@ResponseBody
	public List<Record> home(HttpServletRequest request, Model mav) {
		String name = request.getParameter("name");
		String oldId = request.getParameter("oldId");
		String poster = request.getParameter("poster");
		String play_url = request.getParameter("play_url");
		List<Record> records = demoService.sayHello(name);
		MostViewed dao = new MostViewed();
		dao.setOldId(oldId);
		dao = mostViewedService.findFirst(dao);
		dao.setPlayImgSrc(poster);
		dao.setPlayUrl(play_url);
		boolean result = mostViewedService.update(dao);

		System.out.println(oldId + ">查询数据为:" + result);
		return records;
	}

	@RequestMapping({ "/index", "", "/" })
	public String index(HttpServletRequest request, Model mav) {
		String path = request.getParameter("path");
		// 发送mq消息
		// jmsMessagingTemplate.convertAndSend(this.queue, "hi.activeMQ,index="
		// + oldId+",poster="+poster);
		// jmsMessagingTemplate.convertAndSend(this.topic, "~~~~,activeMQ( topic
		// )，index=" + oldId+",poster="+poster);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("path", path);
		jmsMessagingTemplate.convertAndSend(this.pornjamQueue, jsonObject.toJSONString());
		// jmsMessagingTemplate.convertAndSend(this.pornjamQueue,
		// "这个是要给怕数据的程序的1111:" + oldId);
		// jmsMessagingTemplate.convertAndSend(this.pornjamQueue,
		// "这个是要给怕数据的程序的2222:" + oldId);
		// jmsMessagingTemplate.convertAndSend(this.pornjamQueue,
		// "这个是要给怕数据的程序的3333:" + oldId);

		// List<Record> records = demoService.sayHello(oldId);
		List<Record> pages = demoService.getList(101, 4);
		int max = 11325;
		int min = 60;
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		Record model = demoService.getVideoById(s + "");
		// mav.addAttribute("records", records);
		mav.addAttribute("pages", pages);
		// mav.addAttribute("name", oldId);
		mav.addAttribute("model", model);

		List<Menu> menus = demoService.getHeaderList();
		mav.addAttribute("menus", menus);
		
		List<MostViewed> mostViewedList = demoService.getMostViewedList();
		mav.addAttribute("mostViewedList",mostViewedList);
		
		return "index";
	}

	@RequestMapping("headerList")
	@ResponseBody
	public List<Menu> getHeaderList(HttpServletRequest request, Model mav) {
		List<Menu> menus = demoService.getHeaderList();
		// mav.addAttribute("menus", menus);
		return menus;
	}

}
