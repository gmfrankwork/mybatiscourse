package com.mybatis.pojo;

import java.util.List;

/**
 * @Classname UserInfo
 * @program: mybatiscourse->UserInfo
 * @description: 用户信息
 * @create: 2019-10-25 21:23
 * @Created by frank
 */
public class Category {

    private Integer id;

    private String name;

    private List<Product> productList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
