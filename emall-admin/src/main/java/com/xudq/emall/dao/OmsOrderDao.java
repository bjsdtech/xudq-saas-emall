package com.xudq.emall.dao;

import com.xudq.emall.dto.OmsOrderDeliveryParam;
import com.xudq.emall.dto.OmsOrderDetail;
import com.xudq.emall.dto.OmsOrderQueryParam;
import com.xudq.emall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
