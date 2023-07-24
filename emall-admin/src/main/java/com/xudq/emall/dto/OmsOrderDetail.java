package com.xudq.emall.dto;

import com.xudq.emall.model.OmsOrder;
import com.xudq.emall.model.OmsOrderItem;
import com.xudq.emall.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
