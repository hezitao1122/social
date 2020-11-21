package com.zeryts.c2c.serverb;

import com.zeryts.c2c.inter.ServerB;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zeryts
 * @description: 测试调用的controller类
 * ```````````````````````````
 * @title: TestController
 * @projectName c2c-shop
 * @date 2020/11/8 21:38
 */
@RestController
public class TestController {

    @Reference(
            version = "1.0.0",
            interfaceClass = ServerB.class,
            cluster = "failfast"
    )
    private ServerB serverB;

    @GetMapping("/hello")
    public String hello(){
        return serverB.get("zeryts");
    }


}
