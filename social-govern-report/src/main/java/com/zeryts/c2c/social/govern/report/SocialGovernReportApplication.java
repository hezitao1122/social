package com.zeryts.c2c.social.govern.report;

import com.zeryts.c2c.social.govern.report.config.db.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class SocialGovernReportApplication {

    public static void main(String[] args) {

        SpringApplication.run(SocialGovernReportApplication.class, args);
    }

}
