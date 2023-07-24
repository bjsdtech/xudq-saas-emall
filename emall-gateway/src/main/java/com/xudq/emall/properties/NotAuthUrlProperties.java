package com.xudq.emall.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;


/**
* @desc: 类的描述:网关跳过认证的配置类
* @author: xudq
* @createDate:
* @version: 1.0
*/
@Data
@ConfigurationProperties("xudq.gateway")
public class NotAuthUrlProperties {

    private LinkedHashSet<String> shouldSkipUrls;
}
