package com.xudq.emall.portal.dao;

import com.xudq.emall.portal.domain.PmsCommentParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortalProductCommentDao {

    List<PmsCommentParam> getCommentList(Long productId);

    Integer selectUserOrder(@Param("userId") Long userId, @Param("productId") Long productId);
}
