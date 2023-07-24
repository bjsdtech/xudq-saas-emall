package com.xudq.emall.portal.feignapi.ums;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.model.UmsMember;
import com.xudq.emall.model.UmsMemberReceiveAddress;
import com.xudq.emall.portal.domain.PortalMemberInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @desc: 类的描述:远程调用 会员中心获取具体收获地址
*/
@FeignClient(name = "emall-member",path = "/member")
public interface UmsMemberFeignApi {

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<UmsMemberReceiveAddress> getItem(@PathVariable(value = "id") Long id);

    @RequestMapping(value = "/center/updateUmsMember",method = RequestMethod.POST)
    CommonResult<String> updateUmsMember(@RequestBody UmsMember umsMember);


    @RequestMapping(value = "/center/getMemberInfo", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<PortalMemberInfo> getMemberById();

    @RequestMapping(value = "/address/list", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<List<UmsMemberReceiveAddress>> list();
}
