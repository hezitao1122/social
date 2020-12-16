

package com.zeryts.c2c.common.data.tenant;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;

/**
 * @author zeryts
 * @date 2020/4/29
 * <p>
 * 租户信息拦截
 */
@Configuration
public class PigxTenantConfiguration {

	@Bean
	public RequestInterceptor pigxFeignTenantInterceptor() {
		return new PigxFeignTenantInterceptor();
	}

	@Bean
	public ClientHttpRequestInterceptor pigxTenantRequestInterceptor() {
		return new TenantRequestInterceptor();
	}

}
