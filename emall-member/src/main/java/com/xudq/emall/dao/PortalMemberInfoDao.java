package com.xudq.emall.dao;


import com.xudq.emall.domain.PortalMemberInfo;

/**
 * @author ：xudq
 * @date ：
 * @version: V1.0
 * @description: 会员信息获取
 **/
public interface PortalMemberInfoDao {
    /**
     * 查询会员信息
     * @param memberId
     * @return
     */
    PortalMemberInfo getMemberInfo(Long memberId);
}
