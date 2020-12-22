

package com.zeryts.c2c.common.security.annotation;

import com.zeryts.c2c.common.security.component.SocialResourceServerAutoConfiguration;
import com.zeryts.c2c.common.security.component.SocialSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author zeryts
 * @date 2018/11/10
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ SocialResourceServerAutoConfiguration.class, SocialSecurityBeanDefinitionRegistrar.class })
public @interface EnableSocialResourceServer {

	/**
	 * 是否开启本地模式
	 * @return true
	 */
	boolean isLocal() default true;

}
