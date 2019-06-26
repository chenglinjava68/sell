package com.xby.service;

import com.xby.dataobject.ProductInfo;
import com.xby.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/22 19:07
 * @description : 商品
 */
public interface ProductService {

    /**查询单个商品*/
    ProductInfo findOne(String productId);

    /**查询所有在架商品*/
    List<ProductInfo> findUpAll();

    /**分页查询所有商品*/
    Page<ProductInfo> findAll(Pageable pageable);

    /**保存商品信息*/
    ProductInfo save(ProductInfo productInfo);

    /** 加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减库存 */
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 上架 */
    ProductInfo onSale(String productId);

    /** 下架 */
    ProductInfo offSale(String productId);
}
