package com.xby.repository;

import com.xby.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/22 17:20
 * @description :
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    //根据商品状态查询商品信息，0正常，1下架
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
