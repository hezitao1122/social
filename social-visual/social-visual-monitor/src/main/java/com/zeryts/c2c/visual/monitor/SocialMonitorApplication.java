
package com.zeryts.c2c.visual.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zeryts
 * @date 2019年11月4日 监控中心
 */
@EnableAdminServer
@SpringCloudApplication
public class SocialMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMonitorApplication.class, args);
	}

}
