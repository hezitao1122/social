/*
 *    Copyright (c) 2018-2025, zeryts All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: zeryts (wangiegie@gmail.com)
 */

package com.zeryts.c2c.common.swagger.annotation;

import com.zeryts.c2c.common.swagger.config.GatewaySwaggerAutoConfiguration;
import com.zeryts.c2c.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @author zeryts
 * @date 2020/10/2 开启social swagger
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@Import({ SwaggerAutoConfiguration.class, GatewaySwaggerAutoConfiguration.class })
public @interface EnableSocialSwagger2 {

}
