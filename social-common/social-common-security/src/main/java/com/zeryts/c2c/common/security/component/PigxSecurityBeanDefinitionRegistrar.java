

package com.zeryts.c2c.common.security.component;

import com.zeryts.c2c.common.core.constant.SecurityConstants;
import com.zeryts.c2c.common.security.annotation.EnablePigxResourceServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zeryts
 * @date 2018-11-24
 */
@Slf4j
public class PigxSecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 根据注解值动态注入资源服务器的相关属性
	 * @param metadata 注解信息
	 * @param registry 注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		if (registry.isBeanNameInUse(SecurityConstants.RESOURCE_SERVER_CONFIGURER)) {
			log.warn("本地存在资源服务器配置，覆盖默认配置:" + SecurityConstants.RESOURCE_SERVER_CONFIGURER);
			return;
		}

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

		Boolean isLocal = (Boolean) metadata.getAnnotationAttributes(EnablePigxResourceServer.class.getName())
				.get("isLocal");
		if (isLocal) {
			beanDefinition.setBeanClass(PigxLocalResourceServerConfigurerAdapter.class);
		}
		else {
			beanDefinition.setBeanClass(PigxResourceServerConfigurerAdapter.class);
		}

		registry.registerBeanDefinition(SecurityConstants.RESOURCE_SERVER_CONFIGURER, beanDefinition);

	}

}
