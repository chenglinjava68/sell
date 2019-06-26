package com.xby.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author :xby
 * @date :2019/2/7 16:28
 * @description :
 */
@Data
public class  ProductForm {


    private String productId;

    /** 名字. */
    protected String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}

