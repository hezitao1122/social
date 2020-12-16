package com.zeryts.c2c.social.govern.reward.service;

import com.zeryts.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description: Reward暴露的service实现类
 * @title: RewardServiceImpl
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29-7:15
 */
@DubboService(
        version = "1.0.0",
        interfaceClass = RewardService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class RewardServiceImpl implements RewardService{
}
