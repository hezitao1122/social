package com.zeryts.c2c.social.govern.report;

import com.zeryts.c2c.inter.ServerB;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zeryts
 * @description: 测试用的server类
 * ```````````````````````````
 * @title: TestServer
 * @projectName c2c-shop
 * @date 2020/11/8 20:58
 */
@Service(
    version = "1.0.0",
    interfaceClass = ServerB.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class TestServer implements ServerB {

    @Override
    public String get(String name) {
        return "hello " + name;
    }
}
