package com.dubbo.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dubbo.common.annotations.ApiOperation;
import com.dubbo.common.annotations.Permission;
import com.dubbo.common.constants.ResponseEntity;
import com.dubbo.consumer.service.IndexService;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private IndexService indexService;



	// 日志注解
	@Permission(value="test" ,operation="测试权限")
	@ApiOperation(value = "dubbo项目测试自定义注解", notes = "测试自定义注解", tags = "", response = ModelAndView.class, httpMethod = "POST", nickname = "zhangsan", protocols = "http")
	@RequestMapping("video/info")
	@ResponseBody
	public ResponseEntity queryVideoInfo() {
		logger.info("*************video/info begin************************");
		ResponseEntity resp=new ResponseEntity();
		//dsdsd
		try {
			resp=indexService.query();
			logger.info("*************video/info end resp:{}************************",resp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}
