package com.xudq.emall.service.impl;

import com.xudq.emall.mapper.CmsPrefrenceAreaMapper;
import com.xudq.emall.model.CmsPrefrenceArea;
import com.xudq.emall.model.CmsPrefrenceAreaExample;
import com.xudq.emall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
