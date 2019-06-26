package com.xby.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author :xby
 * @date :2019/1/23 16:05
 * @description :商品（包含类目）
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 6161394431707189000L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
