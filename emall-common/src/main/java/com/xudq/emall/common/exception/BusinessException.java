package com.xudq.emall.common.exception;

/**
 * @author ：xudq
 * @date ：
 * @version: V1.0
 * @description: 业务异常
 **/
public class BusinessException extends Exception {

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
    }

}
