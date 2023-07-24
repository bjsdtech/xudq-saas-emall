package com.xudq.emall.clientapi;

import com.xudq.emall.common.api.CommonResult;
import com.xudq.emall.clientapi.interceptor.config.FeignConfig;
import com.xudq.emall.domain.CartPromotionItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**

* @desc: 类的描述:远程调用订单中心购物车详细客户端
* @author: xudq
* @createDate:
* @version: 1.0
*/
@FeignClient(name = "emall-order",configuration = FeignConfig.class)
public interface OmsCartItemClientApi {

    @RequestMapping(value = "/cart/list/promotion", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<List<CartPromotionItem>> listPromotionByMemberId();

}
