package com.zeryts.c2c.social.govern.reviewer.service;

import com.zeryts.c2c.social.govern.reviewer.api.ReviewerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zeryts
 * @description: Reviewer服务暴露的service实现接口
 * ```````````````````````````
 * @title: ReviewerService
 * @projectName c2c-social-govern
 * @date 2020/11/8 20:56
 */
@Service(
        version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class ReviewerServiceImpl implements ReviewerService {
}
