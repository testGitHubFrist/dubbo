package com.dubbo.consumer.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.common.model.VideoVideoInfo;

/**
 * aop 测试
 *
 * @author GaoQun
 */
@Controller
public class AopTestController {

    private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);

    /**
     * AOP测试
     *
     * @return
     */
    @RequestMapping("aopTest")
    @ResponseBody
    public VideoVideoInfo aopTest() {
        VideoVideoInfo videoVideoInfo = new VideoVideoInfo();
        videoVideoInfo.setVideoBigImgURL(UUID.randomUUID().toString());
        return videoVideoInfo;
    }
}
