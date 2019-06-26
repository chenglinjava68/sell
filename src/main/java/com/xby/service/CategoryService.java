package com.xby.service;

import com.xby.dataobject.ProductCategory;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/22 10:42
 * @description :类目
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
