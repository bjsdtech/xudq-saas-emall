## 数动电商平台服务介绍

`xudq-saas-emall`是一套基于微服务技术架构的电子商城系统，前端后端分离部署，采用了 Vue、Spring Boot、MyBatis、Docker、Elasticsearch等核心技术快速搭建系统。

## 业务功能
``` lua
业务体系支持：
1、采购中心
   ├── 商品供应商及商家后台管理；
   ├── 产品中心；
   ├── 导购中心（频道、专题、搜索及商品展示系统）；
   ├── 营销推广中心（会员、购物卡、优惠卷）
   ├── 预订中心（常规售卖系统、购物车系统；暂不支持拍卖和预售）、
   ├── 订单中心 
2.支付中心（支持对接xudq-saas-paycore服务[ttps://github.com/bjsdtech/xudq-saas-paycore.git]，完成充值、消费、提现、退款等支付服务）。
```

## 系统模块结构
``` lua
emall
├── emall-common -- 工具类及通用代码模块
├── emall-mbg -- MyBatisGenerator生成的数据库操作代码模块
├── emall-security -- 封装SpringSecurity+JWT的安全认证的模块
├── emall-search -- 基于Elasticsearch的商品搜索系统服务
├── emall-admin -- 商户管理系统服务
├── emall-portal -- 电子商城系统服务
```

## 技术选型


### 前端技术

| 技术       | 说明                  | 官网                                                         |
| ---------- | --------------------- | ------------------------------------------------------------ |
| Vue        | 前端框架              | [https://vuejs.org/](https://vuejs.org/)                     |
| Vue-router | 路由框架              | [https://router.vuejs.org/](https://router.vuejs.org/)       |
| Vuex       | 全局状态管理框架      | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)           |
| Element    | 前端UI框架            | [https://element.eleme.io/](https://element.eleme.io/)       |
| Axios      | 前端HTTP框架          | [https://github.com/axios/axios](https://github.com/axios/axios) |
| v-charts   | 基于Echarts的图表框架 | [https://v-charts.js.org/](https://v-charts.js.org/)         |

### 后端技术

| 技术                 | 说明                | 官网                                                         |
| -------------------- | ------------------- | ------------------------------------------------------------ |
| Spring Boot          | 容器+MVC框架        | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
| Spring Security      | 认证和授权框架      | [https://spring.io/projects/spring-security](https://spring.io/projects/spring-security) |
| MyBatis              | ORM框架             | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html) |
| MyBatisGenerator     | 数据层代码生成      | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html) |
| PageHelper           | MyBatis物理分页插件 | [http://git.oschina.net/free/Mybatis_PageHelper](http://git.oschina.net/free/Mybatis_PageHelper) |
| Swagger-UI           | 文档生产工具        | [https://github.com/swagger-api/swagger-ui](https://github.com/swagger-api/swagger-ui) |
| Elasticsearch        | 搜索引擎            | [https://github.com/elastic/elasticsearch](https://github.com/elastic/elasticsearch) |
| RabbitMq             | 消息队列            | [https://www.rabbitmq.com/](https://www.rabbitmq.com/)       |
| Redis                | 分布式缓存          | [https://redis.io/](https://redis.io/)                       |
| MongoDb              | NoSql数据库         | [https://www.mongodb.com/](https://www.mongodb.com/)         |
| Docker               | 应用容器引擎        | [https://www.docker.com/](https://www.docker.com/)           |
| Druid                | 数据库连接池        | [https://github.com/alibaba/druid](https://github.com/alibaba/druid) |
| OSS                  | 对象存储            | [https://github.com/aliyun/aliyun-oss-java-sdk](https://github.com/aliyun/aliyun-oss-java-sdk) |
| JWT                  | JWT登录支持         | [https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt) |
| LogStash             | 日志收集            | [https://github.com/logstash/logstash-logback-encoder](https://github.com/logstash/logstash-logback-encoder) |
| Lombok               | 简化对象封装工具    | [https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok) |
| Seata                | 全局事务管理框架    | [https://github.com/seata/seata](https://github.com/seata/seata) |
| Portainer            | 可视化Docker容器管理| [https://github.com/portainer/portainer](https://github.com/portainer/portainer) |


## 环境搭建

### 开发环境

工具 | 版本号 | 下载
----|----|----
JDK | 1.8 | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Mysql | 5.8 | https://www.mysql.com/
Redis | 3.2 | https://redis.io/download
Elasticsearch | 6.2.2 | https://www.elastic.co/downloads
MongoDb | 3.2 | https://www.mongodb.com/download-center
RabbitMq | 3.7.14 | http://www.rabbitmq.com/download.html
nginx | 1.10 | http://nginx.org/en/download.html


### 项目启动
项目启动需要使用nacos导入document/nacos-config/nacos_config_export.zip压缩包，不需要解压，直接导入即可。

### 异步下单注意
需要添加RocketMQ的配置,配置添加到Nacos配置文件当中: emall-order.yml
```
rocketmq:
  name-server: 127.0.0.1:9876 #连接超时时间
  producer:
    send-message-timeout: 30000 #发送消息超时时间
    group: order-group
  emall:
    scheduleTopic: order-status-check #定时任务
    cancelGroup: cancel-order #消费组业务逻辑,取消超时未支付订单
    transGroup: cart-delete #事务消息群组
    transTopic: order-cart #订单-购物车topic
    asyncOrderTopic: async-order #异步订单topic
    asyncOrderGroup: async-order-group #异步下单消息消费
```
## 联系方式
Email：2558404588@qq.com
