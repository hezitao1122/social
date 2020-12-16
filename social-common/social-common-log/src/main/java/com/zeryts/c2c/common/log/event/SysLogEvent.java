package com.zeryts.c2c.common.log.event;

import com.zeryts.c2c.admin.api.dto.SysLogDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zeryts 系统日志事件
 */
@Getter
@AllArgsConstructor
public class SysLogEvent {

	private final SysLogDTO sysLog;

}
