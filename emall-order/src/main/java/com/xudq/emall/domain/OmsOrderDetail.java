package com.xudq.emall.domain;

import com.xudq.emall.model.OmsOrder;
import com.xudq.emall.model.OmsOrderItem;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 */
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
