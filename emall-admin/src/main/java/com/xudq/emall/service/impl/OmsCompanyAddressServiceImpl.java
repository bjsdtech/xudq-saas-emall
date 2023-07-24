package com.xudq.emall.service.impl;

import com.xudq.emall.mapper.OmsCompanyAddressMapper;
import com.xudq.emall.model.OmsCompanyAddress;
import com.xudq.emall.model.OmsCompanyAddressExample;
import com.xudq.emall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
