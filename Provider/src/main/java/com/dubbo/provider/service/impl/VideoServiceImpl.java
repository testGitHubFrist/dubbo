package com.dubbo.provider.service.impl;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dubbo.common.entity.VideoVideoInfo;
import com.dubbo.provider.dao.VideoMapper;
import com.dubbo.provider.service.VideoService;

public class VideoServiceImpl implements VideoService {
	private static final Logger logger = Logger.getLogger(VideoService.class);
	
	@Autowired VideoMapper userMapper;

	public List<VideoVideoInfo> query() {
		BasicConfigurator.configure();
		List<VideoVideoInfo> list = null;
		try {
			logger.info("*******provider 视频信息实现类***********");
			list = userMapper.queryVideoList();
			logger.info("***********查询数据个数count: "+list.size()+"***********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ;
	}
	
}
