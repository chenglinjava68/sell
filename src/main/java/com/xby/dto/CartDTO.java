package com.xby.dto;

import lombok.Data;

/**
 * @author :xby
 * @date :2019/1/25 17:10
 * @description :购物车
 */
@Data
public class CartDTO {
    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
