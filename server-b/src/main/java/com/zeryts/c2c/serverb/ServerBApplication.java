package com.zeryts.c2c.serverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBApplication.class, args);
    }

}
