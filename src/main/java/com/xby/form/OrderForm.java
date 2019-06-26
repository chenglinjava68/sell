package com.xby.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author :xby
 * @date :2019/1/27 14:28
 * @description :
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "手机格式错误")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
