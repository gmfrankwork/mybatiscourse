package com.mybatis.dao;


import com.mybatis.pojo.Category;

/**
 * @Classname UserMapper
 * @program: mybatiscourse->UserMapper
 * @description: 用户
 * @create: 2019-10-25 21:29
 * @Created by frank
 */
public interface CategoryMapper {
    Category findCategoryByIdStep(Integer id);
}
