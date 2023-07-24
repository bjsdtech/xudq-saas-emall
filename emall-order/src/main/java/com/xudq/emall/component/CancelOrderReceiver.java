package com.xudq.emall.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xudq.emall.domain.MqCancelOrder;
import com.xudq.emall.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 取消订单消息的处理者
 */
@Component

public class CancelOrderReceiver {
    private static Logger LOGGER =LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitListener(queues = "mall.order.cancel")
    @RabbitHandler
    public void handle(Message message) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        MqCancelOrder mqCancelOrder = objectMapper.readValue(message.getBody(), MqCancelOrder.class);

        LOGGER.info("取消订单对象:{}",mqCancelOrder);
        portalOrderService.cancelOrder(mqCancelOrder.getOrderId(),mqCancelOrder.getMemberId());
        LOGGER.info("process orderId:{}",mqCancelOrder.getOrderId());
    }
}
