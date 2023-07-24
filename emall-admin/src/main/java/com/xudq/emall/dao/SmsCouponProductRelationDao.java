package com.xudq.emall.dao;

import com.xudq.emall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和产品关系自定义Dao
 */
public interface SmsCouponProductRelationDao {
    int insertList(@Param("list")List<SmsCouponProductRelation> productRelationList);
}
