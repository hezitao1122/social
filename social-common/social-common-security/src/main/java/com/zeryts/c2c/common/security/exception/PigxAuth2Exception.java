

package com.zeryts.c2c.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zeryts.c2c.common.security.component.SocialAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author zeryts
 * @date 2018/7/8 自定义OAuth2Exception
 */
@JsonSerialize(using = SocialAuth2ExceptionSerializer.class)
public class PigxAuth2Exception extends OAuth2Exception {

	@Getter
	private String errorCode;

	public PigxAuth2Exception(String msg) {
		super(msg);
	}

	public PigxAuth2Exception(String msg, Throwable t) {
		super(msg, t);
	}

	public PigxAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

}
