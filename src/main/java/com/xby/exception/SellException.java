package com.xby.exception;

import com.xby.enums.ResultEnum;
import lombok.Getter;

/**
 * @author :xby
 * @date :2019/1/25 16:31
 * @description :
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
