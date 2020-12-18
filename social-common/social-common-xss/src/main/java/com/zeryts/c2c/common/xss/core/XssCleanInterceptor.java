package com.zeryts.c2c.common.xss.core;

import cn.hutool.core.util.StrUtil;
import com.zeryts.c2c.common.xss.config.PigxXssProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * xss 处理拦截器
 *
 * @author L.cm
 */
@RequiredArgsConstructor
public class XssCleanInterceptor extends HandlerInterceptorAdapter {

	private final PigxXssProperties xssProperties;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 没有开启
		if (!xssProperties.isEnabled()) {
			return true;
		}

		// 2. 非控制器请求直接跳出
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		// 3. 只过滤 POST PUT
		if (!StrUtil.equalsAnyIgnoreCase(request.getMethod(), HttpMethod.POST.name(), HttpMethod.PUT.name())) {
			return true;
		}

		// 4. 处理 XssIgnore 注解
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		XssCleanIgnore xssCleanIgnore = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), XssCleanIgnore.class);
		if (xssCleanIgnore == null) {
			XssHolder.setEnable();
		}
		return true;
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
			Object handler) {
		XssHolder.remove();
	}

}
