package com.zeryts.c2c.common.xss.config;

import cn.hutool.core.collection.CollUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Xss配置类
 *
 * @author L.cm
 */
@Getter
@Setter
@ConfigurationProperties("security.xss")
public class PigxXssProperties implements InitializingBean {

	/**
	 * 开启xss
	 */
	private boolean enabled = true;

	/**
	 * 拦截的路由，默认拦截 /**
	 */
	private List<String> pathPatterns = new ArrayList<>();

	/**
	 * 放行的规则，默认为空
	 */
	private List<String> excludePatterns = new ArrayList<>();

	@Override
	public void afterPropertiesSet() {
		if (CollUtil.isEmpty(pathPatterns)) {
			pathPatterns.add("/**");
		}
	}

}
