package com.dubbo.provider.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dubbo.common.entity.VideoVideoInfo;
import com.dubbo.provider.dao.VideoMapper;
import com.dubbo.provider.service.VideoService;

public class VideoServiceImpl implements VideoService {
	private static final Logger logger = LoggerFactory.getLogger(VideoService.class);
	
	@Autowired VideoMapper userMapper;

	public List<VideoVideoInfo> query() {
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
