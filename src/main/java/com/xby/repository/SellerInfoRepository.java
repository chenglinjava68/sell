package com.xby.repository;

import com.xby.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :xby
 * @date :2019/2/8 9:54
 * @description :
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    //根据卖家openid查询卖家信息
    SellerInfo findByOpenid(String openid);
}
