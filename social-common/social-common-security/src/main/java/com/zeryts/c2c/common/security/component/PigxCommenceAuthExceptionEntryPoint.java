

package com.zeryts.c2c.common.security.component;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeryts.c2c.common.core.constant.CommonConstants;
import com.zeryts.c2c.common.core.util.R;
import com.zeryts.c2c.common.security.util.PigxSecurityMessageSourceUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 异常处理 {@link org.springframework.security.core.AuthenticationException } 不同细化异常处理
 *
 * @author zeryts
 * @date 2020-06-14
 */
@Slf4j
@Component
@AllArgsConstructor
public class PigxCommenceAuthExceptionEntryPoint implements AuthenticationEntryPoint {

	private final ObjectMapper objectMapper;

	@Override
	@SneakyThrows
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) {
		response.setCharacterEncoding(CommonConstants.UTF8);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		R<String> result = new R<>();
		result.setMsg(authException.getMessage());
		result.setData(authException.getMessage());
		result.setCode(CommonConstants.FAIL);

		if (authException instanceof CredentialsExpiredException
				|| authException instanceof InsufficientAuthenticationException) {
			String msg = PigxSecurityMessageSourceUtil.getAccessor().getMessage(
					"AbstractUserDetailsAuthenticationProvider.credentialsExpired", authException.getMessage());
			result.setMsg(msg);
		}

		if (authException instanceof UsernameNotFoundException) {
			String msg = PigxSecurityMessageSourceUtil.getAccessor().getMessage(
					"AbstractUserDetailsAuthenticationProvider.noopBindAccount", authException.getMessage());
			result.setMsg(msg);
		}

		if (authException instanceof BadCredentialsException) {
			String msg = PigxSecurityMessageSourceUtil.getAccessor().getMessage(
					"AbstractUserDetailsAuthenticationProvider.badClientCredentials", authException.getMessage());
			result.setMsg(msg);
		}

		response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
		PrintWriter printWriter = response.getWriter();
		printWriter.append(objectMapper.writeValueAsString(result));
	}

}
