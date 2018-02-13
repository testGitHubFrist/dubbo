package com.dubbo.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

import com.dubbo.common.entity.VideoVideoInfo;
import com.dubbo.provider.service.VideoService;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired VideoService videoService;
	
	@RequestMapping("video/info")
	public ModelAndView queryVideoInfo(){
		logger.info("*************controller : video/info************************");
		ModelAndView mv=new ModelAndView("videoInfo");
		try {
			List<VideoVideoInfo> list =videoService.query();
			mv.addObject("count", list.size());
			logger.info("*************controller : video/info  返回数据 count:"+list.size()+"************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
