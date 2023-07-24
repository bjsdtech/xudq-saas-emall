package com.xudq.emall.controller;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.service.impl.Transaction2PcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Transaction2PcController {
    @Autowired
    private Transaction2PcServiceImpl service;

    @GetMapping("/sharding/2pc_transaction")
    public CommonResult insertIn2Pc(){
        //TransactionTypeHolder.set(TransactionType.XA);
        return service.insertOrder();
    }

    @GetMapping("/sharding/select")
    public CommonResult select(@RequestHeader("memberId") Long memberId){
        return service.selectOrder(memberId);
    }
}
