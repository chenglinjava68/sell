package com.xby.enums;

import lombok.Getter;

/**
 * @author :xby
 * @date :2019/1/22 19:19
 * @description :商品状态
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
