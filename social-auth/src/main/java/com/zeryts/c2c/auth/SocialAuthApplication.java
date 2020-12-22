package com.zeryts.c2c.auth;

import com.zeryts.c2c.common.feign.annotation.EnableSocialFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zeryts
 * @date 2020-02-08 认证授权中心
 */
@SpringCloudApplication
@EnableSocialFeignClients
public class SocialAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAuthApplication.class, args);
	}

}
