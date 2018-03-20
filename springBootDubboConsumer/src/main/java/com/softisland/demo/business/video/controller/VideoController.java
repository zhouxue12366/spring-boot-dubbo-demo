package com.softisland.demo.business.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jfinal.plugin.activerecord.Record;
import com.softisland.api.business.demo.DemoApiService;

@Controller
@RequestMapping("/video/")
public class VideoController {
	
	@Reference
	private DemoApiService demoService;
	
	@RequestMapping("play")
	public String play(HttpServletRequest request,HttpServletResponse response, Model mav){
		String id = request.getParameter("id");
		System.out.println(id);
		Record record = demoService.getVideoById(id);
		List<Record> records = demoService.getList(501, 20);
		mav.addAttribute("records", records);
		mav.addAttribute("model", record);
		return "business/video/detail/play";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,HttpServletResponse response, Model mav){
		List<Record> lists = demoService.getList(201,100);
		List<Record> records = demoService.getList(301, 20);
		mav.addAttribute("records", records);
		mav.addAttribute("lists", lists);
		return "business/video/list";
	}

}
