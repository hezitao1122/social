

package com.zeryts.c2c.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zeryts.c2c.common.core.constant.CommonConstants;
import com.zeryts.c2c.common.security.exception.PigxAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author zeryts
 * @date 2018/11/16
 * <p>
 * OAuth2 异常格式化
 */
public class SocialAuth2ExceptionSerializer extends StdSerializer<PigxAuth2Exception> {

	public SocialAuth2ExceptionSerializer() {
		super(PigxAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(PigxAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}

}
