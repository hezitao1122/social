package com.zeryts.c2c.social.govern.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
