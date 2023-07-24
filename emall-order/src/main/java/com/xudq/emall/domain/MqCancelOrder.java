package com.xudq.emall.domain;

import lombok.Data;

/**
* @desc: 类的描述:mq取消订单封装对象
* @author: xudq
* @createDate:
* @version: 1.0
*/
@Data
public class MqCancelOrder {

    private Long orderId;

    private Long memberId;
}
