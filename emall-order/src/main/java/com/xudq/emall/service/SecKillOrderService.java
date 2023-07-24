package com.xudq.emall.service;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.common.exception.BusinessException;
import com.xudq.emall.domain.OrderParam;
import com.xudq.emall.domain.PmsProductParam;
import com.xudq.emall.model.OmsOrder;
import com.xudq.emall.model.OmsOrderItem;

/**
 * @author ：
 * @date ：
 * @version: V1.0
 * @description:
 **/
public interface SecKillOrderService {

    /**
     * 秒杀订单确认
     * @param productId
     * @param memberId
     * @return
     */
    CommonResult generateConfirmMiaoShaOrder(Long productId
            , Long memberId,String token) throws BusinessException;

    /**
     * 秒杀订单下单
     * @param orderParam
     * @param memberId
     * @return
     */
    CommonResult generateSecKillOrder(OrderParam orderParam, Long memberId,String token) throws BusinessException;

    /**
     * 还原redis库存,每次加1
     * @param productId
     */
    void incrRedisStock(Long productId);

    /**
     * 判断是否应该pub消息清除集群服务本地的售罄标识
     * @param productId
     * @return
     */
    boolean shouldPublishCleanMsg(Long productId);

    /**
     * 异步下单
     * @param order
     * @param orderItem
     * @param flashPromotionRelationId
     * @return
     */
    Long asyncCreateOrder(OmsOrder order, OmsOrderItem orderItem, Long flashPromotionRelationId);

    /**
     * 获取产品信息
     * @param productId
     * @return
     */
    PmsProductParam getProductInfo(Long productId);

}
