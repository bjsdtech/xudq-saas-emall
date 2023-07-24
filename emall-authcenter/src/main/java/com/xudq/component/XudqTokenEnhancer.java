package com.xudq.component;

import com.xudq.emall.domain.MemberDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
*
* @desc: 类的描述:jwt自定义增强器(根据自己的业务需求添加非敏感字段)
* @author:
* @createDate:
* @version: 1.0
*/
public class XudqTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();

        final Map<String, Object> retMap = new HashMap<>();

        //todo 这里暴露memberId到Jwt的令牌中,后期可以根据自己的业务需要 进行添加字段
        additionalInfo.put("memberId",memberDetails.getUmsMember().getId());
        additionalInfo.put("nickName",memberDetails.getUmsMember().getNickname());
        additionalInfo.put("integration",memberDetails.getUmsMember().getIntegration());

        retMap.put("additionalInfo",additionalInfo);

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(retMap);

        return accessToken;
    }
}
