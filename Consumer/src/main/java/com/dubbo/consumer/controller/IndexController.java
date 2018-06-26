package com.dubbo.consumer.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dubbo.annotations.ApiOperation;
import com.dubbo.annotations.Privilege;
import com.dubbo.common.entity.VideoVideoInfo;
import com.dubbo.provider.service.VideoService;

@Controller
@Privilege(privilegeName="test")//权限注解
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	VideoService videoService;

	//日志注解
	@ApiOperation(value = "dubbo项目测试自定义注解" ,notes="测试自定义注解",tags="",response=ModelAndView.class
			,httpMethod="POST",nickname="zhangsan",protocols="http")
	@RequestMapping("video/info")
	public ModelAndView queryVideoInfo() {
		logger.info("*************controller : video/info************************");
		ModelAndView mv = new ModelAndView("videoInfo");
		try {
			List<VideoVideoInfo> list = videoService.query();
			mv.addObject("count", list.size());
			logger.info("*************controller : video/info  返回数据 count:"+ list.size() + "************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * AOP测试
	 * @return
	 */
	@RequestMapping("queryList")
	@ResponseBody
	public VideoVideoInfo queryList(){
		VideoVideoInfo videoVideoInfo=new VideoVideoInfo();
		videoVideoInfo.setVideoBigImgURL(UUID.randomUUID().toString());
		return videoVideoInfo;
		
	}
}
