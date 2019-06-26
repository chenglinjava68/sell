package com.xby.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author :xby
 * @date :2019/2/8 9:49
 * @description : 卖家信息
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    /** 微信openid */
    private String openid;
}
