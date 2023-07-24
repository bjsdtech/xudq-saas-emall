package com.xudq.emall.service;

import com.xudq.emall.model.OmsCartItem;
import com.xudq.emall.domain.CartPromotionItem;

import java.util.List;

/**
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
