package com.zeryts.c2c.common.xss;

import com.zeryts.c2c.common.xss.config.PigxXssProperties;
import com.zeryts.c2c.common.xss.core.FormXssClean;
import com.zeryts.c2c.common.xss.core.JacksonXssClean;
import com.zeryts.c2c.common.xss.core.XssCleanInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * jackson xss 配置
 *
 * @author L.cm
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(PigxXssProperties.class)
@ConditionalOnProperty(value = "security.xss.enabled", havingValue = "true", matchIfMissing = true)
public class PigxXssAutoConfiguration implements WebMvcConfigurer {

	private final PigxXssProperties xssProperties;

	@Bean
	public FormXssClean formXssClean() {
		return new FormXssClean();
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer xssJacksonCustomizer() {
		return builder -> builder.deserializerByType(String.class, new JacksonXssClean());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		XssCleanInterceptor interceptor = new XssCleanInterceptor(xssProperties);
		registry.addInterceptor(interceptor).addPathPatterns(xssProperties.getPathPatterns())
				.excludePathPatterns(xssProperties.getExcludePatterns()).order(Ordered.LOWEST_PRECEDENCE);
	}

}
