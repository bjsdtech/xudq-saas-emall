/**
 * 
 */
package com.xudq.emall.common.api;

import lombok.Data;

import java.util.Map;

/**
*
* @desc: 类的描述:认证服务器返回的TokenInfo的封装
* @author: xudq
* @createDate:
* @version: 1.0
*/
@Data
public class TokenInfo {

	private String access_token;

	private String token_type;

	private String refresh_token;
	
	private String scope;
	
	private Map<String,String> additionalInfo;
 	
}
