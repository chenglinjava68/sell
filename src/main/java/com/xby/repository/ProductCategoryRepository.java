package com.xby.repository;

import com.xby.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/20 19:53
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    //根据类目编号查询商品类目
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryListType);
}
