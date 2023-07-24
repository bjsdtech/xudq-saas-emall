package com.xudq.emall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by xudq
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.xudq.emall.mapper","com.xudq.emall.portal.dao","com.xudq.emall.dao"})
public class MyBatisConfig {
}
