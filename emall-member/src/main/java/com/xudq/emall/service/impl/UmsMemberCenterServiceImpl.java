package com.xudq.emall.service.impl;


import com.xudq.emall.dao.PortalMemberInfoDao;
import com.xudq.emall.domain.PortalMemberInfo;
import com.xudq.emall.service.UmsMemberCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xudq
 * @date ：
 * @version: V1.0
 * @description: 
 **/
@Service
public class UmsMemberCenterServiceImpl implements UmsMemberCenterService {

    @Autowired
    private PortalMemberInfoDao portalMemberInfoDao;

    /**
     * 查询会员信息
     * @param memberId
     * @return
     */
    @Override
    public PortalMemberInfo getMemberInfo(Long memberId) {
        return portalMemberInfoDao.getMemberInfo(memberId);
    }
}
