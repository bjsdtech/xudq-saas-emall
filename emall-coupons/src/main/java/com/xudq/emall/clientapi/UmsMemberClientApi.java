package com.xudq.emall.clientapi;


import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.model.UmsMember;
import com.xudq.emall.clientapi.interceptor.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @desc: 类的描述:Feign远程调用用户服务接口
* @author: xudq
* @createDate:
* @version: 1.0
*/
@FeignClient(name = "emall-member", configuration = FeignConfig.class)
public interface UmsMemberClientApi {

    @RequestMapping(value = "/getCurrentMember", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<UmsMember> getCurrentMember();
}
