package com.xby.service;

import com.xby.dataobject.SellerInfo;

/**
 * @author :xby
 * @date :2019/2/8 10:13
 * @description :卖家端
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
