package com.mybatis.pojo;

/**
 * @Classname User
 * @program: mybatiscourse->User
 * @description: 用户
 * @create: 2019-10-25 21:19
 * @Created by frank
 */
public class Product {

    private Integer id;
    private String name;
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
