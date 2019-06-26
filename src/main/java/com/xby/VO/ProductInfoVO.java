package com.xby.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author :xby
 * @date :2019/1/23 17:11
 * @description :商品详情
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 6022308131289857602L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
