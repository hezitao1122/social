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