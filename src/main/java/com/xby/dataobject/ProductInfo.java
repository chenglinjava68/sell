package com.xby.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xby.enums.ProductStatusEnum;
import com.xby.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author :xby
 * @date :2019/1/22 16:22
 * @description :
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;
    /** 商品名称*/
    private String productName;
    /** 单价*/
    private BigDecimal productPrice;
    /** 库存*/
    private Integer productStock;
    /**描述*/
    private  String productDescription;
    /**小图*/
    private  String productIcon;
    /** 状态 0正常1下架*/
    private  Integer productStatus = ProductStatusEnum.UP.getCode();
    /**类目编号*/
    private Integer categoryType;

    public Date createTime;

    public Date updateTime;

    //使用@JsonIgnore返回的json数据即不包含该属性。
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
