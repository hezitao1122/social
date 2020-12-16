
package com.zeryts.c2c.common.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author zeryts
 * @date 2018/8/15
 */
public interface PigxUserDetailsService extends UserDetailsService {

	/**
	 * 根据社交登录code 登录
	 * @param code TYPE@CODE
	 * @return UserDetails
	 * @throws UsernameNotFoundException
	 */
	UserDetails loadUserBySocial(String code) throws UsernameNotFoundException;

}
