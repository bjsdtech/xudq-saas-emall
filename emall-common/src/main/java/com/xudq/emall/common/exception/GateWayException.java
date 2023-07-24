package com.xudq.emall.common.exception;


import com.xudq.emall.common.api.IErrorCode;
import lombok.Data;

/**
* @desc: 类的描述:网关异常类
* @author: xudq
* @createDate:
* @version: 1.0
*/
@Data
public class GateWayException extends RuntimeException{

    private long code;

    private String message;

    public GateWayException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }
}
