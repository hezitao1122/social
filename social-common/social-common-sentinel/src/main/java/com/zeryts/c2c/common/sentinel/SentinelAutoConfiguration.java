

package com.zeryts.c2c.common.sentinel;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.zeryts.c2c.common.sentinel.feign.SocialSentinelFeign;
import com.zeryts.c2c.common.sentinel.handle.PigxUrlBlockHandler;
import com.zeryts.c2c.common.sentinel.parser.PigxHeaderRequestOriginParser;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zeryts
 * @date 2020-02-12
 * <p>
 * sentinel 配置
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class SentinelAutoConfiguration {

	@Bean
	@Scope("prototype")
	@ConditionalOnMissingBean
	@ConditionalOnProperty(name = "feign.sentinel.enabled")
	public Feign.Builder feignSentinelBuilder() {
		return SocialSentinelFeign.builder();
	}

	@Bean
	@ConditionalOnMissingBean
	public BlockExceptionHandler blockExceptionHandler() {
		return new PigxUrlBlockHandler();
	}

	@Bean
	@ConditionalOnMissingBean
	public RequestOriginParser requestOriginParser() {
		return new PigxHeaderRequestOriginParser();
	}

}
