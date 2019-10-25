package com.mybatis.dao;

import com.mybatis.day1.Employee;
import com.mybatis.day2.EmployeeLazyMapper;
import com.mybatis.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Classname ProductMapperTest
 * @program: mybatiscourse->ProductMapperTest
 * @description:
 * @create: 2019-10-25 21:44
 * @Created by frank
 */
public class ProductMapperTest {

    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void test() throws IOException {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            Product product = productMapper.findByIdStep(1);
            System.out.println(product.getName());
            System.out.println(product.getCategory().getName());
        } finally {
            sqlSession.close();
        }
    }
    }