package com.xby.repository;

import com.xby.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author :xby
 * @date :2019/1/20 19:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

        @Autowired
        private ProductCategoryRepository repository;

        @Test
        public void findOneTest() throws Exception{
            ProductCategory productCategory = repository.findOne(1);
            System.out.println(productCategory.toString());
        }

        @Test
        @Transactional
        public void saveTest() {
            ProductCategory productCategory = new ProductCategory("大众最爱" ,3);
            ProductCategory result = repository.save(productCategory);
            Assert.assertNotNull(result);
        }

        /** 一次性查询所有类目 */
        public void  findByCategoryTypeIn() {
            List<Integer> list = Arrays.asList(2,3,4);
            List<ProductCategory> result = repository.findByCategoryTypeIn(list);
            Assert.assertNotEquals(0,result.size());
        }

}