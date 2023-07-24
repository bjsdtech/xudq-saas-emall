package com.xudq.emall.component.trade.alipay.model.hb;


public interface TradeInfo {
    // 获取交易状态
    public HbStatus getStatus();

    // 获取交易时间
    public double getTimeConsume();
}
