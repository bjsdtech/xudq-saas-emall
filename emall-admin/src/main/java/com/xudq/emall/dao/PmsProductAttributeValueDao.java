package com.xudq.emall.dao;

import com.xudq.emall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Da
 */
public interface PmsProductAttributeValueDao {
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
