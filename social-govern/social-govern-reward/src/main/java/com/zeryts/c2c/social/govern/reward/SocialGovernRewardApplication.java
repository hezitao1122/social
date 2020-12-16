package com.zeryts.c2c.social.govern.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @description: 启动类
 * @title: RewardServiceImpl
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29-7:15
 */
@SpringBootApplication
@RestController
public class SocialGovernRewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialGovernRewardApplication.class, args);
    }
    @GetMapping("/say")
    public String say() {
        return "say";
    }
}
