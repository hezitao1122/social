

package com.zeryts.c2c.common.sentinel.parser;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zeryts
 * @date 2019-10-11
 * <p>
 * sentinel 请求头解析判断
 */
public class PigxHeaderRequestOriginParser implements RequestOriginParser {

	/**
	 * 请求头获取allow
	 */
	private static final String ALLOW = "Allow";

	/**
	 * Parse the origin from given HTTP request.
	 * @param request HTTP request
	 * @return parsed origin
	 */
	@Override
	public String parseOrigin(HttpServletRequest request) {
		return request.getHeader(ALLOW);
	}

}
