package com.xby.form;

import lombok.Data;

/**
 * @author :xby
 * @date :2019/2/7 20:57
 * @description :
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
