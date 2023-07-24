package com.xudq.emall.service.impl;


import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.domain.PmsProductParam;
import com.xudq.emall.mapper.PmsSkuStockMapper;
import com.xudq.emall.mapper.SmsFlashPromotionProductRelationMapper;
import com.xudq.emall.model.PmsSkuStock;
import com.xudq.emall.dao.FlashPromotionProductDao;
import com.xudq.emall.domain.CartPromotionItem;
import com.xudq.emall.model.SmsFlashPromotionProductRelation;
import com.xudq.emall.service.PmsProductService;
import com.xudq.emall.service.StockManageService;
import com.xudq.emall.util.RedisOpsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StockManageServiceImpl implements StockManageService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;

    @Autowired
    private SmsFlashPromotionProductRelationMapper flashPromotionProductRelationMapper;

    @Autowired
    private FlashPromotionProductDao flashPromotionProductDao;

    @Autowired
    private PmsProductService productService;

    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public Integer incrStock(Long productId, Long skuId, Integer quanlity, Integer miaosha, Long flashPromotionRelationId) {
        return null;
    }

    @Override
    public Integer descStock(Long productId, Long skuId, Integer quanlity, Integer miaosha, Long flashPromotionRelationId) {
        return null;
    }

    /**
     * 获取产品库存
     * @param productId
     * @param flashPromotionRelationId
     * @return
     */
    @Override
    public CommonResult<Integer> selectStock(Long productId, Long flashPromotionRelationId) {

        SmsFlashPromotionProductRelation miaoshaStock = flashPromotionProductRelationMapper.selectByPrimaryKey(flashPromotionRelationId);
        if(ObjectUtils.isEmpty(miaoshaStock)){
            return CommonResult.failed("不存在该秒杀商品！");
        }

        return CommonResult.success(miaoshaStock.getFlashPromotionCount());
    }

    @Override
    public CommonResult lockStock(List<CartPromotionItem> cartPromotionItemList) {
        try {

            for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
                PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(cartPromotionItem.getProductSkuId());
                skuStock.setLockStock(skuStock.getLockStock() + cartPromotionItem.getQuantity());
                skuStockMapper.updateByPrimaryKeySelective(skuStock);
            }
            return CommonResult.success(true);
        }catch (Exception e) {
            log.error("锁定库存失败...");
            return CommonResult.failed();
        }
    }

    //验证秒杀时间
    private boolean volidateMiaoShaTime(PmsProductParam product) {
        //当前时间
        Date now = new Date();
        //todo 查看是否有秒杀商品,秒杀商品库存
        if(product.getFlashPromotionStatus() != 1
                || product.getFlashPromotionEndDate() == null
                || product.getFlashPromotionStartDate() == null
                || now.after(product.getFlashPromotionEndDate())
                || now.before(product.getFlashPromotionStartDate())){
            return false;
        }
        return true;
    }

}
