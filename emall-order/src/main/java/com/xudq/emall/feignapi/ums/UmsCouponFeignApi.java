package com.xudq.emall.feignapi.ums;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.domain.CartPromotionItem;
import com.xudq.emall.domain.SmsCouponHistoryDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* @desc: 类的描述:会员优惠卷服务
* @author:
* @createDate:
* @version: 1.0
*/
@FeignClient(name = "emall-coupons",path = "/coupon")
public interface UmsCouponFeignApi {

    @RequestMapping(value = "/listCart", method = RequestMethod.POST)
    @ResponseBody
    CommonResult<List<SmsCouponHistoryDetail>> listCart2Feign(@RequestParam("type") Integer type,
                                                                     @RequestBody List<CartPromotionItem> cartPromotionItemList);

}
