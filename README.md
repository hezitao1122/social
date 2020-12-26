# c2c-shop-dubbo
为搭建平台的项目
## 一、social-auth
基于spring security oAuth2的授权认证中心
### 二、social-common
   是封装的依赖组件等信息
##### 1.social-common-bom
   声明了一些依赖，版本号统一管理，避免在项目中随意声明依赖版本，导致整个项目的框架版本号不一致
#### 2.social-common-core
   声明一些工具类和核心配置,例如web的时间转换   
   JSON转换  
   RestTemplate声明  
   枚举信息  
   定义的静态常量  
   自定义的异常     
   自定义注解   
   常用的工具类等
#### 3.social-common-data
   声明了与数据操作相关的一些配置信息  
   配置了Redis的配置  
   配置了MyBatis和MyBatis-plus的信息
   封装了MyBatis的一些通用查询
#### 4.social-common-feign
   配置了Spring-cloud-feign相关的信息
#### 5.social-common-gateway
   配置了一些网关的通用信息  
    如动态路由的配置  
    网管灰度发布的配置  
    负载均衡的策略  
#### 6.social-common-grey
   配置了一些灰度路由的信息  
   主要功能为通过请求的某些参数,将灰度请求打到指定的服务中
#### 7.social-common-log
   配置了服务启动的日志信息  
   可以通过@SysLog日志注解,将日志通过feign调用保存至数据库中  
   包含了一些日志初始化配置  
   加上SysLog则会打印类\方法调用信息
#### 8.social-common-oss
   存储文件系统  
   兼容许多云存储,如:  
   阿里云OSS，腾讯云COS，七牛云，京东云，minio等.
#### 9.social-common-security
   安全工具类模块,主要是做一些权限认证授权，基于spring-cloud-starter-oauth2
   例如用户登录  
   Token管理  
   接口权限管理  
   用户管理  
   第三方登录（如QQ、微信登录）  
   扫码登录等
#### 10.social-common-sentinel
   限流熔断模块,基于spring-alibaba-sentinel  
   配置了限流熔断模块的初始化配置  
   错误页面跳转  
   降级等信息
#### 11.social-common-swagger
   配置了swagger的初始化信息.测试环境可以使用,但是生辰环境得关闭  
   基于swagger2
#### 12.social-common-xss
   配置了一些安全过滤插件 基于 JSOUP    
### 三、social-goven
   存放的为社会治理平台项目,技术栈主要为spring-alibaba
   注册中心和配置中心使用的为nacos
   RPC框架使用的为dubbo
   分布式事务使用的为seata
   数据源使用的为druid
   限流熔断组件使用的为sentinel
   流控的监控平台在social-visual之中     
   
   
      