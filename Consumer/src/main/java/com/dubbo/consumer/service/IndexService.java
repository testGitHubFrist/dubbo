package com.dubbo.consumer.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubbo.common.constants.ResponseEntity;
import com.dubbo.common.model.VideoVideoInfo;
import com.dubbo.common.service.VideoService;

@Service
public class IndexService {
    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    private VideoService videoService;

    public ResponseEntity query() {
        ResponseEntity resp = new ResponseEntity();
        List<VideoVideoInfo> list = videoService.query();
        resp.setData(list);
        resp.setResponseCode(0);
        resp.setResponseMessage("成功");
        resp.setResponseDate(new Date());
        return resp;
    }

}
