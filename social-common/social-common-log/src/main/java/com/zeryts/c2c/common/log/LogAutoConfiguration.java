package com.zeryts.c2c.common.log;

import com.zeryts.c2c.admin.api.feign.RemoteLogService;
import com.zeryts.c2c.common.core.util.KeyStrResolver;
import com.zeryts.c2c.common.log.aspect.SysLogAspect;
import com.zeryts.c2c.common.log.event.SysLogListener;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zeryts
 * @date 2018/6/28
 * <p>
 * 日志自动配置
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

	private final RemoteLogService remoteLogService;

	@Bean
	public SysLogListener sysLogListener() {
		return new SysLogListener(remoteLogService);
	}

	@Bean
	public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher, KeyStrResolver resolver) {
		return new SysLogAspect(publisher, resolver);
	}

}
