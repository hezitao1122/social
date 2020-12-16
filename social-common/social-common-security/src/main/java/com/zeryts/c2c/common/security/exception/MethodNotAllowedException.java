

package com.zeryts.c2c.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zeryts.c2c.common.security.component.SocialAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zeryts
 * @date 2018/7/8
 */
@JsonSerialize(using = SocialAuth2ExceptionSerializer.class)
public class MethodNotAllowedException extends PigxAuth2Exception {

	public MethodNotAllowedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
