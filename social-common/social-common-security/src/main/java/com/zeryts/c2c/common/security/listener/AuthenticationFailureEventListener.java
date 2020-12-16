

package com.zeryts.c2c.common.security.listener;

import com.zeryts.c2c.common.security.handler.AuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zeryts
 * @date 2020/03/25 认证失败事件监听器
 */
public class AuthenticationFailureEventListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

	@Autowired(required = false)
	private AuthenticationFailureHandler failureHandler;

	/**
	 * Handle an application event.
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpServletResponse response = requestAttributes.getResponse();

		AuthenticationException authenticationException = event.getException();
		Authentication authentication = (Authentication) event.getSource();

		// 调用自定义业务实现
		if (failureHandler != null) {
			failureHandler.handle(authenticationException, authentication, request, response);
		}
	}

}
