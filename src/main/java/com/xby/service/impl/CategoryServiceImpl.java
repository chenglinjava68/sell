package com.xby.service.impl;

import com.xby.dataobject.ProductCategory;
import com.xby.repository.ProductCategoryRepository;
import com.xby.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :xby
 * @date :2019/1/22 10:58
 * @description :
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 根据商品类目id,查询类目
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    /**
     * 查询所有类目
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    /**
     * 根据类目编号查询所有类目
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    /**
     * 保存类目信息
     * @param productCategory
     * @return
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
