package com.xudq.emall.service;


import com.xudq.emall.domain.MemberBrandAttention;

import java.util.List;

/**
 * 会员关注Service
 */
public interface MemberAttentionService {
    /**
     * 添加关注
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     */
    int delete(Long memberId, Long brandId);

    /**
     * 获取用户关注列表
     */
    List<MemberBrandAttention> list(Long memberId);
}
