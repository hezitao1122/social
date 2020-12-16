

package com.zeryts.c2c.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zeryts.c2c.common.security.component.SocialAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author zeryts
 * @date 2018/7/8
 */
@JsonSerialize(using = SocialAuth2ExceptionSerializer.class)
public class ServerErrorException extends PigxAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
