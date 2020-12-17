package com.zeryts.c2c.common.oss;

import com.zeryts.c2c.common.oss.http.OssEndpoint;
import com.zeryts.c2c.common.oss.service.OssTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * aws 自动配置类
 *
 * @author zeryts
 * @author 858695266
 */
@AllArgsConstructor
@EnableConfigurationProperties({ com.zeryts.c2c.common.oss.OssProperties.class })
public class OssAutoConfiguration {

	private final com.zeryts.c2c.common.oss.OssProperties properties;

	@Bean
	@ConditionalOnMissingBean(OssTemplate.class)
	@ConditionalOnProperty(name = "oss.enable", havingValue = "true", matchIfMissing = true)
	public OssTemplate ossTemplate() {
		return new OssTemplate(properties);
	}

	@Bean
	@ConditionalOnProperty(name = "oss.info", havingValue = "true")
	public OssEndpoint ossEndpoint(OssTemplate template) {
		return new OssEndpoint(template);
	}

}
