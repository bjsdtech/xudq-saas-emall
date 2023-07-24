package com.xudq.emall.service;


import com.xudq.emall.domain.PortalMemberInfo;

/**
 * @author ：xudq
 * @date
 * @version: V1.0
 * @description:
 **/
public interface UmsMemberCenterService {

    /**
     * 查询会员信息
     * @param memberId
     * @return
     */
    PortalMemberInfo getMemberInfo(Long memberId);
}
